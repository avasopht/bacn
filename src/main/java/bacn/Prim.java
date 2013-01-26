package bacn;

public class Prim implements Comparable<Prim> {
  
  private enum ValueType {
    INVALID,
    NULL,
    STRING,
    INTEGER,
    FLOAT,
    DOUBLE,
    LONG
  }
  
  public Prim() {}
  
  public Prim(Object value) {
    setTo(value);
  }
  
  public Prim setTo(Object value) {
    if(mValue != null) {
      assert(value.getClass().isPrimitive()) : "Only primitive types should be stores, such as integers, shorts, floats, etc.";
      
      // Safely convert the object to its string value if it is not a primitive.
      if(value.getClass().isPrimitive()) {
        value = value.toString();
      }
      
      // Convert shorts to integer valus.
      if(value.getClass() == Short.class) {
        value = new Integer((Short) value);
      }
      
      // Convert bytes to integer values.
      if(value.getClass() == Byte.class) {
        value = new Integer((Byte) value);
      }
    }
    
    mValue = value;
    return this;
  }

  public String asString() {
    if(hasString()) {
      return (String)mValue;
    }
    return null;
  }
  
  public boolean isNull() {
    return mValue == null;
  }
  
  public Integer asInteger() {
    if(hasInteger()) {
      return (Integer)mValue;
    }
    
    return null;
  }
  
  private ValueType getValueType() {
    if(hasString()) {
      return ValueType.STRING;
    }
    
    if(hasInteger()) {
      return ValueType.INTEGER;
    }
    
    if(hasLong()) {
      return ValueType.LONG;
    }
    
    if(hasFloat()) {
      return ValueType.FLOAT;
    }
    
    if(hasDouble()) {
      return ValueType.DOUBLE;
    }
    
    return ValueType.INVALID;
  }
  
  public Long asLong() {
    if(hasLong()) {
      return (Long) mValue;
    }
    
    return null;
  }
  
  public Double asDouble() {
    if(hasDouble()) {
      return (Double) mValue;
    }
    
    return null;
  }
  
  public Float asFloat() {
    if(hasFloat()) {
      return (Float) mValue;
    }
    
    return null;
  }
  
  public Boolean asBoolean() {
    if(hasBoolean()) {
      return (Boolean) mValue;
    }
    
    return null;
  }
  
  @Override
  public boolean equals(Object o) {
    if(o == null || o.getClass() != this.getClass()) {
      return false;
    }
    
    Prim rhs = (Prim)o;
    return compareTo(rhs) == 0;
    
  }
  
  public boolean hasValue() {
    return mValue != null;
  }
  
  public boolean hasString() {
    return has(String.class);
  }
  
  public boolean hasInteger() {
    return has(Integer.class);
  }
  
  public boolean hasFloat() {
    return has(Float.class);
  }
  
  public boolean hasDouble() {
    return has(Double.class);
  }
  
  public boolean hasLong() {
    return has(Long.class);
  }
  
  public boolean hasBoolean() {
    return has(Boolean.class);
  }
  
  private boolean has(Class<?> clazz) {
    return hasValue() && mValue.getClass() == clazz;
  }
  
  private Object mValue;
  
  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((mValue == null) ? 0 : mValue.hashCode());
    return result;
  }
  
  public static <T extends Comparable<T>> Prim create(T value) {
    return new Prim(value);
  }
  
  @Override
  public int compareTo(Prim rhs) {
    if(eitherValueIsNull(this, rhs)) {
      return calculateNullValueComparison(this, rhs);
    }
    
    if(eitherValueIsNull(mValue, rhs.mValue)) {
      return calculateNullValueComparison(mValue, rhs.mValue);
    }

    boolean haveDifferentValueType = getValueType() != rhs.getValueType();
    if(haveDifferentValueType) {
      assert(false);
      return 0;
    }
    
    return compareTo(this, rhs, getValueType());
  }
  
  
  private int compareTo(Prim lhs, Prim rhs, ValueType valueType) {
    assert(lhs.getValueType() == rhs.getValueType());
    
    switch(valueType) {
      case DOUBLE:
        return new Double(lhs.asDouble()).compareTo(new Double(rhs.asDouble()));
      case FLOAT:
        return new Float(lhs.asFloat()).compareTo(new Float(rhs.asFloat()));
      case INTEGER:
        return new Integer(lhs.asInteger()).compareTo(new Integer(rhs.asInteger()));
      case INVALID:
        // Should not reach here, assert would have already been thrown with upon entry to this function.
        return 0;
      case LONG:
        return new Long(lhs.asLong()).compareTo(new Long(rhs.asLong()));
      case NULL:
        return calculateNullValueComparison(lhs.isNull(), rhs.isNull());
      case STRING:
        return new String(lhs.asString()).compareTo(rhs.asString());
      default:
        // Another code path that should not have been reached.
        return 0;
      
    }
  }
  
  public static boolean eitherValueIsNull(Object first, Object second) {
    return first == null || second == null;
  }
  
  private static  int calculateNullValueComparison(Object lhs, Object rhs) {
    return calculateNullComparisonValue(lhs) - calculateNullComparisonValue(rhs);
  }
  
  private static int calculateNullComparisonValue(Object o) {
    return o == null ? -1 : 1;
  }
  
  @Override
  public String toString() {
    if(isNull()) {
      return "*null*";
    }
    
    return mValue.toString();
  }
  
  
}

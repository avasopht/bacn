package bacn;

public class Prim<T extends Comparable<T>> implements Comparable<Prim<T>>{
  public Prim<T> setTo(T value) { mValue = value; return this; }
  public T get() { return mValue; }
  
  public Prim() {}
  
  public Prim(T value) {
    mValue = value;
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
  
  private T mValue;

  public static <T extends Comparable<T>> Prim<T> create(T value) {
    return new Prim<T>(value);
  }
  
  @Override
  public int compareTo(Prim<T> rhs) {
    if(eitherValueIsNull(this, rhs)) {
      return calculateNullValueComparison(this, rhs);
    }
    
    if(eitherValueIsNull(get(), rhs.get())) {
      return calculateNullValueComparison(get(), rhs.get());
    }
    
    return get().compareTo(rhs.get());
  }
  
  public static <T extends Comparable<T>> boolean eitherValueIsNull(T first, T second) {
    return first == null || second == null;
  }
  
  private static <T extends Comparable<T>> int calculateNullValueComparison(T lhs, T rhs) {
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

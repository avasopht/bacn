package kbacon;

public class Prim<T> {
  public Prim<T> setTo(T value) { mValue = value; return this; }
  public T get() { return mValue; }
  
  public Prim() {}
  
  public Prim(T value) {
    mValue = value;
  }
  
  public String asString() {
    if(isString()) {
      return (String)mValue;
    }
    return null;
  }
  
  public boolean isNull() {
    return mValue == null;
  }
  
  public Integer asInteger() {
    if(isInteger()) {
      return (Integer)mValue;
    }
    
    return null;
  }
  
  public Long asLong() {
    if(isLong()) {
      return (Long) mValue;
    }
    
    return null;
  }
  
  public Double asDouble() {
    if(isDouble()) {
      return (Double) mValue;
    }
    
    return null;
  }
  
  public Float asFloat() {
    if(isFloat()) {
      return (Float) mValue;
    }
    
    return null;
  }
  
  public Boolean asBoolean() {
    if(isBoolean()) {
      return (Boolean) mValue;
    }
    
    return null;
  }
  
  public boolean hasValue() {
    return mValue != null;
  }
  
  public boolean isString() {
    return is(String.class);
  }
  
  public boolean isInteger() {
    return is(Integer.class);
  }
  
  public boolean isFloat() {
    return is(Float.class);
  }
  
  public boolean isDouble() {
    return is(Double.class);
  }
  
  public boolean isLong() {
    return is(Long.class);
  }
  
  public boolean isBoolean() {
    return is(Boolean.class);
  }
  
  private boolean is(Class<?> clazz) {
    return hasValue() && mValue.getClass() == clazz;
  }
  
  private T mValue;

  public static <T> Prim<T> create(T value) {
    return new Prim<T>(value);
  }
}

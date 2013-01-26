package bacn;

public class Value<T extends Bcon> {
  
  private Value(String typeName) {
    mTypeName = typeName;
  }
  
  public static <T extends Bcon> Value<T> create(Class<T> clazz) {
    String typeName = clazz.getCanonicalName();
    if(typeName != null) {
      return new Value<T>(typeName);
    }
    
    return null;
  }
  
  public T get() { return mValue; }
  public Value<T> setTo(T newValue) { mValue = newValue; return this; }
  
  public boolean isNull() {
    return mValue == null;
  }
  
  public boolean notNull() {
    return mValue != null;
  }
  
  /**
   * Returns the string representation of the type.
   * @return
   */
  public String getTypeName() { return mTypeName; }
  
  private T mValue;
  private String mTypeName;
  
  @Override
  public String toString() {
    
    String valueString;
    if(notNull()) {
      valueString = mValue.toString();
    } else {
      valueString = "*null*";
    }
    
    return String.format("{ %s: %s}", mTypeName, valueString);
    
  }

}

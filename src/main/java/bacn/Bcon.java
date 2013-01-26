package bacn;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public abstract class Bcon {
  /**
   * Returns a value that is registered as a member of `this` instance.
   * @param clazz
   * @param key
   * @return
   */
  protected <T extends Bcon> Value<T> member (Class<T> clazz, String key) {
    Value<T> value = Value.create(clazz);
    mValues.put(key, value);
    return value;
  }
  
  /**
   * Returns a primitive value that is registered as a member of `this` instance.
   * @param key
   * @return
   */
  protected <T extends Comparable<T>> Prim<T> member(String key) {
    Prim<T> primitive = new Prim<T>();
    mPrimitives.put(key, primitive);
    return primitive;
  }
  
  /**
   * Extends `this` object with the type of T.
   * @param clazz
   * @param key
   * @return
   */
  protected <T extends Bcon> Value<T> extension (Class<T> clazz) {
    Value<T> value = Value.create(clazz);
    mExtensions.put(clazz.getCanonicalName(), value);
    return value;
  }
  
  public Value<?> getExtension(String key) {
    return mExtensions.get(key);
  }
  
  public Collection<String> getExtensionKeys() {
    return mExtensions.keySet();
  }
  
  public Collection<String> getValueKeys() {
    return mValues.keySet();
  }
  
  public Collection<String> getPrimitiveKeys() {
    return mPrimitives.keySet();
  }
  
  private Map<String,Value<? extends Bcon>> mExtensions = new TreeMap<String,Value<? extends Bcon>>();
  private Map<String,Value<? extends Bcon>> mValues = new TreeMap<String,Value<? extends Bcon>>();
  private Map<String,Prim<?>> mPrimitives = new TreeMap<String, Prim<?>>();
}

package bacn;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public abstract class BconAdapter implements Bcon {
  /**
   * Returns a value that is registered as a member of `this` instance.
   * @param clazz
   * @param key
   * @return
   */
  final protected <T extends Bcon> Value<T> member (Class<T> clazz, String key) {
    Value<T> value = Value.create(clazz);
    mMembers.put(key, value);
    return value;
  }
  
  /**
   * Returns a primitive value that is registered as a member of `this` instance.
   * @param key
   * @return
   */
  protected final <T extends Comparable<T>> Prim<T> member (String key) {
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
  protected final <T extends Bcon> Value<T> ancestor (Class<T> clazz, T t) {
    Value<T> value = Value.create(clazz).setTo(t);
    mAncestors.put(clazz.getCanonicalName(), value);
    return value;
  }
  
  /* (non-Javadoc)
   * @see bacn.Bcon#getAncestor(java.lang.String)
   */
  @Override
  final public Value<?> getAncestor(String key) {
    return mAncestors.get(key);
  }
  
  /* (non-Javadoc)
   * @see bacn.Bcon#getAncestorKeys()
   */
  @Override
  final public Collection<String> getAncestorKeys() {
    return mAncestors.keySet();
  }
  
  /* (non-Javadoc)
   * @see bacn.Bcon#getMemberKeys()
   */
  @Override
  final public Collection<String> getMemberKeys() {
    return mMembers.keySet();
  }
  
  /* (non-Javadoc)
   * @see bacn.Bcon#getPrimitiveKeys()
   */
  @Override
  final public Collection<String> getPrimitiveKeys() {
    return mPrimitives.keySet();
  }
  
  public boolean hasPrimitives() {
    return !mPrimitives.isEmpty();
  }
  
  public boolean hasAncestors() {
    return !mAncestors.isEmpty();
  }
  
  public boolean hasMembers() {
    return !mMembers.isEmpty();
  }
  
  private Map<String,Value<? extends Bcon>> mAncestors = new TreeMap<String,Value<? extends Bcon>>();
  private Map<String,Value<? extends Bcon>> mMembers = new TreeMap<String,Value<? extends Bcon>>();
  private Map<String,Prim<?>> mPrimitives = new TreeMap<String, Prim<?>>();
}

package bacn;

import java.util.Collection;

public interface Bcon {

  public Value<?> getAncestor(String key);

  public Collection<String> getAncestorKeys();

  public Collection<String> getMemberKeys();

  public Collection<String> getPrimitiveKeys();

  public Value<?> getMemberValue(String valueKey);
  
  public Prim getPrimitive(String primitiveKey);

  public boolean hasMembers();

  public boolean hasAncestors();

  public boolean hasPrimitives();

}
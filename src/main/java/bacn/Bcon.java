package bacn;

import java.util.Collection;

public interface Bcon {

  public Value<?> getAncestor(String key);

  public Collection<String> getAncestorKeys();

  public Collection<String> getMemberKeys();

  public Collection<String> getPrimitiveKeys();

}
package bacn;

import java.util.Collection;

public interface Bcon {

  public Value<?> getExtension(String key);

  public Collection<String> getExtensionKeys();

  public Collection<String> getValueKeys();

  public Collection<String> getPrimitiveKeys();

}
package bacn;


import org.junit.Assert;
import org.junit.Test;

import bacn.Prim;

public class TestPrim {
  
  @Test
  public void testString() {
    Prim<String> p = Prim.create("Whatever");
    Assert.assertTrue(p.hasString());
    Assert.assertFalse(p.isNull());
    Assert.assertFalse(p.hasInteger());
    Assert.assertNull(p.asInteger());
    
  }
  
  public void testInteger() {
    Prim<Integer> p = Prim.create(10);
    Assert.assertTrue(p.hasInteger());
    Assert.assertFalse(p.isNull());
    Assert.assertFalse(p.hasString());
    Assert.assertNull(p.asString());
  }
}

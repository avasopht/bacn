package kbacon;

import org.junit.Assert;
import org.junit.Test;

public class TestPrim {
  
  @Test
  public void testString() {
    Prim<String> p = Prim.create("Whatever");
    Assert.assertTrue(p.isString());
    Assert.assertFalse(p.isNull());
    Assert.assertFalse(p.isInteger());
    Assert.assertNull(p.asInteger());
    
  }
  
  public void testInteger() {
    Prim<Integer> p = Prim.create(10);
    Assert.assertTrue(p.isInteger());
    Assert.assertFalse(p.isNull());
    Assert.assertFalse(p.isString());
    Assert.assertNull(p.asString());
  }
}

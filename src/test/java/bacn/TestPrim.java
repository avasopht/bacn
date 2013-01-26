package bacn;


import org.junit.Assert;
import org.junit.Test;

import bacn.Prim;

public class TestPrim {
  
  @Test
  public void testString() {
    Prim p = Prim.create("Whatever");
    Assert.assertTrue(p.hasString());
    Assert.assertFalse(p.isNull());
    Assert.assertFalse(p.hasInteger());
    Assert.assertNull(p.asInteger());
    
  }
  
  @Test
  public void testInteger() {
    Prim p = Prim.create(10);
    Assert.assertTrue(p.hasInteger());
    Assert.assertFalse(p.isNull());
    Assert.assertFalse(p.hasString());
    Assert.assertNull(p.asString());
  }
  
  @Test
  public void testStringEquality() {
    Prim first = Prim.create("Louise");
    Prim second = Prim.create("Marcus");
    Prim firstDuplicate = Prim.create("Louise");
    
    Assert.assertEquals(first, firstDuplicate);
    Assert.assertFalse(first.equals(second));
  }
  
  @Test
  public void testIntegerEquality() {
    Prim first = Prim.create(1);
    Prim second = Prim.create(2);
    Prim firstDuplicate = Prim.create(1);
    
    Assert.assertEquals(first, firstDuplicate);
    Assert.assertFalse(first.equals(second));
  }
}

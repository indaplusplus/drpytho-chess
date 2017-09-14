package com.drpytho.chess;

import org.junit.Test;
import org.junit.Assert;

public class BoardLocationTest {

  @Test
  public void testStringInputFirst() {
    BoardLocation bl = new BoardLocation("A1");
    Assert.assertEquals(bl.row(), 0);
    Assert.assertEquals(bl.column(), 0);
  }

  @Test
  public void testStringInputMiddle() {
    BoardLocation bl = new BoardLocation("c6");
    Assert.assertEquals(bl.row(), 5);
    Assert.assertEquals(bl.column(), 2);
  }

  @Test
  public void testStringInputLast() {
    BoardLocation bl = new BoardLocation("H8");
    Assert.assertEquals(bl.row(), 7);
    Assert.assertEquals(bl.column(), 7);
  }
}

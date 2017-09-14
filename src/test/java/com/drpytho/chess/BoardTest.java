package com.drpytho.chess;

import org.junit.Test;
import org.junit.Assert;

public class BoardTest {

  @Test
  public void testStringInputFirst() {
    Board b = new Board();
    Assert.assertEquals(8, b.WIDTH);
    Assert.assertEquals(8, b.HEIGHT);
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

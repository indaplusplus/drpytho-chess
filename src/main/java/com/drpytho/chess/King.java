package com.drpytho.chess;

public class King extends Piece {
  private final int[][] relativeMoves = {{1, 1},  {1, 0},  {1, -1},
                                         {0, 1},  /*KING*/ {0, -1},
                                         {-1, 1}, {-1, 0}, {-1, -1}};

  @override public Set<BoardLocation> validMoves(Board board) {
    // NOTE: What is forward for what color?



  }
}

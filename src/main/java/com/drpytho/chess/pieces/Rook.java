package com.drpytho.chess;

import java.util.HashSet;

public class Rook extends Piece {
  private final int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};
  public Rook(Color color) {
    super(color);
  }

  @Override public String toString() {
    if (this.color == Color.WHITE) {
      return "R";
    } else {
      return "r";
    }
  }

  @Override public HashSet<Move> validMoves(Board board) {
    BoardLocation loc = board.getLocationOfPiece(this);
    HashSet<Move> possibleLocations = new HashSet<>();

    for (int[] dir : directions) {
      BoardLocation next = loc.translate(dir[0], dir[1]);
      while (board.inRange(next)) {
        Piece p = board.at(next);
        if (p == null || (p != null && p.color != this.color)) {
          possibleLocations.add(new Move(loc, next));
          next = next.translate(dir[0], dir[1]);
        } else {
          break;
        }
      }
    }
    return possibleLocations;
  }
}

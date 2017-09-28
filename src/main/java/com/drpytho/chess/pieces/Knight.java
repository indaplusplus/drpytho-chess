package com.drpytho.chess;

import java.util.HashSet;

public class Knight extends Piece {

  private final int[][] hoppityHopps = {{ 2, 1}, { 1, 2}, {-1, 2}, {-2, 1},
                                        {-2,-1}, {-1,-2}, { 1,-2}, { 2,-1}};

  public Knight(Color color) {
    super(color);
  }

  @Override public String toString() {
    if (this.color == Color.WHITE) {
      return "N";
    } else {
      return "n";
    }
  }

  @Override public HashSet<Move> validMoves(Board board) {
    BoardLocation loc = board.getLocationOfPiece(this);
    HashSet<Move> possibleLocations = new HashSet<>();

    for (int[] hoppity : hoppityHopps) {
      BoardLocation next = loc.translate(hoppity[0], hoppity[1]);
      if (!board.inRange(next)) {
        continue;
      }
      Piece p = board.at(next);
      if (p == null || (p.color != this.color)) {
        possibleLocations.add(new Move(loc, next));
      }
    }

    return possibleLocations;
  }
}

package com.drpytho.chess;

import java.util.HashSet;

public class King extends Piece {

  private final int[][] relativeMoves = {{ 1, -1}, { 1, 0}, { 1, 1},
                                         { 0, -1}, /*KING*/ { 0, 1},
                                         {-1, -1}, {-1, 0}, {-1, 1}};

  public King(Color color) {
    super(color);
  }

  @Override public String toString() {
    if (this.color == Color.WHITE) {
      return "K";
    } else {
      return "k";
    }
  }

  @Override public HashSet<Move> validMoves(Board board) {
    BoardLocation loc = board.getLocationOfPiece(this);
    HashSet<Move> possibleLocations = new HashSet<>();

    for (int[] pair : this.relativeMoves) {
      BoardLocation newLocation = loc.translate(pair[0], pair[1]);
      if (!board.inRange(newLocation)) { // Can't move of the board
        continue;
      }
      Piece p = board.at(newLocation);
      if (p == null || (p != null && p.color != this.color)) { // Can't move onto your own kind
        possibleLocations.add(new Move(loc, newLocation));
      }
    }

    // Castle

    return possibleLocations;
  }
}

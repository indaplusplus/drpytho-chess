package com.drpytho.chess;

import java.util.HashSet;

public class Pawn extends Piece {
  // has Moved already exists

  private boolean didDoubleJump = false;

  public Pawn(Color color) {
    super(color);
  }

  @Override public String toString() {
    if (this.color == Color.WHITE) {
      return "P";
    } else {
      return "p";
    }
  }

  @Override public HashSet<Move> validMoves(Board board) {
    // Player color determines wich direction to go.

    BoardLocation loc = board.getLocationOfPiece(this);
    System.out.println(loc);
    HashSet<Move> possibleLocations = new HashSet<>();

    BoardLocation simpleMove = loc.translate(this.color.i(), 0);
    if (board.inRange(simpleMove) && board.at(simpleMove) == null) {
      possibleLocations.add(new Move(loc, simpleMove));

      BoardLocation doubleMove = simpleMove.translate(this.color.i(), 0);
      if (board.inRange(doubleMove) && board.at(doubleMove) == null
          && (this.color == Color.WHITE && loc.row == 1
              || this.color == Color.BLACK && loc.row == 6)) {
        possibleLocations.add(new Move(loc, doubleMove));
      }
    }

    BoardLocation attackMove1 = loc.translate(this.color.i(), 1);
    if (board.inRange(attackMove1) && board.at(attackMove1) != null
        && board.at(attackMove1).color != this.color) {
      possibleLocations.add(new Move(loc, attackMove1));
    }

    BoardLocation check1 = attackMove1.translate(-1 * this.color.i(), 0);
    if (board.inRange(attackMove1) && board.at(attackMove1) == null
        && board.inRange(check1) && board.at(check1) != null && board.at(check1).color != this.color
        && board.at(check1) instanceof Pawn && ((Pawn) board.at(check1)).didDoubleJump) {
      possibleLocations.add(new Move(loc, attackMove1, true, false, false));
    }

    BoardLocation attackMove2 = loc.translate(this.color.i(), -1);
    if (board.inRange(attackMove2) && board.at(attackMove2) != null
        && board.at(attackMove2).color != this.color) {
      possibleLocations.add(new Move(loc, attackMove2));
    }

    BoardLocation check2 = attackMove2.translate(-1 * this.color.i(), 0);
    if (board.inRange(attackMove2) && board.at(attackMove2) == null
        && board.inRange(check1) && board.at(check2) != null && board.at(check2).color != this.color
        && board.at(check2) instanceof Pawn && ((Pawn)board.at(check2)).didDoubleJump) {
      possibleLocations.add(new Move(loc, attackMove2, true, false, false));
    }

    return possibleLocations;
  }
}

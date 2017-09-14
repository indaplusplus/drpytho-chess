package com.drpytho.chess;

import java.util.HashSet;


public abstract class Piece {

  public final Color color;

  public static Piece getPieceFromChar(char c) {
    // lowercase => black
    // UPPERCASE => white
    // K => king, Q => Queen, R = Rook,
    // B => Bishop N => Knight, P = Pawn

    Color color;
    if (Character.isUpperCase(c)) {
      color = Color.WHITE;
    } else {
      color = Color.BLACK;
    }

    switch(Character.toLowerCase(c)) {
    case 'k':
      return new King(color);
    case 'q':
      return new Queen(color);
    case 'n':
      return new Knight(color);
    case 'r':
      return new Rook(color);
    case 'b':
      return new Bishop(color);
    case 'p':
      return new Pawn(color);
    }
    return null;
  }

  public Piece(Color c) {
    this.color = c;
  }

  public abstract HashSet<Move> validMoves(Board board);
}

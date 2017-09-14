package com.drpytho.chess;

import java.lang.IndexOutOfBoundsException;

public class Board {
  public final int WIDTH;
  public final int HEIGHT;

  private Piece[] board;

  public Board(int width, int height) {
    this.WIDTH = width;
    this.HEIGHT = height;
    board = new Piece[width*height];
  }

  public Board() {
    this(8,8);
  }

  public Board(String[] rows, int width, int height) {
    this(width, height);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.board[i*this.WIDTH + j] = Piece.getPieceFromChar(rows[i].charAt(j));
      }
    }
  }

  public void print() {
    System.out.println("\n  ABCDEFGH  ");
    for (int i = 0; i < this.board.length; i++) {
      if (i % this.WIDTH == 0) {
        System.out.print("\n" + ((i / this.WIDTH) + 1) + " ");
      }
      if (this.board[i] == null) {
        System.out.print(" ");
        continue;
      }
      System.out.print(this.board[i]);
    }
    System.out.println("\n\n  ABCDEFGH  \n");
  }

  /**
   * Checks if a square LOCATION is currently "under attack" by the
   * color ATTACKER.
   */
  public boolean isUnderAttack(BoardLocation location, Color attacker) {
    for (Piece p : this.board) {
      if (p.validMoves(this).contains(location)
          && p.color == attacker) {
        return true;
      }
    }
    return false;
  }

  private BoardLocation getKingLocation(Color c) {
    for (int i = 0; i < this.board.length; i++) {
      if (this.board[i].color == c && this.board[i] instanceof King) {
        return this.indexToLocation(i);
      }
    }
    return null;
  }

  public boolean moveIsSafe() {
    return false;
  }

  public BoardLocation getLocationOfPiece(Piece p) {
    for (int i = 0; i < this.board.length; i++) {
      if (this.board[i] == p) {
        return this.indexToLocation(i);
      }
    }

    return null;
  }

  public boolean inRange(BoardLocation location) {
    return
      (location.row >= 0) &&
      (location.row <= this.HEIGHT) &&
      (location.col >= 0) &&
      (location.col <= this.WIDTH);
  }

  private void assertInRage(BoardLocation location) throws IndexOutOfBoundsException {
    if (!this.inRange(location)) {
      final String errorMessage = "Expected range ([0, %d], [0, %d]). Got %s.";
      throw new IndexOutOfBoundsException(String.format(errorMessage,
                                                        this.HEIGHT,
                                                        this.WIDTH,
                                                        location));
    }
  }

  private int locationToIndex(BoardLocation location) {
    return (location.row) * this.WIDTH + (location.col) ;
  }

  private BoardLocation indexToLocation(int index) {
    int col = (index % this.WIDTH);
    int row = (index / this.WIDTH);
    return new BoardLocation(row, col);
  }

  public Piece at(BoardLocation location) throws IndexOutOfBoundsException {
    this.assertInRage(location); // Throws if out of bounds
    return this.board[this.locationToIndex(location)];
  }

  public void set(BoardLocation location, Piece p) throws IndexOutOfBoundsException {
    this.assertInRage(location);
    this.board[this.locationToIndex(location)] = p;
  }

  private void move(BoardLocation from, BoardLocation to) {
    this.set(to, this.at(from));
    this.set(from, null);
  }

  public boolean makeMove(Move m) {
    if (this.at(m.from).validMoves(this).contains(m)) {
      this.move(m.from, m.to);
      return true;
    }
    return false;
  }
}

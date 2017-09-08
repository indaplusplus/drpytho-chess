package com.drpytho.chess;

import java.lang.IndexOutOfBoundsException;

public class Board {
  private final int WIDTH;
  private final int HEIGHT;

  private Piece[] board;

  public Board(int width, int height) {
    this.WIDTH = width;
    this.HEIGHT = height;
    board = new Piece[width*height];
  }

  public Board() {
    this(8,8);
  }

  public boolean inRange(BoardLocation location) {
    return
      (location.row() >= 0) &&
      (location.row() <= this.HEIGHT) &&
      (location.column() >= 0) &&
      (location.column() <= this.WIDTH());
  }

  private void assertInRage(BoardLocation location) {
    if (!this.inRange(location)) {
      final String errorMessage = "Expected range ([0, %d], [0, %d]). Got %s.";
      throw new IndexOutOfBoundsException(String.format(errorMessage,
                                                        this.HEIGHT,
                                                        this.WIDTH,
                                                        location));
    }

  }

  private int locationToindex(BoardLocation location) {
    return location.row()*this.WIDTH + location.column;
  }

  public Piece at(BoardLocation location) {
    this.assertInRage(location); // Throws if out of bounds
    return this.board[this.locationToindex(location)];
  }

  public void set(BoardLocation location, Piece p) {
    this.assertInRage(location);
    this.board[this.locationToindex(location)] = p;
  }

  public void move(BoardLocation from, BoardLocation to) {
    this.set(to, this.at(from));
    this.set(from, null);
  }
}

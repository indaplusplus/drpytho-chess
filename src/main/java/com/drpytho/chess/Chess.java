package com.drpytho.chess;

public class Chess {
  private Board board;

  public Chess() {
    this.board = new Board();
  }

  public Chess(String setup) {
    // Get Dimention of setup
    // Setup accordingly

  }

  public void makeMove(BoardLocation from, BoardLocation to) {
    if (this.board.at(from).validMoves().count(to)) {
      this.board.move(from, to);
    } else {
      // Bad move!!
      throw new Exception("Man, you are bad at chess");
    }
  }

  public void makeMove(String notation) {
  }

  public void makeMoves(String notation) {
  }
}

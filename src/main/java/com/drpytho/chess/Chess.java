package com.drpytho.chess;

import java.util.Scanner;

public class Chess {
  private Board board;

  private Player player1;
  private Player player2;

  public Chess() {
    final String[] rows =
      {"RNBKQBNR",
       "PPPPPPPP",
       "        ",
       "        ",
       "        ",
       "        ",
       "pppppppp",
       "rnbkqbnr"};
    this.board = new Board(rows, 8, 8);
    this.player1 = new Player(Color.WHITE);
    this.player2 = new Player(Color.BLACK);
  }

  public void run() {
    boolean running = true;
    Scanner scanner = new Scanner(System.in);
    while(running) {
      board.print();
      System.out.print("> ");
      String line = scanner.nextLine();
      Move m = new Move(line);
      board.makeMove(m);
    }
  }

  private boolean isCheck() {
    return false;
  }

  private boolean isCheckMate() {
    if (this.isCheck()) {
    }
    return false;
  }

  private boolean isGameOver() {
    if (this.isCheckMate()) {

    }
    return false;
    // Check if player can make any legal moves??
  }

  public void makeMove(Move move) throws Exception {

  }

  public void makeMove(String notation) {
    Move m = new Move(notation);

    //this.makeMove

  }

  public static void main(String[] args) {
    Chess game = new Chess();
    game.run();
  }
}

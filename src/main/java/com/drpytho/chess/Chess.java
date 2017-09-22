package com.drpytho.chess;

import java.util.Scanner;

public class Chess {
  private Board board;

  private Player[] players;


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
    this.players = new Player[2];
    this.players[0] = new Player(Color.WHITE);
    this.players[1] = new Player(Color.BLACK);
  }

  public void run() {
    boolean running = true;
    Scanner scanner = new Scanner(System.in);
    int currentPlayer = 0;
    while(running) {
      board.print();
      System.out.print("> ");
      String line = scanner.nextLine();
      Move m = new Move(line);
      if (board.makeMove(m, players[currentPlayer])) {
        // move was successfull
        // Other persons turn
        currentPlayer = (currentPlayer + 1) % 2;
      }
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

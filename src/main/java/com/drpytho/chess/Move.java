package com.drpytho.chess;

public class Move {

  public final BoardLocation from;
  public final BoardLocation to;

  public final boolean castle;
  public final boolean castleKS;
  public final boolean castleQS;

  public final boolean enPassant;

  public final char promoteTo;
  public final char capture;

  public Move(BoardLocation f, BoardLocation t, boolean enPassant,  boolean KS, boolean QS) {
    this.from = f;
    this.to = t;
    this.enPassant = enPassant;
    this.castleKS = KS;
    this.castleQS = QS;
    this.castle = KS || QS;
    this.promoteTo = (char)0;
    this.capture = (char)0;
  }

  public Move(BoardLocation f, BoardLocation t) {
    this.from = f;
    this.to = t;
    this.enPassant = false;
    this.castleKS = false;
    this.castleQS = false;
    this.castle = false;
    this.promoteTo = (char)0;
    this.capture = (char)0;
  }

  @Override public int hashCode() {
    return this.from.hashCode() ^ this.to.hashCode();
  }


  @Override public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    Move other = (Move) obj;
    if (!from.equals(other.from)) return false;
    if (!to.equals(other.to)) return false;

    return true;
  }

  public Move(String notation) {
       // Smith notation

    /*
     * <from square><to square>[<capture indicator>][<promoted to>]
     *   2 chars     2 chars       0 or 1 char       0 or 1 char
     */

    this.from = new BoardLocation(notation.substring(0,2));
    this.to   = new BoardLocation(notation.substring(2,4));

    String end = notation.substring(4);

    String capture = "";
    String promoted = "";

    if (end.length() == 2) {
      capture = end.substring(0,1);
      promoted = end.substring(1,2);
    }

    if (end.length() == 1) {
      capture = end;
      promoted = end;
    }

    switch(promoted) {
    case "K":
    case "Q":
    case "N":
    case "B":
      this.promoteTo = promoted.toLowerCase().charAt(0);
      break;
    default:
      this.promoteTo = 0;
    }

    switch(capture) {
    case "p":
    case "n":
    case "b":
    case "r":
    case "q":
    case "k":
      this.capture = capture.charAt(0);
      this.castleQS = false;
      this.castleKS = false;
      this.enPassant = false;
    break;
    case "E":
      this.capture = 'p';
      this.enPassant = true;
      this.castleQS = false;
      this.castleKS = false;
      break;
    case "c":
      this.castleKS = true;
      this.castleQS = false;
      this.enPassant = true;
      this.capture = 0;
      break;
    case "C":
      this.castleQS = true;
      this.castleKS = false;
      this.enPassant = true;
      this.capture = 0;
      break;
    default:
      this.castleQS = false;
      this.castleKS = false;
      this.enPassant = true;
      this.capture = 0;
    }
    this.castle = this.castleQS || this.castleKS;
  }
}

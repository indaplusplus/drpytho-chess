package com.drpytho.chess;

public class BoardLocation {
  public final int row;
  public final int col;

  public BoardLocation(String location) {
    // Should this be bounded???

    // Parse e3, A1, H8 ...
    location = location.toLowerCase();
    this.col = location.charAt(0) - ((int)'a');
    this.row = location.charAt(1) - ((int)'1');
  }

  public BoardLocation(int row, int col) {
    this.row = row;
    this.col = col;
  }

  @Override public int hashCode() {
    return (1000 * row) ^ col;
  }


  @Override public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;

    BoardLocation other = (BoardLocation) obj;
    if (row != other.row) return false;
    if (col != other.col) return false;

    return true;
  }


  public BoardLocation translate(int row, int column) {
    return new BoardLocation(this.row + row, this.col + column);
  }

  public String toString() {
    return "[" + this.row + ", " + this.col + "]";
  }
}

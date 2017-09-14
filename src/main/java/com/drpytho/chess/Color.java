package com.drpytho.chess;

public enum Color {
  WHITE(1),
  BLACK(-1);

  private int i;

  Color(int i) {
    this.i = i;
  }

  public int i() {
    return this.i;
  }
}

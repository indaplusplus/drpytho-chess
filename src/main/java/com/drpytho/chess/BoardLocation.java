

public class BoardLocation {
  private int row;
  private int column;

  public BoardLocation(String location) {
    // Should this be bounded???

    // Parse e3, A1, H8 ...
    location = location.toLowerCase();
    this.column = location.charAt(0)-'a';
    this.row = location.charAt(1)-'1';
  }

  public BoardLocation(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public void translate(int row, int column) {
    this.row += row;
    this.column += column;
  }

  public int row() {
    return this.row;
  }

  public int column() {
    return this.column;
  }
}

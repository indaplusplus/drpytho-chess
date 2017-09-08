

public abstract class Piece {
  private BoardLocation location;
  private Color color;

  public Piece(BoardLocation location, Color color) {
    this.location = location;
    this.color = color;
  }

  public abstract Set<BoardLocation> validMoves(Board board);

}

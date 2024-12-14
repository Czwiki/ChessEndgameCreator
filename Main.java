import figures.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Rook rook = new Rook('A','1');
        board.addPiece(rook);
        System.out.println(board.getBoard().toString());
    }
}

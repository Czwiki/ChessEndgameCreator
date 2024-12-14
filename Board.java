import figures.Figure;

import java.util.ArrayList;

public class Board {
    private ArrayList<Row> board;
    public Board() {
        char[] UpperCaseAlphabet = {'A','B','C','D','E','F','G','H'};
        for (int i = 0; i < 8; i++) {
            board.add(new Row(UpperCaseAlphabet[i]));
        }
    }
    public void addPiece(Figure figure) {
        switch (figure.getPosition().get(0)) {
            case 'A': board.get(0).addPiece(figure); break;
            case 'B': board.get(1).addPiece(figure); break;
            case 'C': board.get(2).addPiece(figure); break;
            case 'D': board.get(3).addPiece(figure); break;
            case 'E': board.get(4).addPiece(figure); break;
            case 'F': board.get(5).addPiece(figure); break;
            case 'G': board.get(6).addPiece(figure); break;
            case 'H': board.get(7).addPiece(figure); break;
            default: break;
        }
    }
    public ArrayList<Row> getBoard() {
        return board;
    }

}

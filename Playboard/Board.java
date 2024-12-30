package Playboard;
import figures.Figure;

import java.util.ArrayList;

public class Board {
    private ArrayList<Row> board = new ArrayList<>();
    public Board() {
        boolean a = false; // Identifier ist für die Reihe eine Zahl, für die Spalten ein Buchstabe
        for (int i = 0; i < 8; i++) { 
            if (!a){
                board.add(new Row(i, a));
                a = !a;
                continue;
            }
            if (a){
                board.add(new Row(i, a));
                a = !a;
                continue;
            }

        }
    }
    public void addPiece(Figure figure) {
        switch (figure.getPosition().get(0)) {
            case '1': board.get(0).addPiece(figure); break;
            case '2': board.get(1).addPiece(figure); break;
            case '3': board.get(2).addPiece(figure); break;
            case '4': board.get(3).addPiece(figure); break;
            case '5': board.get(4).addPiece(figure); break;
            case '6': board.get(5).addPiece(figure); break;
            case '7': board.get(6).addPiece(figure); break;
            case '8': board.get(7).addPiece(figure); break;
            default: break;
        }
    }
    public ArrayList<Row> getBoard() {
        return board;
    }
    public Row getRow(int i){
        return board.get(i);
    }
}

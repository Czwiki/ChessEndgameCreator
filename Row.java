import java.util.HashMap;
import java.util.Map;

import figures.Figure;

public class Row {
    private char row;
    private Figure[] figures;
    static Map<Character, Integer> map = new HashMap<Character, Integer>();
    public Row(char row) {
        this.row = row;
        this.figures = new Figure[8];
        map.put('A', 1); // das board brauch das, nicht die Reihe
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
    }
    public char getRowIndex() {
        return row;
    }
    public void addPiece(Figure figure) {
        figures[figure.getPosition().get(1) - '0'] = figure; 
    }
    public Figure getFigure(int position) {
        return figures[position];
    }
    public Figure[] getFigures() {
        return figures;
    }
    public int getRowIndexint() {
        return map.get(getRowIndex());
    }
}

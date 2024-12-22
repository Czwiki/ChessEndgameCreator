import java.util.HashMap;
import java.util.Map;

import figures.Figure;

public class Row {
    private char row;
    private Figure[] figures;
    private final int[] white_positions;
    private final int[] black_positions;
    static Map<Character, Integer> map = new HashMap<Character, Integer>();
    public Row(char row, boolean a) {
        this.row = row;
        this.figures = new Figure[8];
        this.white_positions = new int[4];
        this.black_positions = new int[4];
        map.put('A', 1); // das board braucht int, nicht die Reihe
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        for (int i = 1; i<9; i++){
            int index_w = 0;
            int index_b = 0;
            if (a) {
                white_positions[index_w] = i;
                a = !a;
                index_w++;
            }
            else {
                black_positions[index_b] = i;
                a = !a;
                index_b++;
            }
        }
    }

    public char getRowIndex() {
        return row;
    }
    public int getRowIndexint() {
        return map.get(getRowIndex());
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
    public boolean getColor(int i){
        int index_w = 0;
        int index_b = 0;        
        while (true) {
            if (white_positions[index_w] == i){
            return true; // white is true
            }
            index_w++;
            if (black_positions[index_b] == i){
            return false;
            }
            index_b++;
        }
    }
}

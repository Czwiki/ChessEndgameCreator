import java.util.HashMap;
import java.util.Map;

import figures.Figure;

public class Row {
    private int row;
    private Figure[] figures;
    private final int[] white_positions;
    private final int[] black_positions;
    static Map<Character, Integer> map = new HashMap<Character, Integer>();
    public Row(int row, boolean a) {
        char[] UpperCaseAlphabet = {'A','B','C','D','E','F','G','H'};
        this.row = row;
        this.figures = new Figure[8];
        this.white_positions = new int[4];
        this.black_positions = new int[4];
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        for (int i = 0; i<8; i++){
            int index_w = 0;
            int index_b = 0;
            if (a) {
                white_positions[index_w] = UpperCaseAlphabet[i];
                a = !a;
                index_w++;
            }
            else {
                black_positions[index_b] = UpperCaseAlphabet[i];
                a = !a;
                index_b++;
            }
        }
    }

    public int getRowIndex() {
        return row;
    }

    public void addPiece(Figure figure) {
        figures[figure.getPosition().get(0) - '0'] = figure; 
    }
    public Figure getFigure(char position) {
        return figures[map.get(position)];
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

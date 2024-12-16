package figures;

import java.util.ArrayList;

public class Figure {
    private char row;
    private int col;
    public Figure(char y, int x) {
        this.row = y;
        this.col = x;
    }
    public ArrayList<Character> getPosition() {
        ArrayList<Character> a = new ArrayList<Character>();
        a.add(this.row);
        a.add(this.col);
        return a;
    }
}

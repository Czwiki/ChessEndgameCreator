package figures;

import java.util.ArrayList;

public class Figure {
    private char row; // Zahlen
    private char col; // Buchstaben
    private boolean team;
    public Figure(char x, char y, boolean t) {
        this.col = x;
        this.row = y;
        this.team = t;
    }
    public ArrayList<Character> getPosition() {
        ArrayList<Character> a = new ArrayList<Character>();
        a.add(this.col);
        a.add(this.row);
        return a;
    }
    public boolean getTeam(){
        return this.team;
    }
}

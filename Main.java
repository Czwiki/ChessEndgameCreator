import java.util.ArrayList;

import figures.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Selector s = new Selector();
        ArrayList<ArrayList<Figure>> figures = s.piece_selector_even(9);
        ArrayList<Figure> figures_white = figures.get(0);
        ArrayList<Figure> figures_black = figures.get(1);
        for (int i = 0; i < figures_white.size(); i++){
            System.out.println(figures_white.get(i));
        }
    }
}

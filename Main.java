import java.util.ArrayList;

import Selectors.Selector;
import figures.*;
import Selectors.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Selector s = new Selector();
        ArrayList<ArrayList<Figure>> figures;
        ArrayList<Figure> figures_white;
        ArrayList<Figure> figures_black;

        s.piece_selector_uneven(37, 39);
        figures_white = s.getwhite();
        figures_black = s.getblack();
        for (int i = 0; i < figures_white.size(); i++){
            System.out.println(figures_white.get(i));
        }
        System.out.println("---------------------------------");
        for (int i = 0; i < figures_black.size(); i++){
            System.out.println(figures_black.get(i));
        }
    }
}

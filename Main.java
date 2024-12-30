import java.util.ArrayList;

import Playboard.*;
import figures.*;
import Selectors.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Selector s = new Selector();
        ArrayList<Figure> figures_white;
        ArrayList<Figure> figures_black;

        ArrayList<Figure> z = new ArrayList<>();
        z.add(new Bishop(true, false));

        s.piece_selector_even_points_same_given_figures_identical(z,7);
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

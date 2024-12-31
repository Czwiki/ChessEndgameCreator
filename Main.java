import java.util.ArrayList;

import Playboard.*;
import figures.*;
import Selectors.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Selector s = new Selector();
        ArrayList<? extends Figure> figures_white;
        ArrayList<? extends Figure> figures_black;

        ArrayList<Figure> z = new ArrayList<>();
        z.add(new Bishop(true, false));

        s.piece_selector_even_points(17);
        figures_white = s.getwhite();
        figures_black = s.getblack();
        for (int i = 0; i < figures_white.size(); i++){
            System.out.println(figures_white.get(i));
            if (figures_white.get(i).getClass().getName().equals("figures.Bishop")){
                System.out.println(figures_white.get(i).getstartcolor());
            }
        }
        System.out.println("---------------------------------");
        for (int i = 0; i < figures_black.size(); i++){
            System.out.println(figures_black.get(i));
            if (figures_black.get(i).getClass().getName().equals("figures.Bishop")){
                System.out.println(figures_black.get(i).getstartcolor());
            }
        }
    }
}

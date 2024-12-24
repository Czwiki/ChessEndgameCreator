import java.security.SecureRandom;
import figures.*;
import java.util.ArrayList;

public class Selector {
    private final OberserverSelector watcher = new OberserverSelector(this);
    public void piece_selector_even(int remaining_points){
        ArrayList<Figure> white = new ArrayList<Figure>();
        ArrayList<Figure> black = new ArrayList<Figure>(); 
        SecureRandom rand = new SecureRandom();
        while (remaining_points >0) {
            int value = 0;
            if (remaining_points > 9) {
                value = rand.nextInt(4);
            }
            else if (remaining_points < 9) {
                value = rand.nextInt(3);
            }
            else if (remaining_points < 5) {
                value = rand.nextInt(2);
            }
            else if (remaining_points < 3) {
                value = 0;
                for (int i = 0; i <2; i++){
                    white.add(new Pawn(true));
                    black.add(new Pawn(false));
                    remaining_points = remaining_points - black.get(black.size()-1).getValue();
                }
                break;
            }
            switch (value) {
                case 0:
                    white.add(new Pawn(true));
                    black.add(new Pawn(false));
                    remaining_points = remaining_points - black.get(black.size()-1).getValue();
                    break;
                case 1:
                    white.add(new Knight(true));
                    black.add(new Knight(false));
                    remaining_points = remaining_points - black.get(black.size()-1).getValue();
                case 2:
                    white.add(new Bishop(true));
                    black.add(new Bishop(false));
                    remaining_points = remaining_points - black.get(black.size()-1).getValue();
                case 3:
                    white.add(new Rook(true));
                    black.add(new Rook(false));
                    remaining_points = remaining_points - black.get(black.size()-1).getValue();
                case 4:
                    white.add(new Queen(true));
                    black.add(new Queen(false));
                    remaining_points = remaining_points - black.get(black.size()-1).getValue();
                default:
                    break;
            }
            if (!watcher.statuscheck(white) || !watcher.statuscheck(black)) {
                
                throw new Exception("Wrong figures selected. Discarded.");
            }
        }   
    }
}

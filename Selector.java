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
            int value = rand.nextInt(4);
            switch (value) {
                case 1: white.add()
                    
                    break;
            
                default:
                    break;
            }
            if (!watcher.statuscheck(white) || !watcher.statuscheck(black)) {
                
                throw new Exception("Wrong figures selected. Discarded.");
            }
        }   
    }
}

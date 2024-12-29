import java.security.SecureRandom;
import figures.*;
import java.util.ArrayList;

public class Selector {
    private final OberserverSelector watcher = new OberserverSelector(this);
    public ArrayList<ArrayList<Figure>> piece_selector_even(int remaining_points) {
        ArrayList<Figure> white = new ArrayList<Figure>();
        ArrayList<Figure> black = new ArrayList<Figure>(); 
        SecureRandom rand = new SecureRandom();
        while (remaining_points >0) {
            int value = 0;
            if (remaining_points >= 9) {
                value = rand.nextInt(5); // 0-4
            }
            if (remaining_points < 9 && remaining_points >= 5) {
                value = rand.nextInt(4); // 0-3
            }
            if (remaining_points < 5 && remaining_points >= 3) {
                value = rand.nextInt(3); // 0-2
            }
            if (remaining_points < 3) { // Auffüllen mit Pawns, keine anderen Figuren möglich
                for (int i = 0; remaining_points>0; i++){
                    Pawn a = new Pawn(true);
                    Pawn b = new Pawn(false);
                    white.add(a);
                    black.add(b);
                    remaining_points = remaining_points - a.getValue();
                }
                break;
            }

            Figure a = new Figure(true); // initialisieren der Variablen, durch den Switch und die Grenzen ist sichergestellt, dass diese immer aktualisiert werden
            Figure b = new Figure(false);
            switch (value) {
                case 0:
                    a = new Pawn(true);
                    b = new Pawn(false);
                    white.add(a);
                    black.add(b);
                    if (!watcher.statuscheck(white)) { // Überprüfung der enthaltenen Figuren
                        white.remove(white.indexOf(a));
                        black.remove(black.indexOf(b));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 1:
                    a = new Knight(true);
                    b = new Knight(false);
                    white.add(a);
                    black.add(b);
                    if (!watcher.statuscheck(white)) { // Überprüfung der enthaltenen Figuren
                        white.remove(white.indexOf(a));
                        black.remove(black.indexOf(b));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 2:
                    boolean f = rand.nextBoolean();
                    a = new Bishop(true, f);
                    b = new Bishop(false, f);
                    white.add(a);
                    black.add(b);
                    if (!watcher.statuscheck(white)) { // Überprüfung der enthaltenen Figuren
                        white.remove(white.indexOf(a));
                        black.remove(black.indexOf(b));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 3:
                    a = new Rook(true);
                    b = new Rook(false);
                    white.add(a);
                    black.add(b);
                    if (!watcher.statuscheck(white)) { // Überprüfung der enthaltenen Figuren
                        white.remove(white.indexOf(a));
                        black.remove(black.indexOf(b));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 4:
                    a = new Queen(true);
                    b = new Queen(false);
                    white.add(a);
                    black.add(b);
                    if (!watcher.statuscheck(white)) { // Überprüfung der enthaltenen Figuren
                        white.remove(white.indexOf(a));
                        black.remove(black.indexOf(b));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                default:
                    break;
            }
        }
        white.add(new King(true));
        black.add(new King(false));
        ArrayList<ArrayList<Figure>> c = new ArrayList<ArrayList<Figure>>();
        c.add(white);
        c.add(black);

        return c;
    }
}

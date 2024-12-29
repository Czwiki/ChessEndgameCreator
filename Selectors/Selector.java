package Selectors;
import java.security.SecureRandom;
import java.io.*;

import figures.*;
import java.util.ArrayList;

public class Selector {
    private final OberserverSelector watcher = new OberserverSelector(this);
    protected ArrayList<Figure> white = new ArrayList<Figure>();
    protected ArrayList<Figure> black = new ArrayList<Figure>(); 

    public ArrayList<Figure> getwhite(){
        return white;
    }

    public ArrayList<Figure> getblack(){
        return black;
    }

    private void clear_figures(){
        white.clear();
        black.clear();
    }

    public void piece_selector(int remaining_points, boolean t) { // Punkte sind noch einzuschränken!
        SecureRandom rand = new SecureRandom();
        ArrayList<Figure> figures= new ArrayList<Figure>();
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
                    figures.add(a);
                    remaining_points = remaining_points - a.getValue();
                }
                break;
            }
            Figure a = new Figure(true); // initialisieren der Variablen, durch den Switch und die Grenzen ist sichergestellt, dass diese immer aktualisiert werden
            switch (value) {
                case 0:
                    a = new Pawn(true);
                    figures.add(a);
                    if (!watcher.statuscheck(white)) { // Überprüfung der enthaltenen Figuren
                        figures.remove(figures.indexOf(a));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 1:
                    a = new Knight(true);
                    figures.add(a);
                    if (!watcher.statuscheck(figures)) { // Überprüfung der enthaltenen Figuren
                        figures.remove(figures.indexOf(a));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 2:
                    boolean f = rand.nextBoolean();
                    a = new Bishop(true, f);
                    figures.add(a);
                    if (!watcher.statuscheck(figures)) { // Überprüfung der enthaltenen Figuren
                        figures.remove(figures.indexOf(a));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 3:
                    a = new Rook(true);
                    figures.add(a);
                    if (!watcher.statuscheck(figures)) { // Überprüfung der enthaltenen Figuren
                        figures.remove(figures.indexOf(a));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                case 4:
                    a = new Queen(true);
                    figures.add(a);
                    if (!watcher.statuscheck(figures)) { // Überprüfung der enthaltenen Figuren
                        figures.remove(figures.indexOf(a));
                        break;
                    } // zurücksetzen der vorgenommenen Änderungen
                    remaining_points = remaining_points - a.getValue();
                    break;
                default:
                    break;
            }
        }
        figures.add(new King(true));
        if (t){
            white = figures;
        }
        else {
            black = figures;
        }
    }
    public void piece_selector_uneven (int white_remaining_points, int black_remaining_points) {
        clear_figures();
        this.piece_selector(white_remaining_points, true);
        this.piece_selector(black_remaining_points, false);
    }
    public void piece_selector_even (int remaining_points){
        clear_figures();
        this.piece_selector(remaining_points, true);
        this.piece_selector(remaining_points, false);
    }
}

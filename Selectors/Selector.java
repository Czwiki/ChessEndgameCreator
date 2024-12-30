package Selectors;
import java.security.SecureRandom;

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
            for (int i = 0; i < figures.size();i++) {
                white.add(figures.get(i));
            }
        }
        else {
            for (int i = 0; i < figures.size();i++) {
                black.add(figures.get(i));
            }
        }
    }

    public void piece_selector_uneven_points (int white_remaining_points, int black_remaining_points) { // unterschiedliche Punkte, unterschiedliche Figuren
        clear_figures();
        this.piece_selector(white_remaining_points, true);
        this.piece_selector(black_remaining_points, false);
    }

    public void piece_selector_even_points (int remaining_points){ // gleiche Punktzahl aber unterschiedliche Figuren
        clear_figures();
        this.piece_selector(remaining_points, true);
        this.piece_selector(remaining_points, false);
    }

    public void piece_selector_even_points_identical (int remaining_points) { // identische Figuren werden gewünscht
        clear_figures();
        this.piece_selector(remaining_points, true);
        this.copy_given_figures(white, false);
    }

    public void piece_selector_even_points_same_given_figures(ArrayList<Figure> given_figures, int remaining_points_exclusive, boolean t) {
        clear_figures();
        if (!watcher.given_figures_check(given_figures, remaining_points_exclusive)){
            return;
        }

        if (t) {
            this.copy_given_figures(given_figures, t);
            this.piece_selector(remaining_points_exclusive, t);
        }
        else {
            this.copy_given_figures(given_figures, !t);
            this.piece_selector(remaining_points_exclusive, !t);
        }
    }

    public void piece_selector_even_points_same_given_figures_identical(ArrayList<Figure> given_figures, int remaining_points_exclusive) {
        clear_figures();
        if (!watcher.given_figures_check(given_figures, remaining_points_exclusive)){
            return;
        }
        // weiß wählt und wird nach schwarz kopiert
        this.copy_given_figures(given_figures, true);
        this.piece_selector(remaining_points_exclusive, true);
        this.copy_given_figures(white, false);
    }

    public void piece_selector_even_points_same_given_figures (ArrayList<Figure> given_figures, int remaining_points_exclusive) {
        clear_figures();
        if (!watcher.given_figures_check(given_figures, remaining_points_exclusive)){
            return;
        }
        this.copy_given_figures(given_figures, true);
        this.piece_selector(remaining_points_exclusive, true);
        
        this.copy_given_figures(given_figures, false);
        this.piece_selector(remaining_points_exclusive,false); 

    }

    public void piece_selector_uneven_points_same_given_figures (ArrayList<Figure> given_figures, int remaining_points_exclusive_white, int remaining_points_exclusive_black){
        clear_figures();
        if (!watcher.given_figures_check(given_figures, remaining_points_exclusive_white) || !watcher.given_figures_check(given_figures, remaining_points_exclusive_black)){
            return;
        }
        // kopieren und jede Farbe für sich wird ausgewählt
        this.copy_given_figures(given_figures, true);
        this.piece_selector(remaining_points_exclusive_white, true);
        
        this.copy_given_figures(given_figures, false);
        this.piece_selector(remaining_points_exclusive_black,false); 
    }

    public void piece_selector_uneven_points_uneven_given_figures (ArrayList<Figure> given_figures_white, ArrayList<Figure> given_figures_black, int remaining_points_exclusive_white, int remaining_points_exclusive_black) {
        clear_figures();
        if (!watcher.given_figures_check(given_figures_white, remaining_points_exclusive_white) || !watcher.given_figures_check(given_figures_black, remaining_points_exclusive_black)){
            return;
        }
        // kopieren die gegebenen Figuren für beide Farben und jede Farbe für sich wird ausgewählt
        this.copy_given_figures(given_figures_white, true);
        this.piece_selector(remaining_points_exclusive_white, true);
        
        this.copy_given_figures(given_figures_black, false);
        this.piece_selector(remaining_points_exclusive_black,false);
    }

    public void copy_given_figures (ArrayList<Figure> given_figures, boolean t) { // kopieren der Figuren, aber diese müssen neue Instanzen sein!
        if (t){
            for (int i = 0; i < given_figures.size(); i++){ 
                Figure object = given_figures.get(i);
                String name = object.getClass().getName();
                switch (name) {
                    case "figures.Pawn":
                        white.add(new Pawn(true));
                        break;
                    case "figures.Knight":
                        white.add(new Knight(true));
                        break;
                    case "figures.Bishop":
                        white.add(new Bishop(true,object.getstartcolor()));
                        break;
                    case "figures.Rook":
                        white.add(new Rook(true));
                        break;
                    case "figures.Queen":
                        white.add(new Queen(true));
                        break;
                    case "figures.King":
                        white.add(new King(false));
                        break;
                    default:
                        break;
                }
            }
        }
        else {
            for (int i = 0; i < given_figures.size(); i++){ // kopieren der Figuren, aber diese müssen neue Instanzen sein!
                Figure object = given_figures.get(i);
                String name = object.getClass().getName();
                switch (name) {
                    case "figures.Pawn":
                        black.add(new Pawn(false));
                        break;
                    case "figures.Knight":
                        black.add(new Knight(false));
                        break;
                    case "figures.Bishop":
                        black.add(new Bishop(false,object.getstartcolor()));
                        break;
                    case "figures.Rook":
                        black.add(new Rook(false));
                        break;
                    case "figures.Queen":
                        black.add(new Queen(false));
                        break;
                    case "figures.King":
                        black.add(new King(false));
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

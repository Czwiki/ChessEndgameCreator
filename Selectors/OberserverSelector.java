package Selectors;
import java.util.ArrayList;

import figures.*;

public class OberserverSelector {
    Selector observedobject;
    public OberserverSelector(Selector a){
        this.observedobject = a;
    }
    public boolean statuscheck(ArrayList<Figure> figures) {
        if (numberofpawns(figures) > 8) { return false;}
        if (numberofbishops(figures) > 2) { return false;}
        if (numberofKnights(figures) > 2) { return false;}
        if (numberofrooks(figures) > 2) { return false;}
        if (numberofqueens(figures) > 1) { return false;}
        return true;
    }
    public int numberofrooks(ArrayList<Figure> figures) {
        int number = 0;
        for (int i = 0;i<figures.size();i++){
            if (figures.get(i) instanceof Rook){
                number++;
            }
        }
        return number;
    }
    public int numberofpawns(ArrayList<Figure> figures) {
        int number = 0;
        for (int i = 0;i<figures.size();i++){
            if (figures.get(i) instanceof Pawn){
                number++;
            }
        }
        return number;
    }
    public int numberofqueens(ArrayList<Figure> figures) {
        int number = 0;
        for (int i = 0;i<figures.size();i++){
            if (figures.get(i) instanceof Queen){
                number++;
            }
        }
        return number;
    }
    public int numberofKnights(ArrayList<Figure> figures) {
        int number = 0;
        for (int i = 0;i<figures.size();i++){
            if (figures.get(i) instanceof Knight){
                number++;
            }
        }
        return number;
    }
    public int numberofbishops(ArrayList<Figure> figures) {
        int number_white = 0;
        int number_black = 0;
        for (int i = 0;i<figures.size();i++){
            if (figures.get(i) instanceof Bishop){
                if (figures.get(i).getstartcolor() == true) {
                    number_white++;
                }
                else {
                    number_black++;
                }
            }
        }
        if (number_black <= 1 && number_white <= 1){
            return number_black + number_white;
        }
        else{
            return 3;// automatisch false
        }
    }

    public boolean given_figures_check (ArrayList<Figure> given_figures, int remaining_points) {
        int given_points = 0;
        for (int i = 0; i < given_figures.size();i++){
            given_points += given_figures.get(i).getValue();
        }
        if (remaining_points+given_points> 39) {
            System.out.println("Wrong combination of given arguments, too many points in given figures and remaining points.");
            return false;
        }
        return true;
    }
}

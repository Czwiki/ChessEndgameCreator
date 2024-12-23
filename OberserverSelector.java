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
        int number = 0;
        for (int i = 0;i<figures.size();i++){
            if (figures.get(i) instanceof Bishop){
                number++;
            }
        }
        return number;
    }
}

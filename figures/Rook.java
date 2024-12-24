package figures;

public class Rook extends Figure {
    private static final int value = 5;
    public Rook(char y, char x, boolean team) {
        super(x, y, team);
    }
    public Rook(boolean t){
        super(t);
    }
    public int getValue(){
        return value;
    }
}

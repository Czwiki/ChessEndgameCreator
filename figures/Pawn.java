package figures;

public class Pawn extends Figure {
    private static final int value = 1;
    public Pawn(char x, char y, boolean team) {
        super(x, y, team);
    }
    public Pawn(boolean t){
        super(t);
    }
    public int getValue(){
        return value;
    }
}

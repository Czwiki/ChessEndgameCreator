package figures;

public class Queen extends Figure {
    private static final int value = 9;
    public Queen(char x, char y, boolean team) {
        super(x, y, team);
    }
    public Queen(boolean t){
        super(t);
    }
    public int getValue(){
        return value;
    }
}

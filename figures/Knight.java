package figures;

public class Knight extends Figure {
    private static final int value = 3;
    public Knight(char x, char y, boolean team) {
        super(x, y, team);
    }
    public Knight(boolean t){
        super(t);
    }
    public int getValue(){
        return value;
    }
}

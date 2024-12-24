package figures;

public class King extends Figure {
    public static final int value = 0;
    public King(char x, char y, boolean team) {
        super(x, y, team);
    }
    public King(boolean t){
        super(t);
    }
    public int getValue(){
        return value;
    }
}

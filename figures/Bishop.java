package figures;

public class Bishop extends Figure {
    private boolean startcolor; // white is true
    private static final int value = 3;
    public Bishop(char x, char y, boolean color, boolean team) {
        super(x, y, team);
        startcolor = color;
    }
    public Bishop(boolean t){
        super(t);
    }
    public boolean getstartcolor(){
        return startcolor;
    }
    public int getValue(){
        return value;
    }
}

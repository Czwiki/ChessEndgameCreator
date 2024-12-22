package figures;

public class Bishop extends Figure {
    private boolean startcolor; // white is true
    private static final int value = 3;
    public Bishop(char x, char y, boolean color) {
        super(x, y);
        startcolor = color;
    }
    public boolean getstartcolor(){
        return startcolor;
    }
}

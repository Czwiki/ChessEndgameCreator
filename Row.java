import figures.Figure;

public class Row {
    private char row;
    private Figure[] figures;
    public Row(char row) {
        this.row = row;
        this.figures = new Figure[8];
    }
    public char getRowIndex() {
        return row;
    }
    public void addPiece(Figure figure) {
        figures[figure.getPosition().get(1)] = figure; 
    }
    public Figure getFigure(int position) {
        return figures[position];
    }
    public Figure[] getFigures() {
        return figures;
    }
}

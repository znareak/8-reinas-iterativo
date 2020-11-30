package pkg8.reinas;

public class Queen implements IChessElement {

    private int row;
    private int column;

    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /* public Queen(Queen queen) {
        this(queen.getRow(), queen.getColumn());
    }*/
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void addRow() {
        row++;
    }

    public void addColumn() {
        column++;
    }

    public void setCoords(int row, int column) {
        setRow(row);
        setColumn(column);
    }

    @Override
    public String toString() {
        return "Row: " + row + " Column: " + column;
    }
}

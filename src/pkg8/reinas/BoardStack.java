package pkg8.reinas;

public class BoardStack {

    final private int[][] board;
    final private int queens;

    public BoardStack(int queens) {
        board = new int[queens][queens];
        this.queens = queens;
        fillBoard();
    }

    public void fillBoard() {
        for (int i = 0; i < queens; i++) {
            for (int j = 0; j < queens; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void addQueen(int row, int column) {
        board[row][column] = 1;
    }

    public void removeQueen(int row, int column) {
        board[row][column] = 0;
    }

    private boolean hasQueenInBox(int row, int column) {
        return board[row][column] == 1;
    }

    public boolean isGoodRow(int row) {
        for (int column = 0; column < queens; column++) {
            if (board[row][column] == 1) return false;
        }
        return true;
    }

    public boolean isGoodColumn(int column) {
        for (int row = 0; row < queens; row++) {
            if ( board[row][column] == 1) return false;
        }
        return true;
    }

    public boolean isGoodDiagonal1(Queen queen) {
        int row = queen.getRow();
        int column = queen.getColumn();
        while ((row != -1) && (column != -1)) {

            if (board[row][column] == 1) {
                return false;
            }
            row--;
            column--;
        }
        row = queen.getRow();
        column = queen.getColumn();
        while ((row < queens) && (column < queens)) {

            if (board[row][column] == 1) {
                return false;
            }
            row++;
            column++;
        }

        return true;
    }

    public boolean isGoodDiagonal2(Queen queen) {
        int row = queen.getRow();
        int column = queen.getColumn();
        while ((row != -1) && (column < queens)) {

            if (board[row][column] == 1) {
                return false;
            }
            row--;
            column++;
        }
        row = queen.getRow();
        column = queen.getColumn();
        while ((row < queens) && (column >= 0)) {

            if (board[row][column] == 1) {
                return false;
            }
            row++;
            column--;
        }

        return true;
    }

    public boolean isGoodChessBox(Queen queen) {
        return isGoodColumn(queen.getColumn())
                && isGoodRow(queen.getRow())
                && isGoodDiagonal1(queen)
                && isGoodDiagonal2(queen);
    }

    public void addQueen(Queen queen) {
        addQueen(queen.getRow(), queen.getColumn());
    }

    public void removeQueen(Queen queen) {
        removeQueen(queen.getRow(), queen.getColumn());
    }

    public int getQueens() {
        return queens;
    }

    public int[][] getBoard() {
        return board;
    }

    public void printBoard() {
        Helpers.logLn("\n");
        for (int row = 0; row < queens; row++) {
            for (int column = 0; column < queens; column++) {
                if (hasQueenInBox(row, column)) {
                    Helpers.log("q ");
                } else {
                    Helpers.log("# ");
                }
            }
            Helpers.logLn("\n");
        }
    }
}

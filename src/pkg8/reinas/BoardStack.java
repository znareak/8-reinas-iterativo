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
            if (board[row][column] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isGoodColumn(int column) {
        for (int row = 0; row < queens; row++) {
            if (board[row][column] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isGoodDiagonal1(Queen queen) {
        for (int row = queen.getRow(), column = queen.getColumn(); row >= 0 && column >= 0; row--, column--) {
            if (board[row][column] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isGoodDiagonal2(Queen queen) {
        for (int row = queen.getRow(), column = queen.getColumn(); row >= 0 && column < queens; row--, column++) {
            if (board[row][column] == 1) {
                return false;
            }
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

    public void printBoard() {
        for (int row = 0; row < queens; row++) {
            for (int column = 0; column < queens; column++) {
                if (hasQueenInBox(row, column)) {
                    Helpers.log("Q ");
                } else {
                    Helpers.log("# ");
                }
            }
            Helpers.logLn("\n");
        }
    }
}

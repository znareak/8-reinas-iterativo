package pkg8.reinas;

import pkg8.reinas.Stack.piladinamica;
import static pkg8.reinas.Helpers.logLn;

public class MainProgram {

    final private static piladinamica<Queen> queensPlacedList = new piladinamica<Queen>();
    private static int queensPlaced = 0;
    private static int queens;
    private static int totalSolutions = 0;

    public MainProgram(int queens) {
        this.queens = queens;
        putQueens(0, 0, new Queen(0, 0), new BoardStack(queens));
    }

    private void putQueens(int row, int column, Queen queen, BoardStack board) {
        if (queens == 2 || queens == 3) {
            logLn("Para este número de reinas no hay soluciones.");
            return;
        }
        if (queensPlaced == queens) {
            totalSolutions++;
            if (queen.getColumn() >= 8) {
                board.fillBoard();
                queensPlaced = 0;
                while (queensPlacedList.top() != null) {
                    queen = queensPlacedList.pop();
                }
                queen.addColumn();
            }
            board.printBoard();
            logLn("Reinas colocadas: " + queensPlaced + "\nSolucion nro. " + totalSolutions + "\n\n");
        }

        if ((row >= queens) || (column >= queens)) {

            queen = queensPlacedList.pop();
            if (queen == null) {
                return;
            }
            board.removeQueen(queen);
            queensPlaced--;
            queen.addColumn();

        } else if (board.isGoodChessBox(queen)) {
            board.addQueen(queen);
            queensPlacedList.push(new Queen(row, column));
            queensPlaced++;
            queen.setCoords(row + 1, 0);

        } else {
            queen.addColumn();
        }
        putQueens(queen.getRow(), queen.getColumn(), queen, board);
    }
}

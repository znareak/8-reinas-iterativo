package pkg8.reinas;

import pkg8.reinas.Stack.piladinamica;
import static pkg8.reinas.Helpers.logLn;

public class MainProgram {

    final private static piladinamica<Queen> queensPlacedList = new piladinamica<Queen>();
    int row = 0, column = 0;
    private static Queen queen = new Queen(0, 0);
    private static BoardStack board;
    private static int queensPlaced = 0, totalSolutions = 0, queens;

    public MainProgram(int q) {
        queens = q;
        board = new BoardStack(q);
        while(queen != null)
            solutions();
        //solutions();
    }

    private void solutions() {
        if (queens == 2 || queens == 3) {
            logLn("Para este número de reinas no hay soluciones.");
            return;
        }
        
        if (queensPlaced == queens) {
            totalSolutions++;
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
        row = queen.getRow();
        column = queen.getColumn();
        //solutions();
    }
}
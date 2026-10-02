import java.util.List;

public class Board {
    private int size;
    private int filled;
    private Piece gameBoard[][];

    public Board(int size) {
        this.size = size;
        this.filled = 0;
        this.gameBoard = new Piece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }


    public boolean put(int row, int col, Piece piece) {
        if (row >= size || col >= size || gameBoard[row][col] != null) return false;
        gameBoard[row][col] = piece;
        filled++;
        return true;
    }

    public boolean isFull() {
        return filled == size * size;
    }

    public boolean isWinner(int row, int col, Piece piece) {

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < size; i++) if (gameBoard[i][col] != piece) rowMatch = false;
        for (int j = 0; j < size; j++) if (gameBoard[row][j] != piece) colMatch = false;
        for (int i = 0; i < size; i++) if (gameBoard[i][i] != piece) diagonalMatch = false;
        for (int i = 0; i < size; i++) if (gameBoard[i][size - 1 - i] != piece) antiDiagonalMatch = false;

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (gameBoard[i][j] == null) System.out.print(". ");
                else System.out.print(gameBoard[i][j] + " ");

            }

            System.out.println();
        }
    }


}

import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board board;
    private Deque<Player> players;

    public Game(Board board, Deque<Player> players) {
        this.board = board;
        this.players = players;
    }

    public Player startGame() {

        while (true) {

            if (board.isFull()) return null;
            board.printBoard();

            System.out.println("Its " + players.peekFirst() + " turn");
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter row no : ");
            int row = sc.nextInt();
            System.out.println("Enter col no : ");
            int col = sc.nextInt();

            Player player = players.pollFirst();
            Piece piece = player.getPiece();

            boolean status = board.put(row, col, piece);
            if (!status) {
                System.out.println("Please enter the valid input");
                players.offerFirst(player);
                continue;
            }

            players.offerLast(player);
            if (board.isWinner(row, col, piece)) return player;
        }
    }

}

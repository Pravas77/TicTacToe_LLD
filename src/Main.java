import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Board board = new Board(3);

        Deque<Player> players = new ArrayDeque<>();
        players.offerLast(new Player("P1", Piece.O));
        players.offerLast(new Player("P2", Piece.X));

        Game game = new Game(board, players);


        Player winner = game.startGame();
        if (winner != null) System.out.println("Winner is : " + winner);
        else System.out.println("Match drawn");


    }
}
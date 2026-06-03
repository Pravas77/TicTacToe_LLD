import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Player player1 = new Player("P1-John",Piece.O);
        Player player2 = new Player("P2-Michel",Piece.X);
        Deque<Player> players = new ArrayDeque<>();
        players.offerLast(player1);
        players.offerLast(player2);

        Game game = new Game(3,players);
        Player winner = game.start();

        if(winner == null) System.out.println("No Winner");
        else System.out.println(winner.getName());


    }
}
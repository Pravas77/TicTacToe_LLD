import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private int size;
    private Deque<Player> players;
    private Board board;

    public Game(int size, Deque<Player> players) {
        this.size = size;
        this.players = players;
        board = new Board(size);
    }


     public Player start(){


      while (true){

          if(board.isFull()) return null;
          board.printBoard();

          Scanner sc = new Scanner(System.in);
          String input = sc.nextLine();
          String arr[] = input.split(",");
          int row = Integer.valueOf(arr[0]);
          int col = Integer.valueOf(arr[1]);

          Player player = players.peekFirst();
          Piece piece = player.getPiece();


          boolean status = board.put(row,col,piece);
          if(!status) {
              System.out.println("Please enter the valid input");
              continue;
          }

          players.pollFirst();
          players.offerLast(player);


          if(board.isWinner(row,col,piece)) return player;


      }


     }





}

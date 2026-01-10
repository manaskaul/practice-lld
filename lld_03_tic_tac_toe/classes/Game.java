package lld_03_tic_tac_toe.classes;

import java.util.Deque;
import java.util.LinkedList;

import lld_03_tic_tac_toe.interfaces.Player;
import lld_03_tic_tac_toe.interfaces.WinStratergy;

public class Game {
    
    private Board gameBoard;

    private Player player1;
    private Player player2;

    private Deque<Player> turn;

    private boolean gameEnded = false;

    private WinStratergy winStratergy;


    public void startNewGame(int boardSize, Player player1, Player player2, WinStratergy stratergy) {
        
        createNewBoard(boardSize, stratergy);
        
        initlizePlayers(player1, player2);
        
        initlizePlayerTurn();

        gameEnded = false;
    }
    
    private void createNewBoard(int boardSize, WinStratergy stratergy) {
        gameBoard = new Board(boardSize);
        winStratergy = stratergy;
    }

    private void initlizePlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    private void initlizePlayerTurn() {
        turn = new LinkedList<>();

        turn.add(player1);
        turn.add(player2);
    }

    public void play() {
        while(!gameEnded) {
            // poll player from the turn queue
            Player player = turn.poll();

            // ask player to select their turn
            System.out.printf("Its %s\'s turn! ", player.getPlayerName());
            Move move = player.proposeMove(gameBoard);

            // check if the move is valid
            boolean isValidMove = gameBoard.isValidMove(move);

            // place the move on the board
            if(isValidMove) {
                gameBoard.placeSymbolAt(move, player.getPlayerSymbol());
            } else {
                System.out.println("Invalid move!");
                turn.offerFirst(player);
                continue;
            }

            // check if the player won the game
            boolean didPlayerWin = winStratergy.isWinning(gameBoard, player.getPlayerSymbol());
            
            if(didPlayerWin) {
                gameEnded = true;
                System.out.printf("%s has won!\n", player.getPlayerName());
                gameEnded = true;
                continue;
            }
            
            // check if the game is draw
            boolean isGameDraw = gameBoard.isBoardFull();
        
            if(isGameDraw) {
                System.out.printf("Its a Draw.\n");
                gameEnded = true;
                continue;
            }

            // add current player to the back of the queue
            turn.offerLast(player);
        }
    }
}

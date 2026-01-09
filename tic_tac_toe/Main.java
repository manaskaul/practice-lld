package tic_tac_toe;

import tic_tac_toe.classes.Game;
import tic_tac_toe.classes.HumanMoveStratergy;
import tic_tac_toe.classes.HumanPlayer;
import tic_tac_toe.classes.StandardWinStratergy;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.startNewGame(
            3, 
            new HumanPlayer("Alice", 'O', new HumanMoveStratergy()), 
            new HumanPlayer("Bob", 'X', new HumanMoveStratergy()),
            new StandardWinStratergy()
        );

        game.play();
    }
}

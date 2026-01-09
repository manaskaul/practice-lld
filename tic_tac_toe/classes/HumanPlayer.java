package tic_tac_toe.classes;

import tic_tac_toe.interfaces.MoveStratergy;
import tic_tac_toe.interfaces.Player;

public class HumanPlayer implements Player {

    private String playerName;
    private Character symbol;
    private MoveStratergy moveStratergy;

    public HumanPlayer(String name, char symbol, MoveStratergy stratergy) {
        this.playerName = name;
        this.symbol = symbol;
        this.moveStratergy = stratergy;
    }
    
    @Override
    public Move proposeMove(Board board) {
        return moveStratergy.proposeNextMove(board);
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public Character getPlayerSymbol() {
        return symbol;
    }
}

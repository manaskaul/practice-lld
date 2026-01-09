package tic_tac_toe.interfaces;

import tic_tac_toe.classes.Board;
import tic_tac_toe.classes.Move;

public interface Player {
    
    public Move proposeMove(Board board);

    public String getPlayerName();

    public Character getPlayerSymbol();

}

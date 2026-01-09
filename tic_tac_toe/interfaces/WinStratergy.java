package tic_tac_toe.interfaces;

import tic_tac_toe.classes.Board;

public interface WinStratergy {
    
    public boolean isWinning(Board board, Character symbol);

}

package lld_03_tic_tac_toe.interfaces;

import lld_03_tic_tac_toe.classes.Board;

public interface WinStratergy {
    
    public boolean isWinning(Board board, Character symbol);

}

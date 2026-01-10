package lld_03_tic_tac_toe.interfaces;

import lld_03_tic_tac_toe.classes.Board;
import lld_03_tic_tac_toe.classes.Move;

public interface MoveStratergy {

    public Move proposeNextMove(Board board);

}

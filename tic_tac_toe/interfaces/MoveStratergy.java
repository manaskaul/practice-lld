package tic_tac_toe.interfaces;

import tic_tac_toe.classes.Board;
import tic_tac_toe.classes.Move;

public interface MoveStratergy {

    public Move proposeNextMove(Board board);

}

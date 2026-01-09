package tic_tac_toe.classes;

import tic_tac_toe.interfaces.MoveStratergy;

public class BotMoveStratergy implements MoveStratergy {
    
    @Override
    public Move proposeNextMove(Board board) {
        System.out.println();
        int n = board.getSize();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board.isValidMove(new Move(i, j))) {
                    return new Move(i, j);
                }
            }
        }
        return new Move(0, 0);
    }

}

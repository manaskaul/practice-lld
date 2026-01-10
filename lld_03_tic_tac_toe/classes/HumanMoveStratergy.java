package lld_03_tic_tac_toe.classes;

import java.util.Scanner;

import lld_03_tic_tac_toe.interfaces.MoveStratergy;

public class HumanMoveStratergy implements MoveStratergy {

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public Move proposeNextMove(Board board) {
        System.out.printf("Enter your move: ");
        
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        return new Move(r, c);
    }

}

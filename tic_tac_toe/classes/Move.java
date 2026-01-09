package tic_tac_toe.classes;

import lombok.Getter;

@Getter
public class Move {
    private int r;
    private int c;

    public Move(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

package lld_03_tic_tac_toe.classes;

import lld_03_tic_tac_toe.interfaces.WinStratergy;

public class StandardWinStratergy implements WinStratergy {

    @Override
    public boolean isWinning(Board board, Character symbol) {
        int n = board.getSize();

        // Check rows
        for (int i = 0; i < n; i++) {
            boolean rowWin = true;
            for (int j = 0; j < n; j++) {
                Character cell = board.getCell(i, j);
                if (cell == null || cell != symbol) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            boolean colWin = true;
            for (int i = 0; i < n; i++) {
                Character cell = board.getCell(i, j);
                if (cell == null || cell != symbol) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        // Check main diagonal
        boolean diag1 = true;
        for (int i = 0; i < n; i++) {
            Character cell = board.getCell(i, i);
            if (cell == null || cell != symbol) {
                diag1 = false;
                break;
            }
        }
        if (diag1) return true;

        // Check anti-diagonal
        boolean diag2 = true;
        for (int i = 0; i < n; i++) {
            Character cell = board.getCell(i, n - i - 1);
            if (cell == null || cell != symbol) {
                diag2 = false;
                break;
            }
        }
        return diag2;
    }
}

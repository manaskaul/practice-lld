package tic_tac_toe.classes;

public class Board {
    
    private int size;
    private Character[][] board;
    private int freeSpaces;

    public Board(int size) {
        this.size = size;
        this.board = new Character[size][size];
        this.freeSpaces = size * size;
    }

    public boolean isValidMove(Move move) {
        return isMoveOnBoard(move) && isSpaceEmpty(move);
    }

    public boolean isMoveOnBoard(Move move) {
        return move.getR() >= 0 && move.getR() < board.length && move.getC() >= 0 && move.getC() < board[0].length;
    }

    private boolean isSpaceEmpty(Move move) {
        return board[move.getR()][move.getC()] == null;
    }

    public void placeSymbolAt(Move move, char symbol) {
        board[move.getR()][move.getC()] = symbol;
        freeSpaces--;
    }

    public boolean isBoardFull() {
        return freeSpaces == 0;
    }

    public int getSize() {
        return size;
    }

    public Character getCell(int r, int c) {
        return board[r][c];
    }

}

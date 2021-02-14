package org.brouse.buscaminas.game;

public class Board {
    private Cell[][] board;
    private int[][] selected;

    private final boolean solved = false;

    public Board(Cell[][] tablero) {
        this.board = tablero;
    }

    public Cell getSquare(int x, int y) {
        return board[x][y];
    }

    public boolean hasMine(int x, int y) {
        return getSquare(x, y).equals(Cell.MINE);
    }

    public boolean isSolved() {
        return solved;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void initialize() {

    }
}

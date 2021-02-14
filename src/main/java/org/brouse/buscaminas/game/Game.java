package org.brouse.buscaminas.game;

import org.brouse.buscaminas.Settings;

import java.util.Random;
import java.util.UUID;

public class Game implements Runnable {
    private static Thread thread;
    private static Player player;
    private static Board board;
    private static int time = 0;

    public void start() {
        if(thread == null) {
            thread = new Thread(this);
            player = new Player(UUID.randomUUID());
            board = new Board(setUpMines(2,3));
            board = new Board(nearMines());
            thread.start();
        }
    }

    public void run() {
        while (true) {
            for (int x = 0; x < Settings.size; x++) {
                for (int y = 0; y < Settings.size ; y++) {
                    System.out.print("["+ board.getBoard()[x][y]+ "] ");
                }
                System.out.print("\n");
            }
            thread.stop();
        }
    }
    private static Cell[][] setUpMines(int x, int y) {
        int mines_set = 0;

        Cell[][] board = calculateCenter(x, y);

        Random random = new Random();
        while (mines_set <= Settings.amount_mines) {
            int random_x = random.nextInt(Settings.size);
            int random_y = random.nextInt(Settings.size);

            if (board[random_x][random_y] != Cell.AIR) {
                board[random_x][random_y] = Cell.MINE;
                mines_set++;
            }
        }
        return board;
    }

    private static Cell[][] nearMines() {
        Cell[][] cells = board.getBoard();
        for (int x = 0; x < Settings.size; x++) {
            for (int y = 0; y < Settings.size; y++) {
                if (cells[x][y] == null || !cells[x][y].equals(Cell.MINE)) {
                    int near = 0;
                    for (int x1 = -1; x1 < 2; x1++) {
                        for (int y1 = -1; y1 < 2; y1++) {
                            try {
                                if (cells[x+x1][y+y1] == null)
                                    continue;
                                if (cells[x+x1][y+y1].equals(Cell.MINE))
                                    near++;
                            }catch (ArrayIndexOutOfBoundsException exception) {
                                //Ignore exceptions
                            }
                        }
                    }

                    for (Cell cell : Cell.values()) {
                        if (cell.getIdentifier() == near) {
                            cells[x][y] = cell;
                            break;
                        }
                    }
                }
            }
        }
        return cells;
    }

    private static Cell[][] calculateCenter(int x, int y) {
        Cell[][] toReturn = new Cell[Settings.size][Settings.size];
        for (int x1 = -1; x1 < 2; x1++) {
            for (int y1 = -1; y1 < 2; y1++) {
                toReturn[x+x1][y+y1] = Cell.AIR;
            }
        }
        return toReturn;
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public int getTime() {
        return time;
    }
}

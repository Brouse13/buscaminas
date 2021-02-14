package org.brouse.buscaminas.game;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static List<Game> processGames = new ArrayList<>();

    public static Game create() {
        Game game = new Game();
        for (Game gamelist : processGames) {
            if (gamelist.getPlayer().getUuid().equals(game.getPlayer().getUuid())) {
                throw new IllegalArgumentException("The player "+ game.getPlayer().getUuid()+ " is on a current game");
            }
        }
        return game;
    }

    public static void stopGame(Game game) {
        for (Game gamelist : processGames) {
            if (gamelist.getPlayer().getUuid().equals(game.getPlayer().getUuid())) {

            }
        }
    }



}

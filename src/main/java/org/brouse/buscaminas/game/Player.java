package org.brouse.buscaminas.game;

import java.util.UUID;

public class Player {
    private UUID uuid;
    private String username;

    private int games_played;
    private int games_wined;
    private int best_time;

    public Player(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public int getGames_played() {
        return games_played;
    }

    public int getGames_wined() {
        return games_wined;
    }

    public int getBest_score() {
        return best_time;
    }
}

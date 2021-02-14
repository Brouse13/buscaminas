package org.brouse.buscaminas.game;

public enum Cell {
    MINE(-1),
    AIR(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int identifier;

    Cell(int identifier) {
        this.identifier = identifier;
    }

    public int getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}

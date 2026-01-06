package org.loop.todo_list_api.enums;

public enum Dificuldades {
    FACIL(50),
    MEDIA(100),
    DIFICIL(200),
    EXTREMA(400);

    private final int xp;

    Dificuldades(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }
}
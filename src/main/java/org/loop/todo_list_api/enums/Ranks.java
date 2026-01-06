package org.loop.todo_list_api.enums;

public enum Ranks {

    BRONZE(0),
    PRATA(500),
    OURO(1500),
    PLATINA(3000);

    private final int xpMinimo;

    Ranks(int xpMinimo) {
        this.xpMinimo = xpMinimo;
    }

    public int getXpMinimo() {
        return xpMinimo;
    }

    public static Ranks calcularRank(int xpTotal) {
        Ranks rankAtual = BRONZE;

        for (Ranks rank : values()) {
            if (xpTotal >= rank.xpMinimo) {
                rankAtual = rank;
            }
        }

        return rankAtual;
    }
}

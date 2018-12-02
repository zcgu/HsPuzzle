package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Card implements Source {
    public enum Category {
        MINION,
        SPELL,
        WEAPON;
    }

    private final String name;
    private final Category category;
    private final int cost;

    public Card(String name, Category category, int cost) {
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public void play(Board board, Target target) {
        board.getMyHero().setMana(board.getMyHero().getMana() - cost);
        board.getCards().remove(this);
    }

    public abstract List<Target> getTargets(Board board);

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
    }
}

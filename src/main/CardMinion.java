package main;

import java.util.HashSet;
import java.util.Set;

public abstract class CardMinion extends Card {

    private final int maxHp;
    private final int atk;
    private Set<Ability> abilities;
    private Set<Race> races;

    public CardMinion(String name, int cost, int maxHp, int atk, Set<Ability> abilities, Set<Race> races) {
        super(name, Category.MINION, cost);
        this.maxHp = maxHp;
        this.atk = atk;
        this.abilities = abilities;
        this.races = races;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAtk() {
        return atk;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public Set<Race> getRaces() {
        return races;
    }

    @Override
    public void play(Board board, Target target) {
        super.play(board, target);
        if (target instanceof Target.PlaceOnBoard) {
            Minion minion = new Minion(this.getName(),
                    this.maxHp,
                    this.maxHp,
                    this.atk,
                    new HashSet<>(this.abilities),
                    new HashSet<>(this.races));

            board.getMyMinions().add(minion);

        } else if (abilities.contains(Ability.MAGNETIC) && target instanceof Minion) {
            Minion minion = (Minion) target;

            minion.setAtk(minion.getAtk() + this.atk);
            minion.setMaxHp(minion.getMaxHp() + this.maxHp);
            minion.setHp(minion.getHp() + this.maxHp);
            minion.getAbilities().addAll(this.abilities);
            minion.getRaces().addAll(this.races);

        } else {
            throw new IllegalArgumentException();
        }
    }
}

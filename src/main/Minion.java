package main;

import java.util.HashSet;
import java.util.Set;

public class Minion implements Source, Target {
    private final String name;
    private int maxHp;
    private int hp;
    private int atk;
    private Set<Ability> abilities;
    private Set<Race> races;

    private boolean canAttack;

    public Minion(String name, int maxHp, int hp, int atk, Set<Ability> abilities, Set<Race> races) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = hp;
        this.atk = atk;
        this.abilities = abilities;
        this.races = races;

        if (abilities.contains(Ability.RUSH)) {
            canAttack = true;
        }
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void heal(int num) {
        hp = Math.min(maxHp, hp + num);
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public boolean canAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    @Override
    public Minion clone() {
        Minion minion = new Minion(name, maxHp, hp, atk, new HashSet<>(abilities), new HashSet<>(races));
        minion.canAttack = canAttack;
        return minion;
    }
}

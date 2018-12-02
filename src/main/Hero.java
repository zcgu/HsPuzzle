package main;

public class Hero implements Target {
    private int maxHp;
    private int hp;
    private int maxMana;
    private int mana;

    public Hero(int hp, int mana) {
        this.maxHp = 30;
        this.hp = hp;
        this.maxMana = mana;
        this.mana = mana;
    }

    public void heal(int num) {
        hp = Math.min(maxHp, hp + num);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMana() {
        return mana;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public Hero clone()  {
        Hero hero = new Hero(hp, mana);
        hero.maxHp = maxHp;
        hero.maxMana = maxMana;
        return hero;
    }
}

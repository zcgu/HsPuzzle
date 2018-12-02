package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Hero myHero;
    private List<Minion> myMinions;
    private List<Minion> oppMinions;
    private List<Card> cards;

    public Board(Hero myHero, List<Minion> myMinions, List<Minion> oppMinions, List<Card> cards) {
        this.myHero = myHero;
        this.myMinions = myMinions;
        this.oppMinions = oppMinions;
        this.cards = cards;
    }

    public Hero getMyHero() {
        return myHero;
    }

    public List<Minion> getMyMinions() {
        return myMinions;
    }

    public List<Minion> getOppMinions() {
        return oppMinions;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Target> allTargets() {
        List<Target> res = new ArrayList<>();

        res.addAll(oppMinions);
        res.addAll(myMinions);
        res.add(myHero);

        return res;
    }

    public List<Target> allMinionTargets() {
        List<Target> res = new ArrayList<>();

        res.addAll(oppMinions);
        res.addAll(myMinions);

        return res;
    }

    public List<Target> placeMinionTargets(CardMinion cardMinion) {
        List<Target> res = new ArrayList<>();

        if (cardMinion.getAbilities().contains(Ability.MAGNETIC)) {
            for (Minion minion : myMinions) {
                if (minion.getRaces().contains(Race.MECHANICAL)) {
                    res.add(minion);
                }
            }
        }

        if (myMinions.size() < 7) {
            res.add(Target.PLACE_ON_BOARD);
        }

        return res;
    }

    @Override
    public Board clone() {
        List<Minion> myMinionsCopy = new ArrayList<>();
        for (Minion minion : myMinions) {
            myMinionsCopy.add(minion.clone());
        }

        List<Minion> oppMinionsCopy = new ArrayList<>();
        for (Minion minion : oppMinions) {
            oppMinionsCopy.add(minion.clone());
        }

        return new Board(myHero.clone(), myMinionsCopy, oppMinionsCopy, new ArrayList<>(cards));
    }
}

package cards;


import main.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QiLiYaSi extends CardMinion {

    private static final Set<Ability> abilities = new HashSet<>();
    private static final Set<Race> races = new HashSet<>();

    static {
        abilities.add(Ability.BLOOD_SUCKER);
        abilities.add(Ability.RUSH);
        abilities.add(Ability.MAGNETIC);
        abilities.add(Ability.SHIELD);
        abilities.add(Ability.TAUNT);

        races.add(Race.MECHANICAL);
    }


    public QiLiYaSi() {
        super("奇利亚斯", 5, 2, 3,
                Set.of(Ability.BLOOD_SUCKER, Ability.RUSH, Ability.MAGNETIC, Ability.SHIELD, Ability.TAUNT),
                Set.of(Race.MECHANICAL));
    }

    @Override
    public List<Target> getTargets(Board board) {
        return board.placeMinionTargets(this);
    }
}

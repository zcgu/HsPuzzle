package cards;

import main.*;

import java.util.List;
import java.util.Set;

public class GangTieBaoNuZhe extends CardMinion {
    public GangTieBaoNuZhe() {
        super("钢铁暴怒者", 4, 1, 5, Set.of(Ability.RUSH), Set.of(Race.MECHANICAL));
    }

    @Override
    public List<Target> getTargets(Board board) {
        return board.placeMinionTargets(this);
    }
}

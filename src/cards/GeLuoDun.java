package cards;

import main.*;

import java.util.List;
import java.util.Set;

public class GeLuoDun extends CardMinion {
    public GeLuoDun() {
        super("格洛顿", 1, 3, 1, Set.of(Ability.MAGNETIC), Set.of(Race.MECHANICAL));
    }

    @Override
    public List<Target> getTargets(Board board) {
        return board.placeMinionTargets(this);
    }
}

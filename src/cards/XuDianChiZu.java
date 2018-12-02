package cards;

import main.Board;
import main.Card;
import main.Target;

import java.util.List;

public class XuDianChiZu extends Card {
    public XuDianChiZu() {
        super("蓄电池组", Category.SPELL, 0);
    }

    @Override
    public void play(Board board, Target target) {
        super.play(board, target);
        board.getMyHero().setMana(board.getMyHero().getMaxMana());
    }

    @Override
    public List<Target> getTargets(Board board) {
        return List.of(Target.SPELL_NO_TARGET_NEED);
    }
}

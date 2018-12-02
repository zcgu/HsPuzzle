package cards;

import main.Board;
import main.Card;
import main.Minion;
import main.Target;

import java.util.List;

public class ShouZhuFuDeYongShi extends Card {
    public ShouZhuFuDeYongShi() {
        super("受祝福的勇士", Category.SPELL, 5);
    }

    @Override
    public void play(Board board, Target target) {
        if (!(target instanceof Minion)) {
            throw new IllegalArgumentException();
        }

        super.play(board, target);

        Minion minion = (Minion) target;
        minion.setAtk(minion.getAtk() * 2);
    }

    @Override
    public List<Target> getTargets(Board board) {
        return board.allMinionTargets();
    }
}

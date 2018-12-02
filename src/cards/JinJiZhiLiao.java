package cards;

import main.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JinJiZhiLiao extends Card {
    public JinJiZhiLiao() {
        super("禁忌治疗", Category.SPELL, 0);
    }


    @Override
    public void play(Board board, Target target) {
        super.play(board, target);

        int num = board.getMyHero().getMana() * 2;
        board.getMyHero().setMana(0);
        if (target instanceof Hero) {
            ((Hero) target).heal(num);
        } else if (target instanceof Minion) {
            ((Minion) target).heal(num);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Target> getTargets(Board board) {
        return board.allTargets();
    }
}

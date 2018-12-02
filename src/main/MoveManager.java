package main;

import java.util.ArrayList;
import java.util.List;

public class MoveManager {
    public static class Move {
        public final Source source;
        public final Target target;

        public Move(Source source, Target target) {
            this.source = source;
            this.target = target;
        }
    }

    public List<Move> getPossibleMoves(Board board) {
        List<Move> res = new ArrayList<>();

        for (Minion myMinion : board.getMyMinions()) {
            if (myMinion.canAttack()) {
                // TODO: handle taunt.
                for (Minion oppMinion : board.getOppMinions()) {
                    res.add(new Move(myMinion, oppMinion));
                }
            }
        }

        for (Card card : board.getCards()) {
            if (board.getMyHero().getMana() >= card.getCost()) {
                for (Target target : card.getTargets(board)) {
                    res.add(new Move(card, target));
                }
            }
        }

        // TODO: hero power.

        return res;
    }

    public void performMove(Board board, Move move) {
        if (move.source instanceof Card) {
            ((Card) move.source).play(board, move.target);
        } else if (move.source instanceof Minion) {
            performAttack(board, (Minion) move.source, (Minion) move.target);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void performAttack(Board board, Minion myMinion, Minion oppMinion) {
        myMinion.setHp(myMinion.getHp() - oppMinion.getAtk());
        oppMinion.setHp(oppMinion.getHp() - myMinion.getAtk());

        if (myMinion.getHp() <= 0) {
            board.getMyMinions().remove(myMinion);
        }
        if (oppMinion.getHp() <= 0) {
            board.getOppMinions().remove(oppMinion);
        }

        myMinion.setCanAttack(false);

        if (myMinion.getAbilities().contains(Ability.BLOOD_SUCKER)) {
            board.getMyHero().heal(myMinion.getAtk());
        }

        // TODO: handle shield.
    }
}

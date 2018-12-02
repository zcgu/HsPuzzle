package main;

import java.util.ArrayList;
import java.util.List;

public class PuzzleSolver {
    public interface GameEndComputer {
        public boolean win(Board board);
        public boolean lose(Board board);
    }

    private final Board initialBoard;
    private GameEndComputer gameEndComputer;
    private final MoveManager moveManager = new MoveManager();

    private List<MoveManager.Move> winMoves;

    public PuzzleSolver(Board initialBoard, GameEndComputer gameEndComputer) {
        this.initialBoard = initialBoard;
        this.gameEndComputer = gameEndComputer;
    }

    public void solve() {
        dfs(initialBoard, new ArrayList<>());
        if (winMoves == null) {
            System.out.println("Didn't find a solution");
            return;
        }
        print(winMoves);
    }

    private void dfs(Board board, List<MoveManager.Move> pastMoves) {
        if (winMoves != null) return;

        if (gameEndComputer.win(board)) {
            this.winMoves = new ArrayList<>(pastMoves);
            return;
        } else if (gameEndComputer.lose(board)) {
            return;
        }

        List<MoveManager.Move> moves = moveManager.getPossibleMoves(board);

        for (MoveManager.Move move : moves) {
            Board newBoard = board.clone();
            List<MoveManager.Move> newMoves = moveManager.getPossibleMoves(newBoard);
            moveManager.performMove(newBoard, newMoves.get(moves.indexOf(move)));
            pastMoves.add(move);
            dfs(newBoard, pastMoves);
            pastMoves.remove(move);

            if (winMoves != null) return;
        }
    }

    private void print(List<MoveManager.Move> moves) {
        for (MoveManager.Move move : moves) {
            StringBuilder sb = new StringBuilder();
            if (move.source instanceof Card) {
                Card card = (Card) move.source;
                sb.append("打出 ");
                sb.append(card.getName());
                if (!(move.target instanceof Target.PlaceOnBoard)) {
                    if (move.target instanceof Hero) {
                        sb.append(" -> ");
                        sb.append("自己");
                    } else if (move.target instanceof Minion) {
                        sb.append(" -> ");
                        sb.append(((Minion) move.target).getName());
                    } else {
                        // No target spell.
                    }
                }
            } else {
                sb.append("随从攻击 ");
                sb.append(((Minion) move.source).getName());
                sb.append(" -> ");
                sb.append(((Minion) move.target).getName());
            }
            System.out.println(sb.toString());
        }
    }
}

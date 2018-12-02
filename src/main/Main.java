package main;

import cards.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static PuzzleSolver.GameEndComputer fullHealedGameEndComputer = new PuzzleSolver.GameEndComputer() {
        @Override
        public boolean win(Board board) {
            return board.getMyHero().getHp() >= 30;
        }

        @Override
        public boolean lose(Board board) {
            return board.getMyHero().getHp() <= 0;
        }
    };

    private static void puzzle1() {
        Hero myHero = new Hero(1, 10);
        List<Minion> myMinionList = List.of(
                new Minion("微型机器人", 1, 1, 1, new HashSet<>(Arrays.asList(Ability.RUSH)), new HashSet<>(Arrays.asList(Race.MECHANICAL)))
        );
        List<Minion> oppMinionList = List.of(
                new Minion("活动假人", 2, 2, 0, new HashSet<>(), new HashSet<>())
        );
        List<Card> cards = Arrays.asList(
                new JinJiZhiLiao(),
                new GangTieBaoNuZhe(),
                new GeLuoDun(),
                new QiLiYaSi(),
                new ShouZhuFuDeYongShi(),
                new XuDianChiZu()
        );
        Board board = new Board(myHero, myMinionList, oppMinionList, cards);
        PuzzleSolver puzzleSolver = new PuzzleSolver(board, fullHealedGameEndComputer);
        puzzleSolver.solve();
    }

    public static void main(String[] args) {
        puzzle1();
    }
}

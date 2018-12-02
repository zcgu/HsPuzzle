package main;

public interface Target {
    public final static PlaceOnBoard PLACE_ON_BOARD = new PlaceOnBoard();
    public final static SpellNoTargetNeed SPELL_NO_TARGET_NEED = new SpellNoTargetNeed();

    public static class PlaceOnBoard implements Target {
    }

    public final class SpellNoTargetNeed implements Target {
    }

}

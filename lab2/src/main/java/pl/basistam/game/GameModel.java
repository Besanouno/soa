package pl.basistam.game;

public class GameModel {
    public String getCounterMove(String move) {
        if (move != null && !move.trim().isEmpty()) {
            move = move.toLowerCase();
            if ("scissors".equals(move)) {
                return "Rock";
            } else if ("rock".equals(move)) {
                return "Paper";
            } else if ("paper".equals(move)) {
                return "Scissors";
            } else {
                return "Error";
            }
        }
        return "Error";
    }
}

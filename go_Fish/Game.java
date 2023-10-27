package go_Fish;

import java.util.ArrayList;

public interface Game {
	void startGame(ImplementsDeck deckObj);
    boolean isGameOver();
    void playTurn(Player human, Player computer);
    void endGame();
}

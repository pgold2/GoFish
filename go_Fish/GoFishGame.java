package go_Fish;
import java.util.*;

//GoFishGame interface (implements Game)
	public class GoFishGame implements Game {
		private List<Player> players;
		private ImplementsDeck deckObj = new ImplementsDeck();
		HumanPlayer humanPlayer = new HumanPlayer();
		ComputerPlayer computerPlayer = new ComputerPlayer();
		
	public GoFishGame(List<Player> players, Deck deckObj) {
		this.players = players;
		this.deckObj = new ImplementsDeck();
	}
	public void startGame(ImplementsDeck deckObj) {
	
		for (Player player : players) {
			for (int i = 1; i < 7; i++) {
			Card card = deckObj.drawCard( );
			player.addToHand(card);
			}
		}
		while (!isGameOver() ) {
			playTurn(humanPlayer, computerPlayer);
		}
		endGame();
		}
	
	
	@Override
	public boolean isGameOver() {
		/*
		 * if (humanPlayer.getHand().isEmpty()|| computerPlayer.getHand().isEmpty()) {
		 * return false; } return true; }
		 */
	if (humanPlayer.getHand().isEmpty() && computerPlayer.getHand().isEmpty()) {
		  return false;
		  }
	return true; 
	}
	
	
	public void playTurn(Player humanPlayer, Player computerPlayer) {
		humanPlayer.play();
		computerPlayer.play();
	}
	
	public void endGame() {
		//Optionally, allow the players to start a new game if desired
		//Implement the logic for ending the game
		String winnerName;
		if (humanPlayer.getHumanTotal() > computerPlayer.getCompTotal()) {
			winnerName = humanPlayer.getName();
		} else if (humanPlayer.getHumanTotal() < computerPlayer.getCompTotal()) {
			winnerName = "Computer";
		} else {
			winnerName = "It's a tie!";
		}
		
		// Display the winner and their scores
		System.out.println("Game Over!");
		System.out.println("Winner: " + winnerName);
		System.out.println("Human Player's Score: " + humanPlayer.getHumanTotal());
		System.out.println("Computer Player's Score: " + computerPlayer.getCompTotal());
		}
}
	 
	 
	
	 

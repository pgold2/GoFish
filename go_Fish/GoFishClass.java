package go_Fish;

import java.util.*;

public class GoFishClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Create players
		List<Player> players = new ArrayList<>();
		Player humanPlayer = new HumanPlayer("Player 1", new ArrayList<Card>());
		Player computerPlayer = new ComputerPlayer("Computer", new ArrayList<Card>());

		players.add(humanPlayer);
		players.add(computerPlayer);

//	// Create deck
		ArrayList<Card> deck = new ArrayList<>();
		// ImplementsDeck deckObj = new ImplementsDeck(deck);

//Create deck
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		for (String suit : suits) {
			for (String rank : ranks) {
				Card cardObj = new ImplementsCard(rank, suit);
				deck.add(cardObj);// adds to deck arraylist
			}
		}
		
		ImplementsDeck deckObj = new ImplementsDeck(deck);

		deckObj.shuffleDeck(); // Make sure to shuffle the deck before starting the game
// Create and start the game

		GoFishGame game = new GoFishGame(players, deckObj);
		game.startGame(deckObj);
// Ask users if they want to play again
		System.out.println("Do you want to play again? (yes/no)");
		String playAgain = scanner.nextLine().toLowerCase();
		while (playAgain.equals("yes")) {
// Reset players' hands and start a new game
			for (Player player : players) {
				player.getHand().clear();
			}
			game.startGame(deckObj);
			System.out.println("Do you want to play again? (yes/no)");
			playAgain = scanner.nextLine().toLowerCase();
		}
		System.out.println("Thanks for playing!");
		scanner.close();
	}
}

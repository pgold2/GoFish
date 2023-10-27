
package go_Fish;

import java.util.*;

public class ComputerPlayer implements Player {
	private List<Card> hand = new ArrayList<Card>();
	private String name;
	private int compTotal = 0;

// Constructor for creating a player with the specified name
// public ComputerPlayer(String name) {
// this.name = name;
// }
// Constructor for creating a player with the specified name and the deck in
// hand
//public ComputerPlayer(List<Card> hand) {
// this.hand = hand;
// }
	public ComputerPlayer(String name, List<Card> hand) {
		this.name = name;
		this.hand = hand;
	}

	// empty constructor
	public ComputerPlayer() {
		this.name = name;
		this.hand = new ArrayList<Card>();
	}

	@Override
	// getter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	// gets list of cards in the player's hand
	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	// Adds a card to the player's hand
	@Override
	public void addToHand(Card card) {
		ImplementsDeck ImpdeckObj = new ImplementsDeck(); // creates a Deck object
		Card cardSelected = ImpdeckObj.drawCard();// calls the Deck's draw card method which returns a random card.
		hand.add(cardSelected);// adds the cardSelected to the hand ArrayList
	}

	@Override
	public void play() {
		System.out.println("---COMPUTER'S TURN---");
		Map<Card, Integer> itemCounts = new HashMap<>();
		List<Card> itemsWithFourOccurrences = new ArrayList<>();
		
		HumanPlayer humanPlayerObj = new HumanPlayer();
		ImplementsDeck implementsDeckObj = new ImplementsDeck();
		
		Random random = new Random();
		int randomInt = random.nextInt(2);// generates 0 or 1
		
		// displays computer's cards in hand
		// System.out.println("here's what's in computer's hand: " + hand);
		for (Map.Entry<Card, Integer> entry : itemCounts.entrySet()) {
			for (Card card : hand) {
				itemCounts.put(card, itemCounts.getOrDefault(card, 0) + 1);
				System.out.println("test" + card);

			}

			// computer player is putting down set of 4
			if (entry.getValue() == 4) {
				itemsWithFourOccurrences.add(entry.getKey());
				System.out.println("computer: I have a set! Putting down set of " + entry);
				hand.remove(entry.getKey());
				hand.remove(entry.getKey());
				hand.remove(entry.getKey());
				hand.remove(entry.getKey());// removes each of the 4 cards that have the same rank
				compTotal++;// gives the computer a point for the set
			}

			// } // closes for
			else {
				// computer figures out what card to ask for
				for (Card card : hand) {
					itemCounts.put(card, itemCounts.getOrDefault(card, 0) + 1);
				}
				// player is putting down set of 4
				if (entry.getValue() >= 2) {
					System.out.println("computer is asking for " + entry.getKey());
					Card askingForRank = entry.getKey();

					// ???? NOT SURE IF THIS WORKS IF THE PLAYER HAS MORE THAN ONE OF THESE CARDS
					// ????
					if (humanPlayerObj.getHand().contains(askingForRank)) {
						System.out.println("you have the card(s), handing over to computer");
						// adds to computer's hand
						hand.add(askingForRank);
						// removes from person's hand
						humanPlayerObj.getHand().remove(askingForRank);
					} // closes if
					else {
						int randInt = random.nextInt(hand.size());
						for (int i = 0; i < hand.size(); i++) {
							Card choosingRandomRank = hand.get(randomInt);
							System.out.println("computer is asking for " + choosingRandomRank);

							// if player has what computer wants then the card gets added to computer's hand
							// and is deleted from user's hand
							// ???? NOT SURE IF THIS WORKS IF THE PLAYER HAS MORE THAN ONE OF THESE CARDS
							// ????
							if (humanPlayerObj.getHand().contains(choosingRandomRank)) {
								System.out.println("you have the card(s), handing over to computer");
								// adds to computer's hand
								hand.add(choosingRandomRank);
								// removes from person's hand
								humanPlayerObj.getHand().remove(choosingRandomRank);
							} else {
								System.out.println("you: I don't have, GO FISH!");
								// computer picks card from deck
								// calls the implementsDeckObj's drawCard method to pick a card from the deck
								// and then adds the cardSelected to the players hand.
								Card cardSelected = implementsDeckObj.drawCard();
								hand.add(cardSelected);
								// System.out.println("now you have :" + hand + "in computer's hand");
							} // closes else
						} // closes else
					} // closes if
				} // closes for
			} // closes else
		} // closes for
	}// closes play

	public int getCompTotal() {
		return compTotal;
	}
}// closes class

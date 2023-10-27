package go_Fish;

import java.util.*;

public class HumanPlayer implements Player {
	private String name;
	private ArrayList<Card> hand;
	private int humanTotal = 0;

//constructor with name and hand
	public HumanPlayer(String name, ArrayList<Card> hand) {
		this.name = name;
		this.hand = new ArrayList<Card>();// Initialize the hand as an empty ArrayList
	}

//empty constructor 
	public HumanPlayer() {
		this.name = name;
		this.hand = new ArrayList<Card>();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	@Override
	public void addToHand(Card card) {
		hand.add(card);
	}

	@Override
	public void play() {
		Map<Card, Integer> itemCounts = new HashMap<>();
		ArrayList<Card> itemsWithFourOccurrences = new ArrayList<>();
		ComputerPlayer computerPlayerObj = new ComputerPlayer();
		Scanner scanner = new Scanner(System.in);
		ImplementsDeck implementsDeckObj = new ImplementsDeck();
//displays person's cards in hand
		System.out.println("here's what's in your hand: " + hand);
		for (Map.Entry<Card, Integer> entry : itemCounts.entrySet()) {
			for (Card card : hand) {
				itemCounts.put(card, itemCounts.getOrDefault(card, 0) + 1);
			}
// player is putting down set of 4
			if (entry.getValue() == 4) {
				itemsWithFourOccurrences.add(entry.getKey());
				System.out.println("You have a set! Putting down set of " + entry);
				hand.remove(entry.getKey());
				hand.remove(entry.getKey());
				hand.remove(entry.getKey());
				hand.remove(entry.getKey());// removes the card that there are 4 of
				humanTotal++;
			}
		} // closes for
		//System.out.println("------------\n1. pick from deck \n2.ask player for a card");
// player is asking computer for a card
		System.out.println("What card would you like to ask for? enter rank:");
		  //scanner.nextLine();
		String askingForRank = scanner.nextLine();
// creates a card object that holds the rank
		Card cardObj = new ImplementsCard(askingForRank);
// this checks if the card object created from the inputed rank
// is in the cards in Computer's "hand"
// and then adds to players hand
// and removes it from computer hand
// ???? NOT SURE IF THIS WORKS IF THE COMPUTER HAS MORE THAN ONE OF THESE CARDS
// ????
		if (computerPlayerObj.getHand().contains(cardObj)) {
			System.out.println("computer: I have, here you go");
// adds to human's hand
			hand.add(cardObj);
// removes from computer's hand
			computerPlayerObj.getHand().remove(cardObj);
			System.out.println("now you have " + hand + " in your hand");
		} // closes if
		else {
			System.out.println("computer: Sorry don't have, GO FISH");
//player picks card from deck 
//calls the implementsDeckObj's drawCard method to pick a card from the deck 
//and then adds the cardSelected to the players hand.
			Card cardSelected = implementsDeckObj.drawCard();
			hand.add(cardSelected);
			System.out.println("you picked  " + hand );
		} // closes else
	}// closes play method

	public int getHumanTotal() {
		return humanTotal;
	}
}// closes class

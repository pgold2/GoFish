package go_Fish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

	public class ImplementsDeck implements Deck {
		private ArrayList<Card> deck; 
		
			// constructor
		public ImplementsDeck(ArrayList<Card> deck) {
			this.deck = deck; 
		}
		
		//empty constructor
		public  ImplementsDeck() {
			    this.deck = new ArrayList<>();
			}

		
		//gets deck 
		public ArrayList<Card> getDeck() {
			return deck; 
		}
		
		//sets deck 
		public void setDeck(ArrayList<Card> deck) {
			this.deck = deck; 
		}
		
		// Draws a card from the deck and returns it
			public Card drawCard() {
			    Random random = new Random();
			    if (deck.isEmpty()) {
			        return null;
			    }
			    int randomInt = random.nextInt(deck.size());
			    Card cardSelected = deck.get(randomInt);
			    return cardSelected;
			}


		// Shuffles the order of cards in the deck
		public void shuffleDeck() {

			Collections.shuffle(deck);// shuffles the deck using a java collections. shuffle
			ArrayList<Card> shuffledDeck = new ArrayList<>(deck);// creates a new arrayList passing in the shuffled
																	// cards
			deck.addAll(shuffledDeck);// adds the shuffledDeck array list back to the original deck arrayList

		}

	}
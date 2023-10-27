 
package go_Fish;


public class ImplementsCard implements Card {
private String rank;
private String suit;


// constructor
	public ImplementsCard(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	//constructor for only rank
	public ImplementsCard(String rank) {
		this.rank = rank;
	}
	// empty constructor
	public ImplementsCard() {
		
	}
	// getter for rank
	public String getRank() {
		return rank;
	}
	// setter for rank
	public void setRank(String rank) {
		this.rank = rank;
	}
	// getter for suit
	public String getSuit() {
		return suit;
	}
	// setter for suit
	public void setSuit(String suit) {
		this.suit = suit;
	}
	// to string method
	public String toString(String rank, String suit) {
		StringBuilder sb = new StringBuilder();
		sb.append("your card is: " + rank + "of" + "suit");
	return sb.toString();
	}
}
 

 

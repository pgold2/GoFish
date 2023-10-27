package go_Fish;
import java.util.ArrayList;
import java.util.List;
public interface Player {
String getName();
List<Card> getHand();
void addToHand(Card card);
void play();
/*
public String getName();
public void setName(String name);
public List<Card> getHand();
public void setHand(List<Card> hand);
public void addToHand(Card card);
public void play();
*/
}//closes interface
 
 


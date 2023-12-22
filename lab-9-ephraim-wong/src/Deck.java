import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card>cards;
	public Deck() {
		// TODO Auto-generated constructor stub
		cards = new ArrayList<>();
		
		for(Suit suit : Suit.values()) {
			for(Rank rank:Rank.values()) {
				cards.add(new Card(rank,suit));
			}
		}
		
		//Collections.shuffle(cards);
	}
	public int size() {return cards.size();}
	@Override
	public String toString() {return cards.toString();}
	public Card draw() {
		if(!cards.isEmpty()) {
			return cards.remove(0);
		}
		return null;
	}
	public List<Card> draw(int Count){
		List<Card> drawnCards = new ArrayList<>();
		if(Count <=0) {
			return drawnCards;
		}
		for(int i = 0 ; i < Count; i++) {
			if(!cards.isEmpty()) {
				drawnCards.add(cards.remove(0));
			}
		}
		return drawnCards;
	}
	public void shuffle() {Collections.shuffle(cards);}
	public List<Card> getCardsByRank(Rank rank){
		List<Card> cardsRank = new ArrayList<>();
		for(Card card: cards) {
			if(card.getRank() == rank) {
				cardsRank.add(card);
			}
		}
		return cardsRank;
	}

}

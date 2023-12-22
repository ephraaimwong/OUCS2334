import java.util.Objects;

public class Card implements Comparable<Card>{
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		if(rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
		
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) {return false;}
		//downcast obj to card
		Card c1 = (Card) obj;
		return this.rank == c1.getRank() && this.suit == c1.getSuit();
	} 
	public Rank getRank() {return rank;}
	public Suit getSuit() {return suit;}
	@Override
	public int hashCode() {
		return Objects.hash(rank,suit);
	}
	public String toString() {
		return ""+getRank() + getSuit();
	}
	@Override
	public int compareTo(Card card) {
		// TODO Auto-generated method stub
		int suitComp = this.suit.compareTo(card.suit);
		if (suitComp == 0) {return this.rank.compareTo(card.rank);}
		return suitComp;
	}

}

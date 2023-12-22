import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	private static final Map<Rank, Integer> CARD_VALUES;
	private static final int MAX_VALUE = 21;
	static {
        CARD_VALUES = new HashMap<>();
        for(Rank rank: Rank.values()) {
            if(rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
                CARD_VALUES.put(rank,10);
            } 
            else if (rank == Rank.ACE){
                CARD_VALUES.put(rank,11);
            }
            else {
            	//assigning value of rank
                CARD_VALUES.put(rank, rank.ordinal()+2);
            }
        }
    }
	private List<Card>cards = new ArrayList<>();
	private int value=0;
	private int numAcesAs11=0;

	
	public BlackjackHand(Card c1, Card c2) {
		// TODO Auto-generated constructor stub
		if (c1 == null || c2 == null) {throw new IllegalArgumentException();}
		//cards = new ArrayList<>();
		cards.add(c1);
		cards.add(c2);
		//getValue();
	}
	public void addCard(Card card) {
		if(card == null) {throw new NullPointerException();}
		if(value>=21) {
			return;
		}
		if(card.getRank() == Rank.ACE) {numAcesAs11++;}
		cards.add(card);
		
	}
	public int size() {return cards.size();}
	public static Map<Rank, Integer> getCardValues(){
		return new HashMap<>(CARD_VALUES);
	}
	public List<Card> getCards(){
		return new ArrayList<>(cards);
	}
	public int getValue() {
		//int aceCount = 0;
		//int val = 0;
		value=0;
		numAcesAs11=0;
		for (Card card : cards) {
			Rank rank = card.getRank();
			if(rank == Rank.ACE) {
				numAcesAs11++;
				//value+=11;
			}
			value+= CARD_VALUES.get(card.getRank());
		}
		while(numAcesAs11>0 && !(value<=MAX_VALUE)) {
				value-=10;
			numAcesAs11--;
		}
		return value;
	}
	@Override
	public String toString() {return cards.toString();}

}



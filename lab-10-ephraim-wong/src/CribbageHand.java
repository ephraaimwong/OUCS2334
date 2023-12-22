import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CribbageHand {
	public static Map<Rank, Integer> CARD_VALUES;
	static {
		CARD_VALUES = Map.ofEntries(
				Map.entry(Rank.ACE, 1),
				Map.entry(Rank.TWO, 2),
				Map.entry(Rank.THREE, 3),
				Map.entry(Rank.FOUR, 4),
				Map.entry(Rank.FIVE, 5),
				Map.entry(Rank.SIX, 6),
				Map.entry(Rank.SEVEN, 7),
				Map.entry(Rank.EIGHT, 8),
				Map.entry(Rank.NINE, 9),
				Map.entry(Rank.TEN, 10),
				Map.entry(Rank.JACK, 10),
				Map.entry(Rank.QUEEN, 10),
				Map.entry(Rank.KING, 10)
				);
		CARD_VALUES = Collections.unmodifiableMap(CARD_VALUES);
	}
	public final List<Card> cards;
	public CribbageHand(Card c1, Card c2, Card c3, Card c4) {
		if (c1 == null) {throw new NullPointerException();}if (c2 == null) {throw new NullPointerException();}if (c3 == null) {throw new NullPointerException();}if (c4 == null) {throw new NullPointerException();}
		cards = Collections.unmodifiableList(List.of(c1,c2,c3,c4));
		
	}
	public Set<Set<Card>> fifteens(Card starter){
		Set<Card> hand = new HashSet<>(cards);
		hand.add(starter);
		
		Set<Set<Card>> subsets = new HashSet<>();
		Set<Set<Card>> powerset = powerSet(new ArrayList<>(hand));
		
		for(Set<Card> i:powerset) {
			int val = 0;
			for(Card j:cards) {
				val += CARD_VALUES.get(j.getRank());
			}
			if (val == 15) {subsets.add(i);}
		}
		return subsets;
		
		
		}
	public Set<Set<Card>> powerSet(List<Card> cards){
//		int index=0; Set<Card> currSet; 
//		Set<Set<Card>> powerSet = new HashSet<>();
//			if (index == cards.size()) {
//				powerSet.add(new HashSet<>(currSet));
//			}
//			currSet.add(cards.get(index));
//			powerSet(currSet);
			return null;
			
		}

}

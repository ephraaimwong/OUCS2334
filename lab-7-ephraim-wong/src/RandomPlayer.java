import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player{
	private Random generator = new Random();
	public RandomPlayer(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		
	}

	@Override
	public int[] getMove(int[] pileSizes) {
		// TODO Auto-generated method stub
		int numPiles = pileSizes.length;
		
		//adding pileindex where pile contains > 0
		List<Integer> validPileIndices = new ArrayList<Integer>();
		for(int i = 0;i < numPiles; i++) {
			if(pileSizes[i] > 0) {
				validPileIndices.add(i);
			}
		}
		//if no piles contain anything
		if (validPileIndices.isEmpty()) {
			return new int[] {0,0};
		}
		
		int randIndex = generator.nextInt(validPileIndices.size());
		int pileIndex = validPileIndices.get(randIndex) ;

		int maxItemsToTake = pileSizes[pileIndex];
		//returns the same pile if there is nothing to take
		if (maxItemsToTake == 0) {
			return new int[] {pileIndex, 0};
		}
		int itemsToTake = generator.nextInt(maxItemsToTake) + 1;
		return new int[] {pileIndex, itemsToTake};

	}

}

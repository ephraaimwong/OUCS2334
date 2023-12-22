import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerOfHanoi {
	private Map<Peg, Deque<Integer>> diskStacks;
	public TowerOfHanoi(int i, Peg start) {
		// TODO Auto-generated constructor stub
		if(i<=0) {throw new IllegalArgumentException();}if(start==null) {throw new NullPointerException();}
		diskStacks = new HashMap<>();
		for(Peg p:Peg.values()) {diskStacks.put(p,new ArrayDeque<>());}
		for(int idx=i;idx>=1;idx--) {diskStacks.get(start).push(idx);}
	}
	public Deque<Integer> getDiskStack(Peg p){if(diskStacks.get(p)==null) {throw new NullPointerException();}
		return new ArrayDeque<>(diskStacks.get(p));
	}
	
	public void moveDisk(Move m) {if(m==null) {throw new NullPointerException();}
		Peg from=m.from;Peg to=m.to; if(diskStacks.get(from).isEmpty()) {throw new IllegalArgumentException();}

		int radFrom = diskStacks.get(from).peek();
		int radTo = diskStacks.get(to).isEmpty() ? 0 : diskStacks.get(to).peek();

		if(radFrom>radTo && radTo!=0) {throw new IllegalArgumentException();}

		int disk = diskStacks.get(from).pop();
		System.out.println(disk);
		diskStacks.get(to).addFirst(disk);
	}
	public static List<Move> solve(int i, Peg start, Peg end){
		if(i<0) {throw new IllegalArgumentException();}if(start==null||end==null) {throw new NullPointerException();}if(i==0) {return new ArrayList<>();} if(start==end) {return new ArrayList<>();}
		List<Move> moves=new ArrayList<>();
		if(i>0) {
			Peg auxP = Peg.other(start,end);
			moves.addAll(solve(i-1,start,auxP));
			moves.add(Move.move(start,end));
			moves.addAll(solve(i-1,auxP,end));
		}
		return moves;
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<Peg.values().length;i++) {
			Peg p=Peg.values()[i];
			Deque<Integer> tempReversedDisks = new ArrayDeque<>(diskStacks.get(p));
			Deque<Integer> reversedDisks = new ArrayDeque<>();
			while(!tempReversedDisks.isEmpty()) {reversedDisks.add(tempReversedDisks.removeLast());}
			//reverse this
			if(p==Peg.LEFT) {result.append("  ");}
			if(p==Peg.RIGHT) {result.append(" ");}
			result.append(String.format("%s: %s",p,reversedDisks));
			if(i<Peg.values().length-1) {result.append(System.lineSeparator());}

		}
		return result.toString();
	}

}


public enum Move {
	LEFT_TO_MIDDLE(Peg.LEFT,Peg.MIDDLE),LEFT_TO_RIGHT(Peg.LEFT,Peg.RIGHT),MIDDLE_TO_RIGHT(Peg.MIDDLE,Peg.RIGHT),RIGHT_TO_LEFT(Peg.RIGHT,Peg.LEFT),RIGHT_TO_MIDDLE(Peg.RIGHT,Peg.MIDDLE),MIDDLE_TO_LEFT(Peg.MIDDLE,Peg.LEFT);
	public final Peg from;
	public final Peg to;
	private Move(Peg from, Peg to) {
		if(from==null||to==null) {throw new NullPointerException();}if(from==to) {throw new IllegalArgumentException();}
		this.from = from;
		this.to = to;
	}
	public static Move move(Peg from, Peg to) {
		if(from==null||to==null) {throw new NullPointerException();}if(from==to) {throw new IllegalArgumentException();}
		for(Move m:Move.values()) {if(m.from==from && m.to==to) {return m;}}
		return null;
	}
}

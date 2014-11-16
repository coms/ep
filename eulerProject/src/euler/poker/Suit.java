package euler.poker;

public enum Suit {

	CLUBS('C'), DIAMONDS('D'), HEARS('H'), SPADES('S'), UNKNOWN('U');
	
	private char shortName;
	
	private Suit(char c) {
		this.shortName = c;
	}
	
	public static Suit getSuitByChar(char c) {
		for (Suit suit : Suit.values()) {
			if (suit.shortName == c) {
				return suit;
			}
		}
		throw new IllegalArgumentException("Illegal Rank name: " + c);
	}
	
}

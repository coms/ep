package euler.poker;

public enum Rank {

	TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), 
	NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
	
	private char shortName;
	
	private Rank(char c) {
		this.shortName = c;
	}
	
	public static Rank getRankByChar(char c) {
		for (Rank r : Rank.values()) {
			if (r.shortName == c) {
				return r;
			}
		}
		throw new IllegalArgumentException("Illegal Rank name: " + c);
	}
	
	public static Rank getNext(Rank r) {
		switch(r) {
		case ACE:
			return TWO;
		case TWO:
			return THREE;
		case THREE:
			return FOUR;
		case FOUR:
			return FIVE;
		case FIVE:
			return SIX;
		case SIX:
			return SEVEN;
		case SEVEN:
			return EIGHT;
		case EIGHT:
			return NINE;
		case NINE:
			return TEN;
		case TEN:
			return JACK;
		case JACK:
			return QUEEN;
		case QUEEN:
			return KING;
		case KING:
			return ACE;
		default:
			return ACE;
		}
	}
	
}

package euler.poker;

public class Card implements Comparable<Card> {

	private Suit suit;
	private Rank rank;
	
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	public Suit getSuit() {
		return suit;
	}
	public Rank getRank() {
		return rank;
	}
	@Override
	public int compareTo(Card o) {
		return this.rank.compareTo(o.getRank());
	}
	@Override
	public String toString() {
		return this.rank.toString() + "|" + this.suit.toString();
	}
	
	
}

package euler.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerHand implements Comparable<PokerHand> {
	
	private ArrayList<Card> cards = new ArrayList<>();
	private ArrayList<Card> inHandCards = new ArrayList<>();
	private ArrayList<Card> notInHandCards = new ArrayList<>();
	private Map<Rank, Integer> count = new HashMap<Rank, Integer>();
	
	public PokerHand(String str) {
		String[] a = str.split(" ");
		for (String c : a) {
			Rank rank = Rank.getRankByChar(c.charAt(0));
			Suit suit = Suit.getSuitByChar(c.charAt(1));
			Card card = new Card(rank, suit);
			cards.add(card);
		}
		initCount();
		initInHandArrays();
	}

	private void initCount() {
		for (Card c : cards) {
			Rank r = c.getRank();
			Integer cnt = count.get(r); 
			if (cnt == null) {
				count.put(r, 1);
			} else {
				count.put(r, ++cnt);
			}
		}		
	}
	
	private Hands getHand() {
		if (isStraightFlush()) {
//			System.out.println("STRAIGHT FLUSH");
			return Hands.STRAIGHT_FLUSH;
		}		
		if (isFour()) {
//			System.out.println("FOUR");
			return Hands.FOUR;
		}
		if (isFullHouse()) {
//			System.out.println("FULL HOUSE");			
			return Hands.FULL_HOUSE;
		}		
		if (isFlush()) {
//			System.out.println("FLUSH");
			return Hands.FLUSH;
		}
		if (isStraight()) {
//			System.out.println("STRAIGHT");			
			return Hands.STRAIGHT;
		}			
		if (isThree()) {
//			System.out.println("THREE");			
			return Hands.THREE;
		}
		if (isTwoPairs()) {
//			System.out.println("TWO PAIRS");			
			return Hands.TWO_PAIRS;
		}		
		if (isOnePair()) {
//			System.out.println("ONE PAIR");
			return Hands.ONE_PAIR;
		}
//		System.out.println("HC");
		return Hands.HIGH_CARD;	
	}

	private boolean isStraightFlush() {
		return isFlush() && isStraight();
	}

	private boolean isFullHouse() {
		int pairs = 0;
		int tripples = 0;
		for (Map.Entry<Rank, Integer> e : this.count.entrySet()) {
			if (e.getValue().intValue() == 2) {
				pairs++;
			}
			if (e.getValue().intValue() == 3) {
				tripples++;
			}			
		}
		return pairs == 1 && tripples == 1;		
	}

	private boolean isStraight() {
		Collections.sort(cards);
		Card c = cards.get(0);
		Rank r = c.getRank();
		for (int i = 1; i < 5; i++) {
			r = Rank.getNext(r);
			if (!cards.get(i).getRank().equals(r)) { 
				return false;
			}
		}
		return true;
	}
	
	private boolean isTwoPairs() {
		int pairs = 0;
		for (Map.Entry<Rank, Integer> e : this.count.entrySet()) {
			if (e.getValue().intValue() == 2) {
				pairs++;
			}			
		}
		return pairs == 2;		
	}

	protected List<Card> getCards() {
		return this.cards;
	}

	private void initInHandArrays() {
		for (Card c : cards) {
			if (isInHand(c)) {
				inHandCards.add(c);
			} else {
				notInHandCards.add(c);
			}
		}
	}
	
	private ArrayList<Card> getInHandCards() {
		return this.inHandCards;
	}
	
	private ArrayList<Card> getNotInHandCards() {
		return this.notInHandCards;
	}
	
	private boolean isInHand(Card card) {
		boolean retval = false;
		for (Map.Entry<Rank, Integer> item : count.entrySet()) {
			if (item.getKey().equals(card.getRank()) && item.getValue().intValue() > 1) {
				return true;
			}
		}
		return retval;
	}
	
	@Override
	public int compareTo(PokerHand o) {
		int hands = getHand().compareTo(o.getHand());
//		System.out.println("hands : " + hands);
		if (hands == 0) {
			ArrayList<Card> tHandList = this.getInHandCards();
			ArrayList<Card> tNotInHandList = this.getNotInHandCards();
			ArrayList<Card> oHandList = o.getInHandCards();
			ArrayList<Card> oNotInHandList = o.getNotInHandCards();
			 
			Collections.sort(tHandList);
			Collections.sort(oHandList);
			for (int i = tHandList.size()-1; i >= 0; i--) {
				if (!tHandList.get(i).getRank().equals(oHandList.get(i).getRank())) {
//					System.out.println("[inHand]: " + tHandList.get(i) + " vs " + oHandList.get(i));
					return tHandList.get(i).getRank().compareTo(oHandList.get(i).getRank());
				}
			}
			
			Collections.sort(tNotInHandList);
			Collections.sort(oNotInHandList);
			for (int i = tNotInHandList.size()-1; i >= 0; i--) {
				if (!tNotInHandList.get(i).getRank().equals(oNotInHandList.get(i).getRank())) {
//					System.out.println("[notInHand]: " + tNotInHandList.get(i) + " vs " + oNotInHandList.get(i));
					return tNotInHandList.get(i).getRank().compareTo(oNotInHandList.get(i).getRank());
				}
			}	
		}
		return hands;
	}
	
	private boolean isN(int n) {
		for(Integer i : count.values()) {
			if (i.intValue() == n) {
				return true;
			}
		}
		return false;		
	}
	
	private boolean isOnePair() {
		return isN(2);
	}
	
	private boolean isThree() {
		return isN(3);
	}
	
	private boolean isFour() {
		return isN(4);
	}

	private boolean isFlush() {
		Suit s = cards.get(0).getSuit();
		for (Card c : cards) {
			if (!c.getSuit().equals(s)) {
				return false;
			}
		}
		return true;
	}

}
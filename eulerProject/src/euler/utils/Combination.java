package euler.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination {

	private List<Long> values = new ArrayList<Long>();
	
	private List<Long> coins = null;
	private List<Long> counters = null;
	
	private Set<List<Long>> founded = new HashSet<List<Long>>();
	
	private static int size = 0;
	
	public boolean addFounded(List<Long> c) {
		List<Long> copy = new ArrayList<Long>();
		for (Long n : c) {
			copy.add(n);
		}
		return this.founded.add(copy);
	}
	
	public Set<List<Long>> getFounded() {
		return this.founded;
	}
	
	public Combination(int size) {
		this.size = size;
		this.coins = new ArrayList<Long>(size);
		this.counters = new ArrayList<Long>(size);
		for (int i = 0; i < size; i++) {
			this.coins.add(null);
			this.counters.add(0L);
		}
	}
	
	public void setValues(Long... values) {
		Collections.addAll(this.values, values);
	}
	
	public void setRandomValues() {
		int valuesSize = values.size(); 
		for (int i = 0; i < size; i++) {
			coins.set(i, values.get((int) Math.floor(Math.random() * valuesSize))); 
		}
	}
	
	public void resetCounter() {
		Long firstVal = values.get(0);
		Collections.fill(coins, firstVal);
		Collections.fill(counters, 0L);
	}
	
	public List<Long> incrementCounter() {
		int i = 0;
		int pos = 0;
		int maxI = values.size() - 1;
		// cycle there
		Long v = counters.get(pos);
		if (v == maxI) {
			this.counters.set(pos, 0L);
			Long v2 = counters.get(++pos);
			this.counters.set(pos, ++v2);			
		} else {
			this.counters.set(pos, ++v);
			if (v2 == maxI) {
				this.counters.set(pos, 0L);
				Long v3 = counters.get(++pos);
				this.counters.set(pos, ++v3);				
			}
		}
		synchronizeCoins();
		return coins;
	}
	
	public void synchronizeCoins() {
		for (int i = 0; i < counters.size(); i++) {
			coins.set(i, values.get(counters.get(i).intValue()));
		}
	}
		
	public void sort() {
		Collections.sort(this.coins);
	}
	
	public List<Long> getCoins() {
		return coins;
	}	
	
	public Long sum() {
		Long retval = 0L;
		for (Long l : coins) {
			retval += l;
		}
		return retval;
	}
	
}

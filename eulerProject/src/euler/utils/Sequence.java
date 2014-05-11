package euler.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * Class represent sequence.
 */
public class Sequence {

	private List<Integer> pos = null;
	
	private Integer size = null;
	
	private String sequence = null;
	
	public static boolean isArithmeticSequence(List<Long> sq) {
		if (sq.size() < 3) {
			return false;
		}
		long diff = sq.get(1) - sq.get(0);
		return diff == (sq.get(2) - sq.get(1));
	}
	
	public Sequence(List<Integer> pos, Integer size, String sequence) {
		super();
		this.pos = pos;
		this.size = size;
		this.sequence = sequence;
	}

	public Sequence(Integer pos, Integer size, String sequence) {
		super();
		this.pos = new ArrayList<Integer>();
		this.pos.add(pos);
		this.size = size;
		this.sequence = sequence;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setPos(List<Integer> pos) {
		this.pos = pos;
	}

	public List<Integer> getPos() {
		return pos;
	}

	public void addPosition(Integer pos) {
		this.pos.add(pos);
	}


	@Override
	public String toString() {
		return "Sequence [pos=" + pos + ", size=" + size + ", sequence="
				+ sequence + "]";
	}
	
}

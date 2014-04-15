package euler.utils;

import java.util.List;

/*
 * Class represent sequence.
 */
public class Sequence {

	private List<Integer> pos = null;
	
	private Integer size = null;
	
	private String sequence = null;

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

	@Override
	public String toString() {
		return "Sequence [pos=" + pos + ", size=" + size + ", sequence="
				+ sequence + "]";
	}
	
}

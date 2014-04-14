package euler.utils;

/*
 * Class represent sequence.
 */
public class Sequence {

	private Integer pos = null;
	
	private Integer size = null;
	
	private String squence = null;

	public String getSquence() {
		return squence;
	}

	public void setSquence(String squence) {
		this.squence = squence;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Sequence [pos=" + pos + ", size=" + size + ", squence="
				+ squence + "]";
	}
	
}

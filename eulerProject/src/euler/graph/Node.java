package euler.graph;

import java.util.List;

public class Node {

	private long id;
	private long sumWeight;
	private boolean marked = false;
	
	private List<Link> outboundLinks;

	public Node(long id) {
		super();
		this.id = id;
		this.setSumWeight(0);
		this.setMarked(false);
	}

	public Node(long id, long sumWeight, boolean marked) {
		super();
		this.id = id;
		this.setSumWeight(sumWeight);
		this.setMarked(marked);
	}

	public void setOutboundLinks(List<Link> outboundLinks) {
		this.outboundLinks = outboundLinks;
	}

	public List<Link> getOutboundLinks() {
		return outboundLinks;
	}

	public void setSumWeight(long sumWeight) {
		this.sumWeight = sumWeight;
	}

	public long getSumWeight() {
		return sumWeight;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public boolean isMarked() {
		return marked;
	}
	
}

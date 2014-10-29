package euler.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private long id;
	private long sumWeight;
	private boolean marked = false;
	
	private List<Link> outboundLinks = new ArrayList<Link>();

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

	public void addLink(Link l) {
		outboundLinks.add(l);
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Node [id=");
		builder.append(id);
		builder.append(", sumWeight=");
		builder.append(sumWeight);
		builder.append(", marked=");
		builder.append(marked);
//		builder.append(", outboundLinks=");
//		builder.append(outboundLinks != null ? outboundLinks.subList(0,
//				Math.min(outboundLinks.size(), maxLen)) : null);
		builder.append("]");
		return builder.toString();
	}
}

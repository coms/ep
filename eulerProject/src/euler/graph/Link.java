package euler.graph;

public class Link {

	private long weight;
	private Node srcNode;
	private Node dstNode;
	private boolean isDirected = true;

	/**
	 * Directional link
	 * @param weight
	 * @param srcNode
	 * @param dstNode
	 */
	protected Link(long weight, Node dstNode) {
		super();
		this.weight = weight;
		this.dstNode = dstNode;
	}

	/**
	 * Directional link
	 * @param weight
	 * @param srcNode
	 * @param dstNode
	 */
	public Link(long weight, Node srcNode, Node dstNode) {
		super();
		this.weight = weight;
		this.srcNode = srcNode;
		this.dstNode = dstNode;
	}

	public Link(long weight, Node srcNode, Node dstNode, boolean isDirected) {
		super();
		this.weight = weight;
		this.srcNode = srcNode;
		this.dstNode = dstNode;
		this.isDirected = isDirected;
	}

	public long getWeight() {
		return weight;
	}

	public Node getSrcNode() {
		return srcNode;
	}

	public Node getDstNode() {
		return dstNode;
	}

	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link [weight=");
		builder.append(weight);
		builder.append(", srcNode=");
		builder.append(srcNode);
		builder.append(", dstNode=");
		builder.append(dstNode);
		builder.append(", isDirected=");
		builder.append(isDirected);
		builder.append("]");
		return builder.toString();
	}
}

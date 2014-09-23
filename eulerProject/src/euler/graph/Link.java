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
	
}

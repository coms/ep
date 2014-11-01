package euler.graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	private List<Node> nodes = new ArrayList<Node>();
	
	/**
	 * Return null if node is not found.
	 * @param id
	 * @return
	 */
	public Node getNodeById(long id) {
		for (Node n : nodes) {
			if (n.getId() == id) {
				return n;
			}
		}
		return null;
	}
	
	public Graph(String filename, boolean isProblem83) {
		Node startNode = new Node(0);
		long[][] a = loadFileIntoArray(filename);
		System.out.println(Arrays.deepToString(a));
		
		nodes.add(startNode);
		for (int i = 1; i <= ((a.length) * (a[0].length)); i++) {
			nodes.add(new Node(i));
		}
		Node endNode = new Node(999999); 
		nodes.add(endNode);

		int mi = a.length;
		int mj = a[0].length;

		// start node link
		startNode.addLink(new Link(a[0][0], startNode, nodes.get(1)));
		
		// end node link
		nodes.get(nodes.size() - 2).addLink(new Link(a[mi-1][mj-1], nodes.get(nodes.size() - 2), endNode));
		

		for (int i = 0; i < mi; i++) {
			for (int j = 0; j < mj; j++) {
				// create right link
				int srcNodeIndex = i*mi + j + 1;
				Node srcNode = nodes.get(srcNodeIndex);
				if (j < mj-1) {
					int dstNodeIndex = i*mi + j + 2;
					Node dstNode = nodes.get(dstNodeIndex);
					Link l = new Link(a[i][j+1], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create left link
				if (j > 0) {
					int dstNodeIndex = i*mi + j;
					Node dstNode = nodes.get(dstNodeIndex);
					Link l = new Link(a[i][j-1], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create down link
				if (i < mi-1) {
					int dstNodeIndex = (i+1)*mi + j + 1;
					Node dstNode = nodes.get(dstNodeIndex);
					Link l = new Link(a[i+1][j], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create up link
				if (i > 0) {
					int dstNodeIndex = (i-1)*mi + j + 1;
					Node dstNode = nodes.get(dstNodeIndex);
					Link l = new Link(a[i-1][j], srcNode, dstNode);
					srcNode.addLink(l);
				}
			}
		}
//		System.out.println(this);
		System.out.println("Generating ending.");
	}
	
	public Graph(String filename) {
		Node startNode = new Node(0);
		long[][] a = loadFileIntoArray(filename);
		System.out.println(Arrays.deepToString(a));
		
		nodes.add(startNode);
		for (int i = 1; i <= ((a.length) * (a[0].length)); i++) {
			nodes.add(new Node(i));
		}
		Node endNode = new Node(999999); 
		nodes.add(endNode);
		
		int mi = a.length;
		int mj = a[0].length;
		
		for (int i = 0; i < mi; i++) {
			for (int j = 0; j <= mj; j++) {
				int srcNodeIndex = j == 0? 0 : i*mi + j;
				int dstNodeIndex = j == 0? i*mi + 1 : i*mi + j + 1;
				Node srcNode = nodes.get(srcNodeIndex);
				Node dstNode = nodes.get(dstNodeIndex);
				Link l;
				// create right link
				if (j < mj) {
					l = new Link(a[i][j], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create down link
				if ((i < mi-1) && (srcNodeIndex > 0)) {
					dstNodeIndex = j == 0? i*mi + 1 : (i+1)*mi + j;
					dstNode = nodes.get(dstNodeIndex);
					l = new Link(a[i+1][j-1], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create up link
				if ((i > 0) && (srcNodeIndex > 0)) {
					dstNodeIndex = j == 0? i*mi + 1 : (i-1)*mi + j;
					dstNode = nodes.get(dstNodeIndex);
					l = new Link(a[i-1][j-1], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create finish links
				if (j == mj) {
					dstNode = nodes.get(nodes.size() - 1);
					l = new Link(0, srcNode, dstNode);
					srcNode.addLink(l);
				}
			}
		}
//		System.out.println(this);
		System.out.println("Generating ending.");
	}
	
	private long[][] loadFileIntoArray(String filename) {
		int width = getWidth(filename);
		int height = getHeight(filename);
		long[][] retval = new long[width][height];
		BufferedReader reader = null;
		try {
		  reader = new BufferedReader(new FileReader(new File(filename)));
		  String str = null;
		  int j = 0;
		  while((str = reader.readLine()) != null) {
			  String[] strNums = str.split(",");
			  for (int i = 0; i < width; i++) {
				  retval[j][i] = Integer.valueOf(strNums[i]);
			  }
			  j++;
		  }
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (IOException e) {
  		  e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retval;
	}

	public static int getHeight(String filename) {
	    InputStream is = null;
	    try {
	    	is = new BufferedInputStream(new FileInputStream(filename));
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	    } finally {
	        try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    return 0;
	}

	private int getWidth(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			String str = reader.readLine();
			String[] strNums = str.split(",");
			return strNums.length;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public List<Node> shortestRouteDeijkstra(long startNodeId, long endNodeId) {
		Node startNode = getNodeById(startNodeId);
		Node endNode = getNodeById(endNodeId);
		List<Node> retval = new LinkedList<Node>();
		startNode.setSumWeight(0);
		retval.add(startNode);		
		Node prevNode = startNode;
		Node nextNode = startNode;
		long id = 1;
		while (!isAllNodesMarked() && (prevNode != null)) {
			visitNode(prevNode);
//			prevNode = processingQueue.pollFirst();
//			if (prevNode == null) {
				prevNode = findNextNode(prevNode);
//			}
		}
		return retval;
	}
	
	private boolean isAllNodesMarked() {
		for (Node n : nodes) {
			if (!n.isMarked()) {
				return false;
			}
		} 
		return true;
		
	}
	
	private void visitNode(Node node) {
		System.out.println("visiting node : " + node);
		for (Link l : node.getOutboundLinks()) {
			Node n = l.getDstNode();
			System.out.println("\tcheckin node : " + n);
			if (!n.isMarked()) {
				long newWeight = node.getSumWeight() + l.getWeight();
				System.out.println("\tsuggested wight : " + newWeight);
				if (newWeight < n.getSumWeight()) {
					System.out.println("\t\treplace weight on node " + n + " to " + newWeight);					
					n.setSumWeight(newWeight);
				}
//				processingQueue.offerLast(n);
			}
		}
		node.setMarked(true);
	}
	
	private Node findNextNode(Node node) {
		Node nearestNode = null;
		long path = Long.MAX_VALUE;
		for (Link l : node.getOutboundLinks()) {
			if ((!l.getDstNode().isMarked()) && (l.getDstNode().getSumWeight() < path)) {
//			if (!l.getDstNode().isMarked()) {				
				nearestNode = l.getDstNode();
				path = l.getDstNode().getSumWeight();
			}
		}
		return nearestNode;
	}
	
	/**
	 * Shortest path from 0 to 999999.
	 * 
	 * @return
	 */
	public List<Node> shortestRouteDeijkstra() {
		return shortestRouteDeijkstra(0, 999999);
	}
	
	/**
	 * Shortest path from 0 to 999999.
	 * 
	 * @return
	 */
	public List<Node> shortestRouteAStar() {
		return shortestRouteAStar(0, 999999);
	}

	public List<Node> shortestRouteAStar(long startNodeId, long endNodeId) {
		List<Node> retval = new LinkedList<Node>();
		Set<Node> closedSet = new HashSet<Node>();
		Set<Node> openSet = new HashSet<Node>();
		Node startNode = getNodeById(startNodeId);
		openSet.add(startNode);
		Map pathMap = new HashMap();
		startNode.setSumWeight(0);
		while(!openSet.isEmpty()) {
			Node n = nodeWithMinimumWeight(openSet);
			if (n.getId() == endNodeId) {
				return retval;
			}
			openSet.remove(n);
			closedSet.add(n);
			for(Link l : n.getOutboundLinks()) {
				Node neightbor  = l.getDstNode();
				if (!closedSet.contains(neightbor)) {
					long score = n.getSumWeight() + l.getWeight();
					boolean isBetter = false;
					if (!openSet.contains(neightbor)) {
						openSet.add(neightbor);
						isBetter = true;
					} else {
						if (score < neightbor.getSumWeight()) {
							isBetter = true;
						} else {
							isBetter = false;
						}
					}
					if (isBetter) {
						pathMap.put(neightbor, n);
						neightbor.setSumWeight(score);
					}
				}
			}
		}
		return retval;
	}

	private Node nodeWithMinimumWeight(Set<Node> openSet) {
		Node minimumNode = null;
		long path = Long.MAX_VALUE;
		for (Node n : openSet) {
			if (n.getSumWeight() < path) {
				minimumNode = n;
				path = n.getSumWeight();
			}
		}
		return minimumNode;
	}
	
	@Override
	public String toString() {
		String header = "Graph [nodesCount : " + nodes.size() + "]\n";
		StringBuilder sb = new StringBuilder();
		for (Node node : nodes) {
			sb.append(node.getId()).append("{").append(node.getSumWeight()).append("} : ");
			for (Link linkToLinkedNode : node.getOutboundLinks()) {
				sb.append(linkToLinkedNode.getDstNode().getId()).append("[").append(linkToLinkedNode.getWeight()).append("] ");
			}
			sb.append("\n");
		}
		return header + sb.toString();
	}
	
}

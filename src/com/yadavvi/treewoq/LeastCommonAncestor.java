package com.yadavvi.treewoq;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeastCommonAncestor {

	private List<Integer> listOfNodes;
	public TreeNode root;

	public LeastCommonAncestor(List<Integer> list) {
		listOfNodes = list;
		root = createTree(listOfNodes);
	}

	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int value;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	public static TreeNode createTree(List<Integer> list) {
		TreeNode root = null;
		TreeNode temp, temp2;
		for (Integer integer : list) {
			if (root == null) {
				root = new TreeNode(integer);
				root.left = null;
				root.right = null;
				continue;
			}
			temp = root;
			temp2 = root;
			while (temp != null) {
				temp2 = temp;
				temp = (temp.value < integer) ? temp.right : temp.left;
			}

			if (temp2.value < integer) {
				temp2.right = new TreeNode(integer);
			} else {
				temp2.left = new TreeNode(integer);
			}
		}

		return root;
	}

	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		printTree(root.left);
		printTree(root.right);
	}

	public static boolean isInTree(TreeNode root, int p) {
		TreeNode node = root;
		while (node != null) {
			if (node.value == p)
				return true;
			node = (node.value < p) ? node.right : node.left;
		}
		return false;
	}

	public static int getLeastCommonAncestor(TreeNode root, int p, int q) {
		if (root == null) {
			throw (new IllegalArgumentException("root shouldn't be null"));
		}

		// System.out.println(getUnderScores(4));
		TreeNode node = root;
		while (node != null) {
			if (node.value == p || node.value == q)
				return node.value;
			if ((node.value < p && node.value > q)
					|| (node.value < q && node.value > p)) {
				return node.value;
			}

			node = (node.value < p && node.value < q) ? node.right : node.left;
		}
		return root.value;
	}

	private static int getMaximumHeight(TreeNode node) {
		if (node == null)
			return 0;
		int leftHeight = getMaximumHeight(node.left);
		int rightHeight = getMaximumHeight(node.right);
		return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
	}

	private static String getStartingSpace(int height) {
		int noOfSpaces = ((int) Math.pow(2, height - 1)) / 2;

		StringBuilder startSpaceStringBuilder = new StringBuilder();
		for (int i = 0; i < noOfSpaces; i++) {
			// No. of spaces added everytime is the width of every node value
			startSpaceStringBuilder.append("  ");
		}
		return startSpaceStringBuilder.toString();
	}

	private static String getUnderScores(int height) {
		int noOfElementsToLeft = ((int) Math.pow(2, height) - 1) / 2;
		int noOfUnderScores = noOfElementsToLeft
				- ((int) Math.pow(2, height - 1) / 2);

		StringBuilder underScoreStringBuilder = new StringBuilder();
		for (int i = 0; i < noOfUnderScores; i++) {
			// No. of underscores added everytime is the width of every node
			// value
			underScoreStringBuilder.append("__");
		}
		return underScoreStringBuilder.toString();
	}

	private static String getSpaceBetweenTwoNodes(int height) {
		int noOfNodesInSubTreeOfNode = ((int) Math.pow(2, height - 1)) / 2;
		/** Sum of spaces of the subtrees of nodes + the parent node */
		int noOfSpacesBetweenTwoNodes = noOfNodesInSubTreeOfNode * 2 + 1;

		StringBuilder spaceBetweenNodesStringBuilder = new StringBuilder();
		for (int i = 0; i < noOfSpacesBetweenTwoNodes; i++) {
			spaceBetweenNodesStringBuilder.append("  ");
		}
		return spaceBetweenNodesStringBuilder.toString();
	}

	private static void printNodes(LinkedList<TreeNode> queueOfNodes,
			int noOfNodesAtCurrentHeight, int height) {
		StringBuilder nodesAtHeight = new StringBuilder();
		String startSpace = getStartingSpace(height);
		String spaceBetweenTwoNodes = getSpaceBetweenTwoNodes(height);
		String underScore = getUnderScores(height);

		nodesAtHeight.append(startSpace);

		for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
			TreeNode node = (TreeNode) queueOfNodes.get(i);
			if (node == null)
				continue;
			queueOfNodes.add(node.left);
			queueOfNodes.add(node.right);
			nodesAtHeight.append(underScore);
			nodesAtHeight.append(String.format("%2d", node.value));
			nodesAtHeight.append(underScore);
			nodesAtHeight.append(spaceBetweenTwoNodes);
		}
		nodesAtHeight.substring(0, nodesAtHeight.length()
				- spaceBetweenTwoNodes.length());

		System.out.println(nodesAtHeight.toString());
	}

	private static String getSpaceBetweenLeftRightBranch(int height) {
		int noOfNodesBetweenLeftRightBranch = ((int) Math.pow(2, height - 1) - 1);

		StringBuilder spaceBetweenLeftRightStringBuilder = new StringBuilder();
		for (int i = 0; i < noOfNodesBetweenLeftRightBranch; i++) {
			spaceBetweenLeftRightStringBuilder.append("  ");
		}
		return spaceBetweenLeftRightStringBuilder.toString();
	}

	private static String getSpaceBetweenRightLeftBranch(int height) {
		int noOfNodesBetweenLeftRightBranch = (int) Math.pow(2, height - 1);

		StringBuilder spaceBetweenLeftRightStringBuilder = new StringBuilder();
		for (int i = 0; i < noOfNodesBetweenLeftRightBranch; i++) {
			spaceBetweenLeftRightStringBuilder.append("  ");
		}
		return spaceBetweenLeftRightStringBuilder.toString();
	}

	private static void printBranches(LinkedList<TreeNode> queueOfNodes,
			int noOfNodesAtCurrentHeight, int height) {
		if (height <= 1)
			return;
		StringBuilder brachesAtHeight = new StringBuilder();

		String startSpace = getStartingSpace(height);
		// startSpace.substring(0, startSpace.length());
		String leftRightSpace = getSpaceBetweenLeftRightBranch(height);
		String rightLeftSpace = getSpaceBetweenRightLeftBranch(height);

		brachesAtHeight
				.append(startSpace.substring(0, startSpace.length() - 1));

		for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
			brachesAtHeight.append("/").append(leftRightSpace).append("\\")
					.append(rightLeftSpace);
		}
		brachesAtHeight.substring(0,
				brachesAtHeight.length() - rightLeftSpace.length());

		System.out.println(brachesAtHeight.toString());
	}

	public static void prettyPrintTree(TreeNode root) {
		LinkedList<TreeNode> queueOfNodes = new LinkedList<>();
		int height = getMaximumHeight(root);
		int level = 0;
		int noOfNodesAtCurrentHeight = 0;

		queueOfNodes.add(root);

		while (!queueOfNodes.isEmpty()) {
			noOfNodesAtCurrentHeight = ((int) Math.pow(2, level));
			printNodes(queueOfNodes, noOfNodesAtCurrentHeight, height - level);
			printBranches(queueOfNodes, noOfNodesAtCurrentHeight, height
					- level);
			for (int i = 0; i < noOfNodesAtCurrentHeight; i++)
				queueOfNodes.remove();
			level++;
		}
	}

	public static void main(String[] args) {
		/*LeastCommonAncestor lca = new LeastCommonAncestor(Arrays.asList(4, 6,
				12, 24, 8, 9, 1, 3));
		LeastCommonAncestor.printTree(lca.root);*/
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(30, 20,
				40, 10, 25, 35, 50, 5, 15, 23, 28, 33, 38, 41, 55));
		LeastCommonAncestor.prettyPrintTree(lcs.root);
	}
}

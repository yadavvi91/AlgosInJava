package com.yadavvi.treewoq;

import java.util.Arrays;
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

		TreeNode node = root;
		while (node != null) {
			if (node.value == p || node.value == q)
				return node.value;
			if ((node.value < p && node.value > q)
					&& (node.value < q && node.value > p)) {
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
		int noOfUnderScores = noOfElementsToLeft - ((int) Math.pow(2, height - 1) / 2);
		
		StringBuilder underScoreStringBuilder = new StringBuilder();
		for (int i = 0; i < noOfUnderScores; i++) {
			// No. of underscores added everytime is the width of every node value
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
	
	
	/*public static void main(String[] args) {
		LeastCommonAncestor lca = new LeastCommonAncestor(Arrays.asList(4, 6,
				12, 24, 8, 9, 1, 3));
		LeastCommonAncestor.printTree(lca.root);
	}*/
}

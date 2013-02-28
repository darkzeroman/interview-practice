

import javax.swing.tree.DefaultMutableTreeNode;

/** Reconstructs a tree with inorder and preorder traversal */
public class ReconstructTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inorder = "abcdfg";
		String preorder = "dbacfg";
		DefaultMutableTreeNode root = constructTree(inorder, preorder);

		root = constructTree(inorder, preorder);
		System.out.println(root.getChildCount());
	}

	public static DefaultMutableTreeNode constructTree(String inorder, String preorder) {

		if (inorder.length() == 1 || preorder.length() == 1)
			return new DefaultMutableTreeNode(inorder.charAt(0));

		char rootData = preorder.charAt(0);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootData);
		int inorderSplitIndex = inorder.indexOf(rootData);
		String leftSubtreeInorder = inorder.substring(0, inorderSplitIndex);
		String rightSubtreeInorder = inorder.substring(inorderSplitIndex + 1);

		String[] subtreePreorder = makePreorder(preorder, leftSubtreeInorder);
		String leftSubtreePreorder = subtreePreorder[0];
		String rightSubtreePreorder = subtreePreorder[1];

		if (leftSubtreeInorder.length() > 0 && leftSubtreePreorder.length() > 0)
			root.add(constructTree(leftSubtreeInorder, leftSubtreePreorder));
		if (rightSubtreeInorder.length() > 0 && rightSubtreePreorder.length() > 0)
			root.add(constructTree(rightSubtreeInorder, rightSubtreePreorder));
		return root;

	}

	public static String[] makePreorder(String preorder, String leftSubtreeInorder) {
		for (int i = 1; i < preorder.length(); i++) {
			if (leftSubtreeInorder.indexOf(preorder.charAt(i)) == -1) {
				return new String[] { preorder.substring(1, i), preorder.substring(i) };
			}
		}
		return new String[] { preorder, "" };

	}
}

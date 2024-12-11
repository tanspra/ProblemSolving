package org.utility;

public class GraphUtil {

    public static void printTree(TreeNode root) {
        int height = getHeight(root); // Get the tree's height
        int width = (int) Math.pow(2, height) - 1; // Width for printing
        String[][] res = new String[height * 2 - 1][width]; // Adjusted for branches and nodes

        // Fill the array with spaces
        for (String[] row : res) {
            java.util.Arrays.fill(row, " ");
        }

        // Fill the 2D array with tree nodes and branches
        fillArray(root, res, 0, 0, width - 1);

        // Print the 2D representation of the tree
        for (String[] row : res) {
            System.out.println(String.join("", row));
        }
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static void fillArray(TreeNode node, String[][] res, int level, int left, int right) {
        if (node == null) {
            return;
        }

        int mid = (left + right) / 2; // Calculate the position for the current node
        res[level * 2][mid] = String.valueOf(node.val); // Place the node

        if (node.left != null) {
            res[level * 2 + 1][(left + mid) / 2] = "/"; // Add left branch
            fillArray(node.left, res, level + 1, left, mid - 1);
        }
        if (node.right != null) {
            res[level * 2 + 1][(mid + right) / 2] = "\\"; // Add right branch
            fillArray(node.right, res, level + 1, mid + 1, right);
        }
    }
}
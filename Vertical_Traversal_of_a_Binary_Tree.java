/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/* This solution use BFS traversal to traverse and calculate the x value of each node layer by layer.*/
class Solution {
    /* The map which stores a list of node values for each existing x value.*/
    private HashMap<Integer, ArrayList<Integer>> xmap;
    
    /* The map which stores the list of node values for each existing x in the current layer.*/
    private HashMap<Integer, ArrayList<Integer>> layermap;
    
    /* The map to store each treenode's x value.*/
    private HashMap<TreeNode, Integer> xmark;
    
    /* The map to store the current smallest x value.*/
    private int small;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        xmap = new HashMap<Integer, ArrayList<Integer>>();
        layermap = new HashMap<Integer, ArrayList<Integer>>();
        xmark = new HashMap<TreeNode, Integer>();
        xmark.put(root, 0);
        small = 0;
        
        Queue<TreeNode> s1 = new LinkedList<TreeNode>();
        Queue<TreeNode> s2 = new LinkedList<TreeNode>();
        
        s1.add(root);
        traverse(s1,s2);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (xmap.containsKey(small)) {
            result.add(xmap.get(small));
            small++;
        }
        return result;
    }
    
    /* The BFS traversal. */
    private void traverse(Queue<TreeNode> s1, Queue<TreeNode> s2) {
        if (s1.isEmpty()) {
            return;
        }
        while (!s1.isEmpty()) {
            TreeNode curr = s1.poll();
            int x = xmark.get(curr);
            if (x < small) {
                small = x;
            }
            if (layermap.containsKey(x)) {
                layermap.get(x).add(curr.val);
            } else {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(curr.val);
                layermap.put(x, tmp);
            }
            if (curr.left != null) {
                xmark.put(curr.left, x - 1);
                s2.add(curr.left);
            }
            if (curr.right != null) {
                xmark.put(curr.right, x + 1);
                s2.add(curr.right);
            }
        }
        
        for (int c: layermap.keySet()) {
            Collections.sort(layermap.get(c));
            if (xmap.containsKey(c)) {
                xmap.get(c).addAll(layermap.get(c));
            } else {
                xmap.put(c,layermap.get(c));
            }
        }
        
        layermap.clear();
        traverse(s2, s1);
    }
}

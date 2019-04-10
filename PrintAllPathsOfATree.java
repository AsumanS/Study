import java.util.LinkedList;

public class PrintAllPathsOfATree {
    static void printAllPaths(TreeNode root){
        if(root==null)
            return;
        printPaths(root, new LinkedList<Integer>());
    }
    static void printPaths(TreeNode root, LinkedList<Integer> list){
        if(root==null)
            return;
        list.add(root.val); 
        if(root.left==null && root.right==null)
            print(list);
        if(root.left!=null)
            printPaths(root.left, list);
        if(root.right!=null)
            printPaths(root.right, list);
        list.removeLast();
    }
    static void print(LinkedList<Integer> list){
        for(int i: list)
            System.out.print(i+" ");
        System.out.println();    
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		printAllPaths(root);
    }
}

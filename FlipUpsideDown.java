
public class FlipUpsideDown {
	static TreeNode flipUpsideDown(TreeNode root){
        if(root==null)
            return root;
        TreeNode prev=root;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        prev.left=null;
        prev.right=null;
        
        while(leftChild!=null){
            TreeNode nextLeft = leftChild.left;
            TreeNode nextRight=leftChild.right;
            leftChild.left = rightChild;
            leftChild.right = prev;
            prev=leftChild;
            leftChild=nextLeft;
            rightChild =nextRight;
            
        }
        return prev;
        
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(7);
		
		TreeNode n = flipUpsideDown(root);
		
		
	}
}

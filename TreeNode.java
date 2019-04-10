
public class TreeNode {

	public int val;
	public String name;
	public TreeNode left = null;
	public TreeNode right = null;
	
	public TreeNode(){
		
	}
	public TreeNode(int x){
		val=x;
	}
	public TreeNode(String s,int x){
		val=x;
		name=s;
	}	
	public int getValue(){
		return val;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public void setLeft(TreeNode node){
		left=new TreeNode();
		left=node;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public void setRight(TreeNode node){
		right = new TreeNode();
		right=node;
	}
	


}

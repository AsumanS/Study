
public class SingleValueTree {
	
	 static class MyBoolean{
		boolean value = false;
		MyBoolean(){
		}
		void setTrue() {
			value = true;
		}
		void setFalse() {
			value = false;
		}
	}
	
	  public static int findSingleValueTrees(TreeNode root){
	        if(root==null)
	            return 0;
	       
	        return findSingleValueTreesHelper(root,  new MyBoolean());
	    }
	    public static int findSingleValueTreesHelper(TreeNode root, MyBoolean isAllUnique){
	    	if(root==null) {
	    		//isAllUnique.setTrue();
	    		return 0;
	    	}
	    	
	        //no child
	        if(root.left==null && root.right ==null){
	            isAllUnique.setTrue();
	            return 1;
	        }
	        
	        MyBoolean leftUnique = new MyBoolean();
	        MyBoolean rightUnique = new MyBoolean();
	        
	        int left =findSingleValueTreesHelper(root.left, leftUnique);   
	        int right = findSingleValueTreesHelper(root.right, rightUnique);
	        

	        //at least one side is unique
	        if((leftUnique.value && root.left.val==root.val) || (rightUnique.value && root.right.val==root.val)){
	            isAllUnique.setTrue(); //there is a path coming from bottom to this node
	            return left+right+1;
	        }
	        
	        //no paths coming from bottom
	        return left+right;
	    }

		static boolean isBST(TreeNode root){
	        if(root==null)
	            return true;
	        if(root.left==null && root.right==null)
	            return true;
	        if(root.left==null && root.val<root.right.val)
	            return isBST(root.right);
	        if(root.right==null && root.val>=root.left.val)
	            return isBST(root.left);
	        if(root.left.val<=root.val && root.val>root.right.val)
	            return isBST(root.left) && isBST(root.right);
	        return false;    
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right=new TreeNode(3);
		
		System.out.println(isBST(root));
		//System.out.println(findSingleValueTrees(root));

	}

}

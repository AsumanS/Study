import java.io.*;
import java.util.*;


public class BinaryTreeToLinkedList {

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(){
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int val){
            this.val = val;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }

    private static class BinaryTree{
        public class Edge{
            public int parentNodeIndex;
            public int childNodeIndex;
            public String leftRightFlag;

            public Edge(){}

            public Edge(int parentNodeIndex, int childNodeIndex, String leftRightFlag){
                this.parentNodeIndex = parentNodeIndex;
                this.childNodeIndex = childNodeIndex;
                this.leftRightFlag = leftRightFlag;
            }
        }

        public int noOfNodes;
        public ArrayList<Integer> nodeValues;
        public int rootIndex;
        public int noOfEdges;
        public ArrayList<Edge> edges;
        public TreeNode root;

        public BinaryTree(){
            noOfNodes = 0;
            rootIndex = -1;
            noOfEdges =0;
            nodeValues = new ArrayList();
            edges = new ArrayList();
            root  = null;
        }

        public void readRawValues(){
            Scanner scan = new Scanner(System.in);
            
            noOfNodes = scan.nextInt();
            for(int i=0;i<noOfNodes;i++){
                int nodeVal = scan.nextInt();
                nodeValues.add(nodeVal);
            }

            rootIndex = scan.nextInt();

            noOfEdges = scan.nextInt();
            for(int i=0;i<noOfEdges;i++){
                int parentNodeIndex = scan.nextInt();
                int childNodeIndex = scan.nextInt();
                String leftRightFlag = scan.next();
                edges.add(new Edge(parentNodeIndex, childNodeIndex, leftRightFlag));
            }
        }

        public void buildFromRawValues(){
            if(noOfNodes == 0){
                root =  null;
                return;
            }

            ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
            for(int i=0;i<noOfNodes;i++){
                nodes.add(new TreeNode(nodeValues.get(i)));
            }

            for(int i=0;i<noOfEdges;i++){
                if(edges.get(i).leftRightFlag.equals("L")){
                    nodes.get(edges.get(i).parentNodeIndex).left_ptr 
                    = nodes.get(edges.get(i).childNodeIndex);
                }else{
                    nodes.get(edges.get(i).parentNodeIndex).right_ptr = nodes.get(edges.get(i).childNodeIndex);
                }
            }

            root = nodes.get(rootIndex);
            return;
        }
    }

    public static TreeNode readBinaryTree(){
        BinaryTree inputBinaryTree = new BinaryTree();
        inputBinaryTree.readRawValues();
        inputBinaryTree.buildFromRawValues();
        return inputBinaryTree.root;
    }

    public static void printCircularList(TreeNode circularListHead){
        if(circularListHead == null){
            System.out.println();
            return;
        }
        TreeNode tmpHead = circularListHead;
        while(tmpHead.right_ptr != circularListHead){
            System.out.print(tmpHead.val+" ");
            tmpHead = tmpHead.right_ptr;
        }
        System.out.println(tmpHead.val);
    }
    /*
    Complete the function below
*/
static TreeNode BSTtoLL(TreeNode root){
    if(root==null)
        return root;
        
    if(root.left_ptr==null && root.right_ptr==null){
        root.left_ptr=root;
        root.right_ptr=root;
        return root;
    }
    
    TreeNode leftHead = BSTtoLL(root.left_ptr);
    TreeNode rightHead = BSTtoLL(root.right_ptr);
    
    if(leftHead==null)
    	leftHead=root;
    else {
    	TreeNode leftTail = leftHead.left_ptr;
    	leftTail.right_ptr = root;
    	root.right_ptr=leftHead;
    	root.left_ptr=leftTail;
    	leftHead.left_ptr = root;
    }
    if(rightHead!=null) {
    	TreeNode rightTail=rightHead.left_ptr;
    	root.right_ptr=rightHead;
    	rightHead.left_ptr=root;
    	leftHead.left_ptr=rightTail;
    	rightTail.right_ptr=leftHead;
    }
    
    return leftHead;
}


public static void main(String[] args){
        try{
            TreeNode root = readBinaryTree();
            TreeNode result = BSTtoLL(root);
            printCircularList(result);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




/*
public class BinaryTreeToLinkedList {
    static TreeNode BSTtoLL(TreeNode root){
        if(root==null)
            return root;
        if(root.left==null && root.right==null){
            root.left=root;
            root.right=root;
            return root;
        }
        
        TreeNode leftHead = BSTtoLL(root.left);
        TreeNode rightHead = BSTtoLL(root.right);
       
        if(leftHead==null)
        	leftHead=root;
        else {
        	TreeNode leftTail = leftHead.left;
        	leftTail.right = root;
        	root.right=leftHead;
        	root.left=leftTail;
        	leftHead.left = root;
        }
        
        if(rightHead!=null) {
        	TreeNode rightTail=rightHead.left;
        	root.right=rightHead;
        	rightHead.left=root;
        	leftHead.left=rightTail;
        	rightTail.right=leftHead;
        }
        
        return leftHead;
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(0);
		root.left.right=new TreeNode(3);
		root.left.left.right=new TreeNode(1);
		root.right.right=new TreeNode(10);
		root.right.right.left=new TreeNode(8);
		root.right.right.right=new TreeNode(11);
		root.right.right.left.left=new TreeNode(6);
		root.right.right.left.right=new TreeNode(9);
		root.right.right.left.left.right=new TreeNode(7);
		
		TreeNode node = BSTtoLL(root);
		for(int i=0;i<12;i++) {
			System.out.print(node.val+" ");
			node=node.right;
		}
    }
}
*/

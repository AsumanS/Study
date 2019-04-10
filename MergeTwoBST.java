import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class MergeTwoBST {
	static class Node{

	    Node left;
	    Node right;
	    int key;

	    Node(int key) {
	        this.left = null;
	        this.right = null;
	        this.key = key;
	    }

	}
    public static Node mergeTwoBSTs(Node root1, Node root2) {
    // Write your code here
        if(root1==null) return root2;
        if(root2==null) return root1;
        
        List<Integer> list1 = inOrderTraverse(root1);
        List<Integer> list2 = inOrderTraverse(root2);
        
        List<Integer> mergedList = mergeTwoLists(list1,list2);
        
        return listToTree(mergedList, 0 , mergedList.size()-1);
        
    }
    
    public static List<Integer> inOrderTraverse(Node root){
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        
        result.addAll(inOrderTraverse(root.left));
        result.add(root.key);
        result.addAll(inOrderTraverse(root.right));
        
        return result;
    }
    public static List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2){
        if(list1.size()<list2.size())
            return mergeTwoLists(list2,list1);
        int i=0;
        for(int j=0;j<list2.size();j++){
            int x = list2.get(j);
            while(i<list1.size() && list1.get(i)<x)
                i++;
            list1.add(i,x);
            i++;
        }
        return list1;
    }
    
    public static Node listToTree(List<Integer> list, int start, int end){
        if(list==null || list.size()==0 || start>end)
            return null;
        if(start==end)
            return new Node(list.get(start));
        int mid = (end+1-start)/2 + start;
        Node root = new Node(list.get(mid));
        root.left = listToTree(list, start, mid-1);
        root.right = listToTree(list, mid+1,end);
        return root;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	/*Node root1 = new Node(5);
    	root1.left=new Node(2);
    	root1.left.right=new Node(3);
    	root1.left.left=new Node(1);
    	
    	Node root2 = new Node(30);
    	root2.left = new Node(28);
    	root2.right = new Node(29);
    	root2.left.left=new Node(27);
    	*/
    	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N1 = Integer.parseInt(bufferedReader.readLine().trim());
        int[] parent1 = new int[N1];
        int[] child1 = new int[N1];
        int[] key1 = new int[N1];
        
        for(int i = 0; i < N1; i++) {
            parent1[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        for(int i = 0; i < N1; i++) {
            child1[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        for(int i = 0; i < N1; i++) {
            key1[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        
        int N2 = Integer.parseInt(bufferedReader.readLine().trim());
        int[] parent2 = new int[N2];
        int[] child2 = new int[N2];
        int[] key2 = new int[N2];
        
        for(int i = 0; i < N2; i++) {
            parent2[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        for(int i = 0; i < N2; i++) {
            child2[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        for(int i = 0; i < N2; i++) {
            key2[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }
        
        
        int[][] tree1 = new int[N1][2];
        int[][] tree2 = new int[N2][2];

        for(int i = 0; i < N1; i++)
            tree1[i][0] = tree1[i][1] = -1;

        for(int i = 0; i < N2; i++)
            tree2[i][0] = tree2[i][1] = -1;

        int r1 = -1;
        for(int i = 0; i < N1; i++) {
            if(parent1[i] == -1)
                r1 = i;
            else{
                if(child1[i] == 0) {
                    tree1[parent1[i]][0] = i;
                }
                else if(child1[i] == 1) {
                    tree1[parent1[i]][1] = i;
                }
            }
        }
        
        int r2 = -1;
        for(int i = 0; i < N2; i++) {
            if(parent2[i] == -1)
                r2 = i;
            else{
                if(child2[i] == 0) {
                    tree2[parent2[i]][0] = i;
                }
                else if(child2[i] == 1) {
                    tree2[parent2[i]][1] = i;
                }
            }
        }

        Node root1 = buildTree(r1, key1, tree1);
        Node root2 = buildTree(r2, key2, tree2);

        Node root = mergeTwoBSTs(root1, root2);
        List<Integer> list1 = inOrderTraverse(root);
    	for(int i: list1)
    		System.out.print(i+" ");
       System.out.println();
    	Node merged = mergeTwoBSTs(root1, root2);
    	List<Integer> list2 = inOrderTraverse(merged);
    	for(int i: list2)
    		System.out.print(i+" ");
    }
    static class Height {
        int height;
    }
    
    static boolean isBalanced(Node temp, Height height) {
        if(temp == null) 
            return true;
        
        Height lh = new Height();
        Height rh = new Height();
        
        boolean l = isBalanced(temp.left, lh);
        boolean r = isBalanced(temp.right, rh);
        
        height.height = Math.max(lh.height, rh.height) + 1;
        
        if(Math.abs(lh.height - rh.height) <= 1 && l && r)
            return true;
        return false;
    }
    
    static void inOrderTraversal(Node temp, ArrayList<Integer> list) {
        if(temp == null)
            return;
        inOrderTraversal(temp.left, list);
        list.add(temp.key);
        inOrderTraversal(temp.right, list);
    }
    
    static Node buildTree(int idx, int[] key, int[][] tree) {
        Node root = new Node(key[idx]);
        if(tree[idx][0] != -1) {
            root.left = buildTree(tree[idx][0], key, tree);
        }
        if(tree[idx][1] != -1) {
            root.right = buildTree(tree[idx][1], key, tree);
        }
        return root;
    }

}

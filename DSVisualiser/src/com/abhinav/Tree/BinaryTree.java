package com.abhinav.Tree;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import javax.servlet.http.HttpServletResponse;
import javafx.util.Pair;


public class BinaryTree {
	
	public Node root; 
	public Map<Integer, Pair<Integer,Integer>> parents;
	public Map<Node, Integer> ids;
	public Map<Integer, Integer> ids_Data;
	public Map<Integer, Pair<Integer, Character>> childs;
	public Vector<Integer> levelNodes;
	public int nodeCount;
	public int height;
	
    class Node { 
        int data; 
        Node left, right; 
        Node(int data) 
        { 
            this.data = data; 
            this.left = null; 
            this.right = null; 
        } 
    } 
    
    
    public Node buildCompleteBinaryTreeLevelOrder(int[] arr, Node root, 
                                                int i) 
    { 
        if (i < arr.length) { 
            Node temp = new Node(arr[i]); 
            root = temp; 
  
            root.left = buildCompleteBinaryTreeLevelOrder(arr, root.left, 
                                             2 * i + 1); 

            root.right = buildCompleteBinaryTreeLevelOrder(arr, root.right, 
                                               2 * i + 2); 
        } 
        return root; 
    } 
    
    public Node buildAnyBinaryTreeLevelOrder(String str)
    {
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(",");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0].trim()));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i].trim();
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i].trim();
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    
    ///////////////////////////////////////////INORDER-PREORDER-STARTS////////////////////////////////////////////
    //utility function for preorder and inorder array to Binary Tree
    int preIndex = 0;
    int search(int arr[], int strt, int end, int value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    } 
    
    public Node buildBinaryTreeInorderPreorder(int in[], int pre[], int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd) 
            return null; 
  
        /* Pick current node from Preorder traversal using preIndex 
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]); 
  
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return tNode; 
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data); 
  
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        tNode.left = buildBinaryTreeInorderPreorder(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildBinaryTreeInorderPreorder(in, pre, inIndex + 1, inEnd); 
  
        return tNode; 
    } 
 

    ///////////////////////////////////////////INORDER-PREORDER-ENDS////////////////////////////////////////////
    
    

    ///////////////////////////////////////////INORDER-POSTORDER-STARTS////////////////////////////////////////////
    
    // Class Index created to implement pass by reference of Index 
    class Index { 
        int index; 
    } 
    
    Node buildBinaryTreeInorderPostorderUtil(int in[], int post[], int inStrt, int inEnd, Index pIndex) 
	{ 
		 // Base case 
		 if (inStrt > inEnd) 
		     return null; 
		
		 /* Pick current node from Postrder traversal using 
		    postIndex and decrement postIndex */
		 Node node = new Node(post[pIndex.index]); 
		 (pIndex.index)--; 
		
		 /* If this node has no children then return */
		 if (inStrt == inEnd) 
		     return node; 
		
		 /* Else find the index of this node in Inorder 
		    traversal */
		 int iIndex = search2(in, inStrt, inEnd, node.data); 
		
		 /* Using index in Inorder traversal, construct left and 
		    right subtress */
		 node.right = buildBinaryTreeInorderPostorderUtil(in, post, iIndex + 1, inEnd, pIndex); 
		 node.left = buildBinaryTreeInorderPostorderUtil(in, post, inStrt, iIndex - 1, pIndex); 
		
		 return node; 
	} 
	
	// This function mainly initializes index of root 
	// and calls buildUtil() 
	public Node buildBinaryTreeInorderPostorder(int in[], int post[], int n) 
	{ 
		Index pIndex = new Index(); 
		pIndex.index = n - 1; 
		return buildBinaryTreeInorderPostorderUtil(in, post, 0, n - 1, pIndex); 
	} 
	
	/* Function to find index of value in arr[start...end] 
	The function assumes that value is postsent in in[] */
	int search2(int arr[], int strt, int end, int value) 
	{ 
		 int i; 
		 for (i = strt; i <= end; i++) 
		 { 
		     if (arr[i] == value) 
		         break; 
		 } 
		 return i; 
	} 
	    

    ///////////////////////////////////////////INORDER-POSTORDER-ENDS////////////////////////////////////////////
  
    public void inOrder(Node root) 
    { 
        if (root != null) { 
            inOrder(root.left); 
            System.out.print(root.data + " "); 
            inOrder(root.right); 
        } 
    } 
    
    
    public void setValues(Node root) throws IOException
    {
    	
    	int id=1;
    	ids= new HashMap<>();
    	ids_Data= new HashMap<>();
    	
    	ids.put(root, id);
    	ids_Data.put(id, root.data);
    	id++;
    	
    	Queue<Node> q= new LinkedList<>();
    	q.add(root);
    	int levels=0;
    	
    	List<Vector<Integer>> list= new ArrayList<>();
    	levelNodes= new Vector<>();
    	
    	int width=0;
    	
    	//level order to set ids to nodes
    	while(true)
    	{
    		int size= q.size();
    		
    		if(size>width) width=size;
    		
    		if(size==0) break;
    		levelNodes.add(size);
    		while(size-->0)
    		{
    			Node temp= q.peek();
    			int data= temp.data;
    			nodeCount++;
    			q.remove();
    			
    			if(temp.left!=null)
    			{
    				q.add(temp.left);
    				ids.put(temp.left, id);
    				ids_Data.put(id, temp.left.data);
    				id++;
    			}
    			if(temp.right!=null)
    			{
    				q.add(temp.right);
    				ids.put(temp.right, id);
    				ids_Data.put(id, temp.right.data);
    				id++;
    			}
    		}
    		levels++;
    	}
    	
    	height= levels;
    	
    	//level order to set parents and their children
    	parents= new HashMap<>();
    	childs= new HashMap<>();
    	Queue<Node> q1= new LinkedList<>();
    	q1.add(root);
    	
    	//level order to set ids to nodes
    	while(true)
    	{
    		int size= q1.size();
    		if(size==0) break;
    		while(size-->0)
    		{
    			Node temp= q1.peek();
    			int data= temp.data;
    			q1.remove();
    			
    			boolean leftChild=false;
    			boolean rightChild=false;
    			
    			if(temp.left!=null)
    			{
    				q1.add(temp.left);
    				leftChild= true;
    				childs.put(ids.get(temp.left), new Pair(ids.get(temp), 'L'));
    			}
    			if(temp.right!=null)
    			{
    				q1.add(temp.right);
    				rightChild= true;
    				childs.put(ids.get(temp.right), new Pair(ids.get(temp), 'R'));
    			}
    			
    			if(!rightChild && leftChild) parents.put(ids.get(temp), new Pair(ids.get(temp.left), -1));
    			else if(rightChild && !leftChild) parents.put(ids.get(temp), new Pair(-1, ids.get(temp.right)));
    			else if(!rightChild && !leftChild) parents.put(ids.get(temp), new Pair(-1, -1));
    			else if(rightChild && leftChild) parents.put(ids.get(temp), new Pair( ids.get(temp.left), ids.get(temp.right)));
    		}
    	}
    
    }
}

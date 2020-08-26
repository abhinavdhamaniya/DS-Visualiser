package com.abhinav.Tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

import javafx.util.Pair;

class Node { 

	 int data; 
	 Node left, right; 
	
	 Node(int d) 
	 { 
	     data = d; 
	     left = right = null; 
	 } 
} 

class Index 
{ 
	int index = 0; 
} 

public class BinarySearchTree {
	
	Index index = new Index(); 
	public Node root; 
	public Map<Integer, Pair<Integer,Integer>> parents;
	public Map<Node, Integer> ids;
	public Map<Integer, Integer> ids_Data;
	public Map<Integer, Pair<Integer, Character>> childs;
	public Vector<Integer> levelNodes;
	public int nodeCount;
	public int height;
    public int width;
    
    public void defineRoot(int x)
    {
    	root= new Node(x);
    }
    
    Node constructTreeFromPreorderUtil(int pre[], Index preIndex, int low, int high, int size) 
    { 
          
        if (preIndex.index >= size || low > high) { 
            return null; 
        } 
  
        Node root = new Node(pre[preIndex.index]); 
        preIndex.index = preIndex.index + 1; 
  
        if (low == high) { 
            return root; 
        } 
  
        int i; 
        for (i = low; i <= high; ++i) { 
            if (pre[i] > root.data) { 
                break; 
            } 
        } 
  
        root.left = constructTreeFromPreorderUtil(pre, preIndex, preIndex.index,  
                                      i - 1, size); 
        root.right = constructTreeFromPreorderUtil(pre, preIndex, i, high, size); 
  
        return root; 
    } 

    public Node constructTreeFromPreorder(int pre[], int size) { 
        return constructTreeFromPreorderUtil(pre, index, 0, size - 1, size); 
    } 
    
    
    Node constructTreeFromPostorderUtil(int post[], Index postIndex, int key, int min, int max, int size)  
    { 
    	
        if (postIndex.index < 0) 
            return null; 
  
        Node root = null; 
  
        if (key > min && key < max)  
        { 
            root = new Node(key); 
            postIndex.index = postIndex.index - 1; 
  
            if (postIndex.index > 0)  
            { 
                root.right = constructTreeFromPostorderUtil(post, postIndex,  
                        post[postIndex.index],key, max, size); 
 
                root.left = constructTreeFromPostorderUtil(post, postIndex,  
                        post[postIndex.index],min, key, size); 
            } 
        } 
        
        return root; 
    } 
  
    public Node constructTreeFromPostorder(int post[], int size)  
    { 
        Index index = new Index(); 
        index.index = size - 1; 
        return constructTreeFromPostorderUtil(post, index, post[index.index], Integer.MIN_VALUE, Integer.MAX_VALUE, size); 
    } 
    
    //INSERTION->
    // This method mainly calls insertRec() 
    public void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.data) 
            root.left = insertRec(root.left, key); 
        else if (key > root.data) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
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

package com.abhinav.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhinav.Tree.BinaryTree;


@WebServlet("/InPostBinaryTreeController")
public class InPostBinaryTreeController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String inorderStr= req.getParameter("inorder");
		String inorderStrArray[]= inorderStr.split(",", 0);
		int n1= inorderStrArray.length;
		int inorder[]= new int[n1];
		for(int i=0; i<n1; i++)
		{
			inorder[i]= Integer.parseInt(inorderStrArray[i].trim());
		}
		
		String postorderStr= req.getParameter("preorder");
		String postorderStrArray[]= postorderStr.split(",", 0);
		int n2= postorderStrArray.length;
		int postorder[]= new int[n2];
		for(int i=0; i<n2; i++)
		{
			postorder[i]= Integer.parseInt(postorderStrArray[i].trim());
		}
		
		BinaryTree tree= new BinaryTree();
		
		tree.root = tree.buildBinaryTreeInorderPostorder(inorder, postorder, n1); 
        req.setAttribute("tree", tree);
        
        RequestDispatcher dis= req.getRequestDispatcher("inorderPostorderBinaryTree.jsp");
        dis.forward(req, res);
       
	}
}

package com.abhinav.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhinav.Tree.BinaryTree;


@WebServlet("/InPreBinaryTreeController")
public class InPreBinaryTreeController extends HttpServlet {
	
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
		
		String preorderStr= req.getParameter("preorder");
		String preorderStrArray[]= preorderStr.split(",", 0);
		int n2= preorderStrArray.length;
		int preorder[]= new int[n2];
		for(int i=0; i<n2; i++)
		{
			preorder[i]= Integer.parseInt(preorderStrArray[i].trim());
		}
		
		BinaryTree tree= new BinaryTree();
		
		tree.root = tree.buildBinaryTreeInorderPreorder(inorder, preorder, 0, n1-1); 
        
        req.setAttribute("tree", tree);
        
        RequestDispatcher dis= req.getRequestDispatcher("inorderPreorderBinaryTree.jsp");
        dis.forward(req, res);
	}


}

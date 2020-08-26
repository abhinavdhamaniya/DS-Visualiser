package com.abhinav.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhinav.Tree.BinaryTree;

@WebServlet("/ALOBinaryTreeController")
public class ALOBinaryTreeController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String str= req.getParameter("array");
		
		BinaryTree tree= new BinaryTree();
		
		tree.root = tree.buildAnyBinaryTreeLevelOrder(str); 
        
        req.setAttribute("tree", tree);
        
        RequestDispatcher dis= req.getRequestDispatcher("anyLevelOrderBinaryTree.jsp");
        dis.forward(req, res);
	}
	
}

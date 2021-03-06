package com.abhinav.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhinav.Tree.BinarySearchTree;
import com.abhinav.Tree.BinaryTree;

@WebServlet("/PreBSTController")
public class PreBSTController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String strArray= req.getParameter("array");
		String arrS[]= strArray.split(",", 0);
		int n= arrS.length;
		int arr[]= new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]= Integer.parseInt(arrS[i].trim());
		}
		
		BinarySearchTree tree= new BinarySearchTree();
		
		tree.root = tree.constructTreeFromPreorder(arr, n); 
        
        req.setAttribute("tree", tree);
        
        RequestDispatcher dis= req.getRequestDispatcher("preorderBST.jsp");
        dis.forward(req, res);
	}

}

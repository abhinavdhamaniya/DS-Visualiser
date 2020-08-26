package com.abhinav.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhinav.Tree.BinaryTree;

@WebServlet("/CLOBinaryTreeController")
public class CLOBinaryTreeController extends HttpServlet 
{
	
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
		
		BinaryTree tree= new BinaryTree();
		
		tree.root = tree.buildCompleteBinaryTreeLevelOrder(arr, tree.root, 0); 
        
        req.setAttribute("tree", tree);
        
        RequestDispatcher dis= req.getRequestDispatcher("completeLevelOrderBinaryTree.jsp");
        dis.forward(req, res);
	}

}

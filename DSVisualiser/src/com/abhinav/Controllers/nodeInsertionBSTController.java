package com.abhinav.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abhinav.Tree.BinarySearchTree;
import com.abhinav.Tree.BinaryTree;


@WebServlet("/nodeInsertionBSTController")
public class nodeInsertionBSTController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession ses= req.getSession();
		
		if(req.getParameter("submit")!=null)
		{
			String strElement= req.getParameter("nodeElement");
			int ele= Integer.parseInt(strElement.trim());
				
			if(ses.getAttribute("tree")==null)
			{
				BinarySearchTree tree = new BinarySearchTree();
				tree.defineRoot(ele);
				
				ses.setAttribute("tree", tree);
				req.setAttribute("tree", tree);
			}
			else
			{
				BinarySearchTree tree= (BinarySearchTree) ses.getAttribute("tree");
				tree.insert(ele);
				ses.setAttribute("tree", tree);
				req.setAttribute("tree", tree);
			}
			
			RequestDispatcher dis= req.getRequestDispatcher("nodeInsertionBST.jsp");
	        dis.forward(req, res);
		}
		else if(req.getParameter("reset")!=null)
		{
			ses.removeAttribute("tree");
			RequestDispatcher dis= req.getRequestDispatcher("nodeInsertionBST.jsp");
	        dis.forward(req, res);
		}
	}

}

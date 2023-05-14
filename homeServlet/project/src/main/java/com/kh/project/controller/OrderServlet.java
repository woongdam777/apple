package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String blackPen = req.getParameter("blackPen");
		String redPen = req.getParameter("redPen");
		String bluePen = req.getParameter("bluePen");
		String white = req.getParameter("white");
		
		int total = 0;

		total = Integer.parseInt(blackPen) * 500
			+ Integer.parseInt(redPen) * 700
			+ Integer.parseInt(bluePen) * 700
			+ Integer.parseInt(white) * 1000;
		
		if(total == 0) {
			
			resp.sendRedirect("/error");
			
		}else {
			
			req.setAttribute("name", name);
			req.setAttribute("blackPen", blackPen);
			req.setAttribute("redPen", redPen);
			req.setAttribute("bluePen", bluePen);
			req.setAttribute("white", white);
			req.setAttribute("total", total);
			
			RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/resultPage.jsp");
			
			dispatcher.forward(req, resp);
			
		}
		
	}
	
}

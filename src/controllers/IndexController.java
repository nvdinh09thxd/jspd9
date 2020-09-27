package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoryDAO;
import models.Categories;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO catDao = new CategoryDAO();
		ArrayList<Categories> catList = catDao.findAll();
		request.setAttribute("catList", catList);
		request.getRequestDispatcher("/views/anews/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

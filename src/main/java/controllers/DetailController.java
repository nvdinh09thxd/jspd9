package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoryDAO;
import daos.NewsDao;
import models.Categories;
import models.News;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO catDao = new CategoryDAO();
		ArrayList<Categories> catList = catDao.findAll();

		request.setAttribute("catList", catList);

		int id = Integer.parseInt(request.getParameter("id"));

		NewsDao newDao = new NewsDao();
		News itemNews = newDao.findById(id);

		request.setAttribute("itemNews", itemNews);

		RequestDispatcher rd = request.getRequestDispatcher("/views/anews/chitiet.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

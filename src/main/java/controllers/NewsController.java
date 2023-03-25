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

@WebServlet("/news")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO catDao = new CategoryDAO();
		ArrayList<Categories> catList = catDao.findAll();

		request.setAttribute("catList", catList);

		NewsDao newsDao = new NewsDao();
		ArrayList<News> listsNews = newsDao.findAll();

		request.setAttribute("listsNews", listsNews);

		RequestDispatcher rd = request.getRequestDispatcher("/views/anews/tintuc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

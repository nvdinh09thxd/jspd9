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

@WebServlet("/cat")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryDAO catDao = new CategoryDAO();
		ArrayList<Categories> catList = catDao.findAll();

		request.setAttribute("catList", catList);

		int cid = Integer.parseInt(request.getParameter("cid"));

		NewsDao newsDao = new NewsDao();
		ArrayList<News> listsNewsByIdCat = newsDao.findByIdCat(cid);

		request.setAttribute("listsNewsByIdCat", listsNewsByIdCat);
		RequestDispatcher rd = request.getRequestDispatcher("/views/anews/danhmuc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

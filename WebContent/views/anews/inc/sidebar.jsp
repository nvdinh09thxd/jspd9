<%@page import="models.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>Danh mục tin</h3>
<ul>
	<%
		if(request.getAttribute("catList")!=null){
		@SuppressWarnings("unchecked")
			ArrayList<Categories> catList = (ArrayList<Categories>) request.getAttribute("catList");
			for(Categories objCat : catList ){
	%>
	<li><a href="<%=request.getContextPath() %>/cat?cid=<%=objCat.getId()%>"><%= objCat.getName() %></a></li>
	<%}} %>
</ul>
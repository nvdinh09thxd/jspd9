<%@page import="models.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/anews/inc/header.jsp"%>

<!-- end content -->
<div id="content">
	<div class="content-left fl">
		<%@ include file="/views/anews/inc/sidebar.jsp"%>
	</div>
	<div class="content-right fr">
		<%
			if (request.getAttribute("itemNews")!=null) {
				News itemNews = (News)request.getAttribute("itemNews");
		%>
		<h3><%= itemNews.getName() %></h3>
		<div class="main-content">
			<p><%= itemNews.getDetails() %></p>
		</div>
		<%} %>
	</div>
	<div class="clr"></div>
</div>
<!-- end content -->

<%@ include file="/views/anews/inc/footer.jsp"%>
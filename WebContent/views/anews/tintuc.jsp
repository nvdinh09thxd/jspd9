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
		<h3>Tin tức</h3>
		<div class="main-content items-new">
			<ul>
				<%
					if (request.getAttribute("listsNews") != null) {
					ArrayList<News> listsNews = (ArrayList<News>) request.getAttribute("listsNews");
					for (News objNews : listsNews) {
						
				%>
				<li>
					<h2>
						<a href="<%=request.getContextPath()%>/detail?id=<%=objNews.getId()%>" title=""><%= objNews.getName() %></a>
					</h2>
					<div class="item">
						<p><%= objNews.getDescription() %></p>
						<div class="clr"></div>
					</div>
				</li>
				<%
					}}
				%>
			</ul>
		</div>
	</div>
	<div class="clr"></div>
</div>
<!-- end content -->

<%@ include file="/views/anews/inc/footer.jsp"%>
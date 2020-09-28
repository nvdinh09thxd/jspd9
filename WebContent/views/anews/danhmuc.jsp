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
				<h3>Tin tức :: Thời sự</h3>
				<div class="main-content items-new">
					<ul>
						<%
							if (request.getAttribute("listsNewsByIdCat")!=null) {
								ArrayList<News> listsNewsByIdCat = (ArrayList<News>) request.getAttribute("listsNewsByIdCat");
								for (News objNewsByIdcat: listsNewsByIdCat) {
									
						%>
						<li>
							<h2>
								<a href="<%=request.getContextPath() %>/views/anews/chitiet.jsp" title=""><%= objNewsByIdcat.getName() %></a>
							</h2>
							<div class="item">
								<p><%= objNewsByIdcat.getDescription() %></p>
								<div class="clr"></div>
							</div>
						</li>
						<% }}%>
					</ul>
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end content -->
		
<%@ include file="/views/anews/inc/footer.jsp"%>
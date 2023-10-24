<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">	
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
      <title>Insert title here</title>
      
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
   </head>
   
   <body>
         <div class="d-flex flex-column vh-100">
         <nav class="navbar navbar-dark bg-dark text-white font-weight-bold">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"> 
               <img src="${pageContext.request.contextPath}/resources/images/logo-spring.png" width="30" height="30" class="d-inline-block align-top">
               	전자정부프레임워크(Spring Framework)
            </a>
            <div>
               <div>
               		<%-- Ch08 --%>
               		<%-- <c:if test="${login == null}">
               			<a href="${pageContext.request.contextPath}/ch08/content" class="btn btn-success btn-sm">로그인</a>
					</c:if>
					<c:if test="${login != null}">
						<img src="${pageContext.request.contextPath}/resources/images/face/${login.mid}.png" width="30" height="30" />
						<a href="${pageContext.request.contextPath}/ch08/logout" class="btn btn-danger btn-sm" href="logout">로그아웃</a>
					</c:if> --%>
					
					<%-- Ch13 --%>
					<%-- <c:if test="${ch13Login == null}">
						<a href="${pageContext.request.contextPath}/ch13/join" class="btn btn-success btn-sm">회원가입</a>
						<a href="${pageContext.request.contextPath}/ch13/login" class="btn btn-success btn-sm">로그인</a>
					</c:if>
					<c:if test="${ch13Login != null}">
						<a href="${pageContext.request.contextPath}/ch13/logout" class="btn btn-danger btn-sm">로그아웃</a>
						(현재: ${ch13Login.mid}가 로그인됨)
					</c:if> --%>
					
					<%-- Ch17 --%>
					<div>
						<sec:authorize access="isAnonymous()">
							<a href="${pageContext.request.contextPath}/ch17/loginForm" class="btn btn-info btn-sm">로그인</a>
						</sec:authorize>
					
						<sec:authorize access="isAuthenticated()">
							<%-- 사이트간 요청 위조 방지가 비활성화되어 있을 경우 --%>  
							<a href="${pageContext.request.contextPath}/logout" 
							   class="btn btn-info btn-sm">로그아웃</a> 
							   
							<%-- 사이트간 요청 위조 방지가 활성화되어 있을 경우 --%>   
							<%-- <form method="post" action="${pageContext.request.contextPath}/logout" class="d-inline-block">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button class="btn btn-info btn-sm">로그아웃</button>
							</form> --%>
						</sec:authorize>
					</div>
               </div>
            </div>
         </nav>
   
         <div class="flex-grow-1 container-fluid">
            <div class="row h-100">
               <div class="col-md-4 p-3 bg-dark">
                  <div class="h-100 d-flex flex-column">
                     <div class="flex-grow-1" style="height: 0px; overflow-y: auto; overflow-x: hidden;">
                        <%@ include file="/WEB-INF/views/common/menu.jsp" %>
                     </div>
                  </div>
               </div>
   
               <div class="col-md-8 p-3">
                  <div class=" h-100 d-flex flex-column">
                     <div class="flex-grow-1 overflow-auto pr-3" style="height: 0px">
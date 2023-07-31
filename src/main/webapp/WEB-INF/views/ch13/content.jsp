<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">회원 서비스</div>
	<div class="card-body">
		<c:if test="${ch13Login == null}">
			<div class="mt-2">
				<a href="join" class="btn btn-info btn-sm">회원가입</a>
			</div>
			<div class="mt-2">
				<a href="login" class="btn btn-info btn-sm">로그인</a>
			</div>
		</c:if>
		<c:if test="${ch13Login != null}">
			<a href="logout" class="btn btn-info btn-sm">로그아웃</a>
			(현재: ${ch13Login.mid}가 로그인됨)
		</c:if>
	</div>
</div>

<div class="card m-2">
	<div class="card-header">게시판</div>
	<div class="card-body">
		<div class="mt-2">
			<a href="getBoardList" class="btn btn-info btn-sm">게시물 목록 가져오기</a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">요청 헤더 얻기 및 쿠키 사용</div>
	<div class="card-body">
		<div class="m-2">
			<a href="getHeaderValue" class="btn btn-sm btn-info">요청 헤더값 얻기</a>
		</div>
		<div class="m-2">
			<a href="createCookie" class="btn btn-sm btn-info">쿠키 생성</a>
			<a href="getCookie" class="btn btn-sm btn-info">쿠키 얻기(서버)</a>
			<a href="javascript:getCookie()" class="btn btn-sm btn-info">쿠키 얻기(JavaScript)</a>
			<script>
			 function getCookie() {
			 }
			</script>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
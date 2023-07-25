<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
   <div class="card-header">
      예외 처리
   </div>
   <div class="card-body">
      <div>
		<a href="handlingException1" class="btn btn-sm btn-info">try-catch</a>      
      </div>
      <div class="mt-2">
		<a href="handlingException2" class="btn btn-sm btn-info">NullPointerException</a>      
      </div>
      <div class="mt-2">
		<a href="handlingException3" class="btn btn-sm btn-info">ClassCastException</a>      
      </div>
      <div class="mt-2">
		<a href="handlingException4" class="btn btn-sm btn-info">Ch10SoldOutException</a>      
      </div>
      <div class="mt-2">
		<a href="handlingException5" class="btn btn-sm btn-info">Exception</a>      
      </div>
   </div>
</div>
   <%@ include file="/WEB-INF/views/common/footer.jsp"%>
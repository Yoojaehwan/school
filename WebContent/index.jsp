<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var "context" value="<%=request.getContextPath() %>>"></c:set>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>메인화면</title>
</head>
<body>
	<a href="${context}/member/Login.do">로그인 화면 이동</a>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>대여정보 조회</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
    <style>
        /* 기존 CSS 그대로 유지 */
        * {margin:0; padding:0; box-sizing:border-box;}
        body {background-color:#f5f5f5;}
        h2 {font-weight:400; margin-bottom:20px;}
        .mypage-wrapper { display: grid; grid-template-columns: 200px 1fr; gap: 40px; max-width: 1200px; margin: 40px auto; padding: 0 20px; }
        .sidebar { background-color:#f5f5f5; border-radius:0; box-shadow:none; height:auto; }
        .sidebar h3 { background:#ff4444; color:white; padding:15px; text-align:center; font-size:18px; font-weight:normal; margin-bottom:20px; }
        .sidebar a { display:block; text-align:center; padding:16px; border-bottom:none; text-decoration:none; color:#333; background-color:white; transition: background-color 0.3s ease, color 0.3s ease; font-weight:500; margin-bottom:10px; cursor:pointer; }
        .sidebar a.active { border:2px solid #ff4444; background-color:white; color:#ff4444; box-sizing:border-box; }
        .sidebar a:hover { background-color:#f0f0f0; }
        .content { display:flex; flex-direction:column; background:white; padding:30px; border-radius:8px; box-shadow:0 2px 10px rgba(0,0,0,0.05); }
        table { width:100%; border-collapse: collapse; margin-bottom:20px; }
        th, td { border:1px solid #ccc; padding:12px; text-align:center; }
        th { background:#f8f8f8; width:200px; }
        .btn { display:inline-block; padding:10px 20px; background:#ff4444; color:white; border-radius:6px; text-decoration:none; border:none; cursor:pointer; }
        .btn:hover { background:#e63636; }
        @media (max-width:768px){ .mypage-wrapper { grid-template-columns: 1fr; } .sidebar { width:100%; margin-bottom:20px; } }
    </style>
</head>
<body>

<jsp:include page="../common/notMainHeader.jsp"></jsp:include>

<div class="mypage-wrapper">
    <div class="sidebar">
        <h3>마이페이지</h3>
        <a href="${pageContext.request.contextPath}/member/update" class="btn">개인정보 조회</a>
        <a class="active">대여정보 조회</a>
    </div>

    <div class="content">
        <h2>대여정보 조회</h2>
        <table>
            <tr>
                <th>도서번호</th>
                <th>대여일</th>
                <th>반납예정일</th>
                <th>상태</th>
            </tr>
				<c:choose>
				    <c:when test="${not empty rentList}">
				        <c:forEach var="rent" items="${rentList}">
				            <tr>
				                <td>${rent.bookNo}</td>
				                <td>${rent.lendDate}</td>
				                <td>${rent.returnDate != null ? rent.returnDate : "미반납"}</td>
				                <td>${rent.returnDate != null ? "반납완료" : "대여중"}</td>
				            </tr>
				        </c:forEach>
				    </c:when>
				    <c:otherwise>
				        <tr><td colspan="4">대여한 도서가 없습니다.</td></tr>
				    </c:otherwise>
				</c:choose>
        </table>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>

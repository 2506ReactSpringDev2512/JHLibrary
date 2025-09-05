<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>

    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainHeader.css">
    <!-- 공통 푸터 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <!-- 사이드바 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginSidebar.css">

    <style>
        body {
            background-color: #f5f5f5;
        }

        .main-layout {
            display: grid;
            grid-template-columns: 200px 1fr; /* 사이드바 + 본문 */
            gap: 40px;
            max-width: 1200px;
            margin: 40px auto;
            padding: 0 20px;
        }

        .content-box {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            width: 100%;
        }

        h2 {
            font-size: 28px;
            margin-bottom: 20px;
            text-align: center;
        }

        .book-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
            gap: 20px;
        }

        .book-item {
            text-align: center;
        }

        .book-item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 4px;
            background: #ddd; /* 이미지 없는 경우 배경 */
        }

        .book-item .title {
            margin-top: 10px;
            font-size: 14px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <!-- 공통 헤더 -->
    <jsp:include page="../common/notMainHeader.jsp"></jsp:include>

    <div class="main-layout">
        <!-- 사이드바 -->
        <div class="sidebar">
            <h3>도서목록</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/bookList.jsp" class="active">도서목록</a></li>
                <li><a href="${pageContext.request.contextPath}/bookDetail.jsp">도서 상세 정보</a></li>
            </ul>
        </div>

        <!-- 본문 -->
        <div class="content-box">
            <h2>도서 목록</h2>
            <div class="book-grid">
                <c:choose>
                    <c:when test="${not empty bookList}">
                        <c:forEach var="book" items="${bookList}">
                            <div class="book-item">
                                <img src="${pageContext.request.contextPath}/BOOK-IMG/${book.image}" alt="${book.title}">
                                <div class="title">${book.title}</div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>등록된 도서가 없습니다.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

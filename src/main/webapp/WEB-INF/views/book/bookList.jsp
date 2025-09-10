<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>

    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/loginSidebar.css">

    <style>
        body {
            background-color: #f5f5f5;
        }

        .main-layout {
            display: grid;
            grid-template-columns: 200px 1fr;
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
            grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
            gap: 20px;
        }

        .book-item {
            background: #fff;
            padding: 15px;
            border: 1px solid #eee;
            border-radius: 6px;
            box-shadow: 0 1px 4px rgba(0,0,0,0.05);
            text-align: center;
        }

        .book-item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 4px;
            background: #ddd;
        }

        .book-item .title {
            margin-top: 10px;
            font-size: 15px;
            font-weight: bold;
        }

        .book-item form {
            margin-top: 10px;
        }

        .rent-btn {
            padding: 6px 12px;
            font-size: 14px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .rent-btn:disabled {
            background: #ccc;
            cursor: not-allowed;
        }
    </style>
</head>
<body>
    <!-- 공통 헤더 -->
    <jsp:include page="../common/notMainHeader.jsp" />

    <div class="main-layout">
        <!-- 사이드바 -->
        <div class="sidebar">
            <h3>도서목록</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/member/bookList" class="active">도서목록</a></li>
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
						        <!-- 이미지 클릭 시 상세 페이지로 이동 -->
						        <a href="${pageContext.request.contextPath}/member/bookDetail?bookNo=${book.bookNo}">
						            <img src="${pageContext.request.contextPath}/resource/images/${book.imagePath}" alt="${book.bookName}">
						        </a>
						         
						        <div class="title">${book.bookName}</div>
						
						        <form action="${pageContext.request.contextPath}/member/rentBook" method="post">
						            <input type="hidden" name="bookNo" value="${book.bookNo}" />
						            <c:choose>
						                <c:when test="${book.lendYn eq 'N'}">
						                    <button type="submit" class="rent-btn">대여하기</button>
						                </c:when>
						                <c:otherwise>
						                    <button type="button" class="rent-btn" disabled>대여불가</button>
						                </c:otherwise>
						            </c:choose>
						        </form>
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
    <jsp:include page="../common/footer.jsp" />
</body>
</html>

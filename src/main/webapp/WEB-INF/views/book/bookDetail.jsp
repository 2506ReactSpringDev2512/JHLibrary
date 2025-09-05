<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>도서 상세 정보</title>

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

        .book-detail {
            display: flex;
            gap: 30px;
            flex-wrap: wrap;
        }

        .book-detail img {
            width: 300px;
            height: 400px;
            object-fit: cover;
            border-radius: 4px;
            background: #ddd;
        }

        .book-info {
            flex: 1;
            min-width: 250px;
        }

        .book-info h3 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .book-info p {
            margin: 6px 0;
            font-size: 16px;
        }

        .book-info .description {
            margin-top: 15px;
            line-height: 1.5;
        }

        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            border-radius: 4px;
            text-decoration: none;
        }

        .back-link:hover {
            background-color: #0056b3;
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
                <li><a href="${pageContext.request.contextPath}/bookList.jsp">도서목록</a></li>
                <li><a href="${pageContext.request.contextPath}/bookDetail.jsp" class="active">도서 상세 정보</a></li>
            </ul>
        </div>

        <!-- 본문 -->
        <div class="content-box">
            <h2>도서 상세 정보</h2>

            <c:choose>
                <c:when test="${not empty book}">
                    <div class="book-detail">
                        <img src="${pageContext.request.contextPath}/BOOK-IMG/${book.image}" alt="${book.title}">
                        <div class="book-info">
                            <h3>${book.title}</h3>
                            <p><strong>저자:</strong> ${book.author}</p>
                            <p><strong>출판사:</strong> ${book.publisher}</p>
                            <p><strong>발행일:</strong> ${book.publishDate}</p>
                            <p><strong>ISBN:</strong> ${book.isbn}</p>
                            <div class="description">
                                <strong>설명:</strong>
                                <p>${book.description}</p>
                            </div>

                            <a href="${pageContext.request.contextPath}/bookList.jsp" class="back-link">목록으로 돌아가기</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>선택된 도서 정보가 없습니다.</p>
                    <a href="${pageContext.request.contextPath}/bookList.jsp" class="back-link">목록으로 돌아가기</a>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

    <!-- 공통 푸터 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

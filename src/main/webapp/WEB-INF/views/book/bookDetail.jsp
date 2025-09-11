<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>도서 상세 정보</title>

    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <!-- 공통 푸터 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
    <!-- 사이드바 CSS -->
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
                <li><a href="${pageContext.request.contextPath}/member/bookList">도서목록</a></li>
                <li><a href="${pageContext.request.contextPath}/member/bookDetail" class="active">도서 상세 정보</a></li>
            </ul>
        </div>

        <!-- 본문 -->
        <div class="content-box">
            <h2>도서 상세 정보</h2>

            <c:choose>
    <c:when test="${not empty book}">
        <div class="book-detail" style="display: flex; gap: 30px; flex-wrap: wrap;">
            <img src="${pageContext.request.contextPath}/resource/images/${book.imagePath}" alt="${book.bookName}" style="width: 300px; height: 400px; object-fit: cover; border-radius: 4px; background: #ddd;">
            
            <div class="book-info" style="flex: 1; min-width: 250px;">
                <table style="width: 100%; border-collapse: collapse;">
                    <tbody>
                        <tr>
                            <th style="text-align: left; padding: 8px; font-size: 20px; border-bottom: 2px solid #ddd;" colspan="2">${book.bookName}</th>
                        </tr>
                        <tr>
                            <th style="text-align: left; padding: 8px; width: 100px;">저자</th>
                            <td style="padding: 8px;">${book.author}</td>
                        </tr>
                        <tr>
                            <th style="text-align: left; padding: 8px;">출판사</th>
                            <td style="padding: 8px;">${book.publisher}</td>
                        </tr>
                        <tr>
                            <th style="text-align: left; padding: 8px; vertical-align: top;">설명</th>
                            <td style="padding: 8px; line-height: 1.5;">
                                ${book.description}
                            </td>
                        </tr>
                    </tbody>
                </table>

                <a href="${pageContext.request.contextPath}/member/bookList" class="back-link" style="margin-top: 20px; display: inline-block;">목록으로 돌아가기</a>
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

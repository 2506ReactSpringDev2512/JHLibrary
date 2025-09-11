<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>검색 결과 - 도서관 웹사이트</title>

    <!-- 공통 CSS -->
    <link rel="stylesheet" href="/resource/mainHeader.css">
    <link rel="stylesheet" href="/resource/footer.css">
    <link rel="stylesheet" href="/resource/index.css"> <!-- 도서 카드 스타일 포함 -->
</head>
<body>

    <!-- 공통 헤더 -->
    <jsp:include page="/WEB-INF/views/common/notMainHeader.jsp" />

    <!-- 검색 결과 섹션 -->
    <section class="popular-books">
        <h2 class="section-title">검색 결과</h2>
        <div class="books-grid">
            <c:choose>
                <c:when test="${not empty bookList}">
    				<c:forEach var="book" items="${bookList}">
                        <div class="book-item" onclick="viewBookDetails('${book.bookNo}')">
                            <div class="book-cover" style="overflow: hidden !important;">
                                <c:choose>
                                    <c:when test="${not empty book.imagePath}">
                                        <img src="${pageContext.request.contextPath}/resource/images/${book.imagePath}"
                                             alt="${book.bookName}"
                                             style="max-width: 100%; max-height: 100%; object-fit: cover;"
                                             onerror="this.parentElement.innerHTML='<div class=\'no-image\'>이미지 없음</div>'">
                                    </c:when>
                                    <c:otherwise>
                                        <div class="no-image">이미지 없음</div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="book-title">${book.bookName}</div>
                            <div class="book-author">${book.bookAuthor}</div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p style="text-align: center; margin-top: 50px; font-size: 18px; color: #666;">
                        검색 결과가 없습니다.
                    </p>
                </c:otherwise>
            </c:choose>
        </div>
    </section>

    <!-- 공통 푸터 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        function viewBookDetails(bookId) {
            alert("도서 상세 페이지로 이동합니다. (도서 ID: " + bookId + ")");
            // 실제로는 아래처럼 사용
            // window.location.href = "/book/detail?bookNo=" + bookId;
        }
    </script>

</body>
</html>
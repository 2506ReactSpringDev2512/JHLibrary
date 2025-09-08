<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서관 웹사이트</title>

    <!-- 공통 CSS -->
    <link rel="stylesheet" href="/resource/mainHeader.css">
    <link rel="stylesheet" href="/resource/footer.css">
    <link rel="stylesheet" href="/resource/index.css">
</head>
<body>
    <!-- 공통 헤더 -->
    <jsp:include page="WEB-INF/views/common/mainHeader.jsp"></jsp:include>

    <!-- 메인 검색 섹션 -->
    <section class="main-section">
        <div class="search-container">
            <div class="search-box">
                <input type="text" class="search-input" placeholder="검색어를 입력해주세요" id="searchInput">
                <button class="search-btn" onclick="searchBooks()">
                    <svg viewBox="0 0 24 24">
                        <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"/>
                    </svg>
                </button>
            </div>
        </div>
    </section>

    <!-- 인기도서 섹션 -->
    <section class="popular-books">
        <h2 class="section-title">인기도서</h2>
        <div class="books-grid">
            <c:choose>
                <c:when test="${not empty popularBooks}">
                    <c:forEach var="book" items="${popularBooks}">
                        <div class="book-item" onclick="viewBookDetails('${book.bookNo}')">
                            <div class="book-cover">
                                <c:choose>
                                    <c:when test="${not empty book.imagePath}">
                                        <img src="${pageContext.request.contextPath}${book.imagePath}" 
                                             alt="${book.bookName}" 
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
                    <div class="book-item">
                        <div class="book-cover"><div class="no-image">이미지 없음</div></div>
                        <div class="book-title">예제 도서 1</div>
                        <div class="book-author">홍길동</div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </section>

    <!-- 공통 푸터 -->
    <jsp:include page="WEB-INF/views/common/footer.jsp"></jsp:include>

    <script>
        function searchBooks() {
            const searchTerm = document.getElementById('searchInput').value.trim();
            if (searchTerm) {
                alert('검색어: "' + searchTerm + '"로 검색합니다.');
            } else {
                alert('검색어를 입력해주세요.');
            }
        }

        document.getElementById('searchInput').addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                searchBooks();
            }
        });

        function viewBookDetails(bookId) {
            alert('도서 상세 페이지로 이동합니다. (도서 ID: ' + bookId + ')');
        }
    </script>
</body>
</html>

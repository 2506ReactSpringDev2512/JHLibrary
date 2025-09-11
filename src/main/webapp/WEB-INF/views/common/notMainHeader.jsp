<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
    <div class="header-container">
        <!-- 왼쪽 로고 + 네비게이션 -->
        <div class="header-left">
            <div class="logo-section">
                <a href="${pageContext.request.contextPath}/">
                    <img src="${pageContext.request.contextPath}/resource/images/JHLibraryLogo.png" alt="도서관리사이트 로고" class="logo">
                </a>
            </div>
            <nav class="nav-left">
                <a href="${pageContext.request.contextPath}/member/rentBook">대여/반납</a>
				<a href="${pageContext.request.contextPath}/member/bookList">도서목록</a>

            </nav>
        </div>

        <!-- 검색창 -->
        <div class="search-box header-search">
            <input type="text" class="search-input" placeholder="검색어를 입력해주세요" id="headerSearchInput">
            <button class="search-btn" onclick="searchBooks('headerSearchInput')">
                <svg viewBox="0 0 24 24">
                    <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 
                             16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 
                             5.91 16 9.5 16c1.61 0 3.09-.59 
                             4.23-1.57l.27.28v.79l5 4.99L20.49 
                             19l-4.99-5zm-6 0C7.01 14 5 11.99 
                             5 9.5S7.01 5 9.5 5 14 7.01 
                             14 9.5 11.99 14 9.5 14z"/>
                </svg>
            </button>
        </div>

        <!-- 오른쪽 로그인/회원가입 또는 마이페이지/로그아웃 -->
        <div class="nav-right">
            <c:choose>
                <c:when test="${not empty sessionScope.loginUser}">
                    <!-- "..님"은 정적 텍스트로 표시 -->
                    <span>${sessionScope.loginUser.memberName}님</span>
                    <a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
                    <a href="${pageContext.request.contextPath}/member/update">마이페이지</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/member/login">로그인</a>
                    <a href="${pageContext.request.contextPath}/member/signup">회원가입</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>

<script>
    // 검색 기능
    function searchBooks(inputId) {
        const searchTerm = document.getElementById(inputId).value.trim();
        if (searchTerm) {
            // alert 삭제하고 실제 검색 페이지 이동으로 변경
            window.location.href = '${pageContext.request.contextPath}/main/search?keyword=' + encodeURIComponent(searchTerm);
        } else {
            alert('검색어를 입력해주세요.');
        }
    }

    // 엔터 키로 검색
    document.addEventListener('DOMContentLoaded', function() {
        const input = document.getElementById('headerSearchInput');
        if (input) {
            input.addEventListener('keypress', function(e) {
                if (e.key === 'Enter') {
                    searchBooks('headerSearchInput');
                }
            });
        }
    });
</script>

<style>
    /* 검색창 스타일 */
    .header-search {
        background: white;
        border-radius: 25px;
        padding: 10px 20px;
        width: 280px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        display: flex;
        align-items: center;
    }

    .header-search .search-input {
        flex: 1;
        border: none;
        outline: none;
        font-size: 14px;
        color: #666;
    }

    .header-search .search-btn {
        background: none;
        border: none;
        cursor: pointer;
        padding: 5px;
    }

    .header-search .search-btn svg {
        width: 18px;
        height: 18px;
        fill: #999;
    }

    /* 반응형 */
    @media (max-width: 768px) {
        .header-search {
            width: 100%;
            margin-top: 10px;
        }

        .header-container {
            flex-direction: column;
            align-items: flex-start;
        }
    }
</style>

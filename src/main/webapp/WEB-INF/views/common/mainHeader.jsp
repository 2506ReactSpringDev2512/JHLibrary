<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">

<div class="header">
    <div class="header-container">
        <!-- 왼쪽 로고 + 네비게이션 -->
        <div class="header-left">
            <div class="logo-section">
                <a href="${pageContext.request.contextPath}/index.jsp">
                    <img src="${pageContext.request.contextPath}/images/JHLibraryLogo.png" alt="도서관리사이트 로고" class="logo">
                </a>
            </div>
            <nav class="nav-left">
                <a href="${pageContext.request.contextPath}/member/rentBook">대여/반납</a>
				<a href="${pageContext.request.contextPath}/member/bookList">도서목록</a>

            </nav>
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
</div>

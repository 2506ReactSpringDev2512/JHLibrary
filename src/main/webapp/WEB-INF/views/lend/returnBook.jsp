<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>반납도서 조회</title>
    
    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <!-- 공통 푸터 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
    <!-- 로그인/회원 관련 사이드바 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/loginSidebar.css">

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
        
        table {
            width: 100%;
            border-collapse: collapse;
            text-align: center;
        }
        
        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background: #f9f9f9;
        }
        footer {
        position: fixed;    /* 화면에 고정 */
        bottom: 0;          /* 맨 아래 */
        left: 0;
        width: 100%;        /* 전체 너비 */
        background-color: #333;  /* 기존 footer 색상과 맞춰주세요 */
        color: white;
        text-align: center;
        padding: 20px 0;
        z-index: 1000;      /* 다른 요소 위에 표시 */
    }
    </style>
    
</head>
<body>
    <!-- 공통 헤더 -->
    <jsp:include page="../common/notMainHeader.jsp"></jsp:include>

    <div class="main-layout">
        <!-- 사이드바 -->
        <div class="sidebar">
            <h3>대여/반납</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/member/rentBook">대여도서 조회</a></li>
                <li><a href="${pageContext.request.contextPath}/member/returnBook" class="active">반납도서 조회</a></li>
            </ul>
        </div>

        <!-- 본문 -->
        <div class="content-box">
            <h2>반납도서 조회</h2>
            <table>
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>도서명</th>
                        <th>저자</th>
                        <th>출판사</th>
                        <th>대출일자</th>
                        <th>반납일자</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty returnList}">
                            <c:forEach var="book" items="${returnList}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${book.bookName}</td>
                                    <td>${book.author}</td>
                                    <td>${book.publisher}</td>
                                    <td>${book.lendDate}</td>
                                    <td>${book.returnDate}</td>
                                    <td>반납완료</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="7">반납한 도서가 없습니다.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
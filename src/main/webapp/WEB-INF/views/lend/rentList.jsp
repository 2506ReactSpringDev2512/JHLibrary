<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>대여도서 조회</title>
    
    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainHeader.css">
    <!-- 공통 푸터 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <!-- 로그인/회원 관련 사이드바 CSS -->
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
        .return-btn {
            padding: 6px 12px;
            background: #ff4444;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .return-btn:hover {
            background: #e63636;
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
                <li><a href="${pageContext.request.contextPath}/rentList.jsp" class="active">대여도서 조회</a></li>
                <li><a href="${pageContext.request.contextPath}/returnList.jsp">반납도서 조회</a></li>
            </ul>
        </div>

        <!-- 본문 -->
        <div class="content-box">
            <h2>대여도서 조회</h2>
            <table>
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>도서명</th>
                        <th>저자</th>
                        <th>출판사</th>
                        <th>대출일자</th>
                        <th>반납예정일</th>
                        <th>대출상태</th>
                        <th>반납</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty rentList}">
                            <c:forEach var="book" items="${rentList}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${book.title}</td>
                                    <td>${book.author}</td>
                                    <td>${book.publisher}</td>
                                    <td>${book.rentDate}</td>
                                    <td>${book.returnDueDate}</td>
                                    <td>${book.status}</td>
                                    <td>
                                        <c:if test="${book.status eq '대여중'}">
                                            <form action="${pageContext.request.contextPath}/returnBook.do" method="post" style="margin:0;">
                                                <input type="hidden" name="bookNo" value="${book.bookNo}">
                                                <button type="submit" class="return-btn">반납</button>
                                            </form>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="8">대여 중인 도서가 없습니다.</td>
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

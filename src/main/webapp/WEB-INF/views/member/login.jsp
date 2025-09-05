<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>

    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainHeader.css">

    <!-- 로그인 페이지 전용 CSS -->
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Malgun Gothic', sans-serif;
            background-color: #f5f5f5;
        }

        h2 {
            font-weight: 400;
        }

        /* 로그인 페이지 레이아웃 */
        .main-layout {
            display: grid;
            grid-template-columns: 200px 1fr; /* 사이드바 200px, 나머지 공간 */
            gap: 40px; /* 사이드바와 로그인박스 간 간격 */
            max-width: 1200px;
            margin: 40px auto;
            padding: 0 20px;
        }

        .sidebar { 
            background-color: #f5f5f5; 
            border-radius: 0; 
            box-shadow: none; 
            height: auto; 
        }

        /* 사이드바 회원정보 제목과 메뉴 항목 간격 */
        .sidebar h3 {
            background: #ff4444;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 18px;
            font-weight: normal;
            margin-bottom: 20px; /* 회원정보와 메뉴 간격 넓힘 */
        }

        .sidebar ul {
            list-style: none; /* 점 제거 */
            padding: 0;
            margin: 0;
        }

        .sidebar ul li {
            margin-bottom: 10px;
        }

        .sidebar ul li:last-child {
            margin-bottom: 0;
        }

        .sidebar ul li a {
            display: block;
            text-align: center;
            padding: 16px;
            border-bottom: none; /* 실선 제거 */
            text-decoration: none;
            color: #333;
            background-color: white;
            transition: background-color 0.3s ease, color 0.3s ease;
            font-weight: 500;
        }

        /* 로그인 메뉴 강조 테두리 */
        .sidebar ul li a.active {
            border: 2px solid #ff4444; /* 빨간 테두리 */
            background-color: white;    
            color: #ff4444;             
            box-sizing: border-box;
        }

        .sidebar ul li a.active:hover {
            background-color: white;
            color: #ff4444;
            border: 2px solid #ff4444;
        }

        /* 로그인 박스 */
        .login-box { 
            display: flex; 
            flex-direction: column;
            align-items: center;
            background-color: white; 
            padding: 30px;
            max-width: 350px;
            border-radius: 8px; 
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            justify-self: center; /* grid 칸 안에서 가로 가운데 */
        } 

        .login-box h2 { 
            font-size: 32px; 
            margin-bottom: 20px; 
            color: #333; 
            font-weight: 1000; 
        }

        .login-form { 
            width: 100%; 
            max-width: 400px; 
        } 

        .login-form input { 
            width: 100%; 
            padding: 12px; 
            margin-bottom: 15px; 
            border: 1px solid #ccc; 
            border-radius: 6px; 
            font-size: 16px; 
            outline: none; 
            transition: border-color 0.3s ease;
        }

        .login-form input:focus {
            border-color: #ff4444; 
        }

        .login-form button { 
            width: 100%; 
            padding: 9px; 
            background: #ff4444; 
            border: none; 
            color: white; 
            font-size: 18px; 
            font-weight: bold; 
            border-radius: 6px; 
            cursor: pointer; 
            transition: background-color 0.3s ease; 
        }

        .login-form button:hover { 
            background: #e63636; 
        }

        .login-form .link { 
            text-align: right; 
            margin-top: 20px; 
        }

        .login-form .link a { 
            font-size: 14px; 
            color: #666; 
            text-decoration: none; 
        }

        .login-form .link a:hover { 
            text-decoration: underline; 
            color: #ff4444; 
        }

        @media (max-width: 768px) {
            .main-layout {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .sidebar {
                width: 100%;
                margin-bottom: 30px;
            }

            .login-box {
                width: 100%;
                padding: 30px 20px;
            }
        }
    </style>
</head>
<body>
    <!-- 공통 헤더 -->
    <jsp:include page="../common/notMainHeader.jsp"></jsp:include>

    <!-- 로그인 본문 -->
    <div class="main-layout">
        <div class="sidebar">
            <h3>회원정보</h3>
            <ul>
                <li><a href="/login.jsp" class="active">로그인</a></li>
                <li><a href="/signup.jsp">회원가입</a></li>
                <li><a href="/findPw.jsp">비밀번호 찾기</a></li>
                <li><a href="/changePw.jsp">비밀번호 변경</a></li>
            </ul>
        </div>

        <div class="login-box">
            <h2>로그인</h2>
            <form class="login-form" action="${pageContext.request.contextPath}/login.do" method="post">
                <input type="text" name="userId" placeholder="아이디를 입력해주세요" required>
                <input type="password" name="userPw" placeholder="비밀번호를 입력해주세요" required>
                <button type="submit">로그인</button>
                <div class="link">
                    <a href="${pageContext.request.contextPath}/findPw.jsp">비밀번호 찾기</a>
                </div>
            </form>
        </div>
    </div>

    <!-- 공통 푸터 적용 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
</body>
</html>

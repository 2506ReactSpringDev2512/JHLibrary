<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>

    <!-- 공통 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/login.css"> <!-- 필요시 별도 CSS -->

    <style>
        /* 기본 세팅 */
        * {margin:0; padding:0; box-sizing:border-box;}
        html, body {
            height: 100%;
        }
        body {
            background-color:#f5f5f5;
            display: flex;
            flex-direction: column;
        }
        h2 {font-weight:400;}

        /* 메인 레이아웃 */
        .main-layout {
            flex: 1; /* 본문이 부족하면 자동으로 늘어나 footer를 아래로 밀어냄 */
            display: grid;
            grid-template-columns: 200px 1fr;
            gap: 40px;
            max-width: 1200px;
            margin: 40px auto;
            padding: 0 20px;
        }

        /* 사이드바 */
        .sidebar { background-color:#f5f5f5; border-radius:0; box-shadow:none; height:auto; position: relative; left: -150px; }
        .sidebar h3 { background:#ff4444; color:white; padding:15px; text-align:center; font-size:18px; font-weight:normal; margin-bottom:20px;}
        .sidebar ul { list-style:none; padding:0; margin:0;}
        .sidebar ul li { margin-bottom:10px;}
        .sidebar ul li a { display:block; text-align:center; padding:16px; text-decoration:none; color:#333; background-color:white; transition: background-color 0.3s ease, color 0.3s ease; font-weight:500;}
        .sidebar ul li a.active { border:2px solid #ff4444; background-color:white; color:#ff4444; box-sizing:border-box;}
        .sidebar ul li a.active:hover { background-color:white; color:#ff4444; border:2px solid #ff4444;}

        /* 로그인 박스 */
        .login-box { display:flex; flex-direction:column; align-items:center; background-color:white; padding:30px; max-width:400px; border-radius:8px; box-shadow:0 2px 10px rgba(0,0,0,0.05); justify-self:center; flex: none; align-self: flex-start; }
        .login-box h2 { font-size:32px; margin-bottom:20px; color:#333; font-weight:1000; }
        .login-form { width:100%; max-width:400px;}
        .login-form input { width:100%; padding:12px; margin-bottom:15px; border:1px solid #ccc; border-radius:6px; font-size:16px; outline:none; transition:border-color 0.3s ease;}
        .login-form input:focus { border-color:#ff4444; }
        .login-form button { width:100%; padding:9px; background:#ff4444; border:none; color:white; font-size:18px; font-weight:bold; border-radius:6px; cursor:pointer; transition: background-color 0.3s ease; }
        .login-form button:hover { background:#e63636; }
        .login-form .link { text-align:right; margin-top:20px; }
        .login-form .link a { font-size:14px; color:#666; text-decoration:none; }
        .login-form .link a:hover { text-decoration:underline; color:#ff4444; }

        /* 반응형 */
        @media (max-width:768px){
            .main-layout { display:flex; flex-direction:column; align-items:center; }
            .sidebar { width:100%; margin-bottom:30px; }
            .login-box { width:100%; padding:30px 20px; }
        }

        /* footer 항상 아래에 */
        footer {
            margin-top: auto;
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
                <li><a href="${pageContext.request.contextPath}/member/login" class="active">로그인</a></li>
                <li><a href="${pageContext.request.contextPath}/member/signup">회원가입</a></li>
                <li><a href="${pageContext.request.contextPath}/member/findPw">비밀번호 찾기</a></li>
            </ul>
        </div>

        <div class="login-box">
            <h2>로그인</h2>
            <form class="login-form" action="${pageContext.request.contextPath}/member/login" method="post">
                <input type="text" name="memberId" placeholder="아이디를 입력해주세요" required>
                <input type="password" name="memberPw" placeholder="비밀번호를 입력해주세요" required>
                <button type="submit">로그인</button>
                <div class="link">
                    <a href="${pageContext.request.contextPath}/member/findPw">비밀번호 찾기</a>
                </div>
            </form>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

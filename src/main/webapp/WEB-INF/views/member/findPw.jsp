<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>

    <!-- 공통 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/login.css"> <!-- 로그인 페이지 CSS 그대로 사용 -->

    <style>
        /* login.jsp 전용 스타일 그대로 적용 */
        * {margin:0; padding:0; box-sizing:border-box;}
        body {background-color:#f5f5f5;}
        h2 {font-weight:400;}

        .main-layout {
            display: grid;
            grid-template-columns: 200px 1fr;
            gap: 40px;
            max-width: 1200px;
            margin: 40px auto;
            padding: 0 20px;
        }

        .sidebar { background-color:#f5f5f5; border-radius:0; box-shadow:none; height:auto;}
        .sidebar h3 { background:#ff4444; color:white; padding:15px; text-align:center; font-size:18px; font-weight:normal; margin-bottom:20px;}
        .sidebar ul { list-style:none; padding:0; margin:0;}
        .sidebar ul li { margin-bottom:10px;}
        .sidebar ul li a { display:block; text-align:center; padding:16px; text-decoration:none; color:#333; background-color:white; transition: background-color 0.3s ease, color 0.3s ease; font-weight:500;}
        .sidebar ul li a.active { border:2px solid #ff4444; background-color:white; color:#ff4444; box-sizing:border-box;}
        .sidebar ul li a:hover,
		.sidebar ul li a.active:hover {
		    background-color: #f0f0f0;
		    text-decoration: none;
		}

        .login-box { display:flex; flex-direction:column; align-items:center; background-color:white; padding:30px; max-width:400px; border-radius:8px; box-shadow:0 2px 10px rgba(0,0,0,0.05); justify-self:center;}
        .login-box h2 { font-size:32px; margin-bottom:20px; color:#333; font-weight:1000; }
        .login-form { width:100%; max-width:400px;}
        .login-form input { width:100%; padding:12px; margin-bottom:15px; border:1px solid #ccc; border-radius:6px; font-size:16px; outline:none; transition:border-color 0.3s ease;}
        .login-form input:focus { border-color:#ff4444; }
        .login-form button { width:100%; padding:9px; background:#ff4444; border:none; color:white; font-size:18px; font-weight:bold; border-radius:6px; cursor:pointer; transition: background-color 0.3s ease; }
        .login-form button:hover { background:#e63636; }
        .login-form .link { text-align:right; margin-top:20px; }
        .login-form .link a { font-size:14px; color:#666; text-decoration:none; }
        .login-form .link a:hover { text-decoration:underline; color:#ff4444; }

        @media (max-width:768px){
            .main-layout { display:flex; flex-direction:column; align-items:center; }
            .sidebar { width:100%; margin-bottom:30px; }
            .login-box { width:100%; padding:30px 20px; }
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
        <div class="sidebar">
            <h3>회원정보</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
                <li><a href="${pageContext.request.contextPath}/member/signup">회원가입</a></li>
                <li><a href="${pageContext.request.contextPath}/member/findPw" class="active">비밀번호 찾기</a></li>
            </ul>
        </div>

        <div class="login-box">
            <h2>비밀번호 찾기</h2>
            <form class="login-form" action="${pageContext.request.contextPath}/member/findPw" method="post">
                <input type="text" name="memberId" placeholder="아이디를 입력해주세요" required>
                <input type="text" name="memberName" placeholder="이름을 입력해주세요" required>
                <button type="submit">비밀번호 찾기</button>
            </form>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

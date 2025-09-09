<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>

    <!-- 공통 헤더 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">

    <!-- 회원가입 페이지 전용 CSS -->
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


        .sidebar { background-color:#f5f5f5; border-radius:0; box-shadow:none; height:auto; position: relative; left: -150px; }
        .sidebar h3 {
            background:#ff4444; color:white; padding:15px; text-align:center; font-size:18px; font-weight:normal; margin-bottom:20px;
        }
        .sidebar ul { list-style:none; padding:0; margin:0;}
        .sidebar ul li { margin-bottom:10px;}
        .sidebar ul li:last-child { margin-bottom:0;}
        .sidebar ul li a {
            display:block; text-align:center; padding:16px; border-bottom:none; text-decoration:none;
            color:#333; background-color:white; transition: background-color 0.3s ease, color 0.3s ease; font-weight:500;
        }
        .sidebar ul li a.active { border:2px solid #ff4444; background-color:white; color:#ff4444; box-sizing:border-box;}
        .sidebar ul li a.active:hover { background-color:white; color:#ff4444; border:2px solid #ff4444;}

        .login-box { display:flex; flex-direction:column; align-items:center; background-color:white; padding:30px; max-width:400px; border-radius:8px; box-shadow:0 2px 10px rgba(0,0,0,0.05); justify-self:center; flex: none; align-self: flex-start; }
        .login-box h2 { font-size:32px; margin-bottom:20px; color:#333; font-weight:1000; }

        .login-form { width:100%; max-width:400px;}
        .login-form input {
            width:100%; padding:12px; margin-bottom:15px; border:1px solid #ccc; border-radius:6px; font-size:16px; outline:none;
            transition:border-color 0.3s ease;
        }
        .login-form input:focus { border-color:#ff4444; }
        .login-form button { width:100%; padding:9px; background:#ff4444; border:none; color:white; font-size:18px; font-weight:bold; border-radius:6px; cursor:pointer; transition: background-color 0.3s ease; }
        .login-form button:hover { background:#e63636; }
        .login-form .link { text-align:right; margin-top:20px; }
        .login-form .link a { font-size:14px; color:#666; text-decoration:none; }
        .login-form .link a:hover { text-decoration:underline; color:#ff4444; }

        /* 성별 라디오 버튼 가로 정렬 */
        .gender-radio {
		    display: flex;          /* 가로 정렬 */
		    gap: 30px;              /* 버튼 간격 */
		    justify-content: center; /* 가운데 정렬 */
		    margin-bottom: 15px;
		}
		
		.gender-radio label {
		    display: flex;          /* 라디오 + 글자를 한 행으로 */
		    align-items: center;    /* 수평 맞춤 */
		    gap: 5px;               /* 버튼과 글자 간격 */
		    cursor: pointer;        /* 클릭 영역 표시 */
		}
		
		.gender-radio input[type="radio"] {
		    vertical-align: middle; /* 버튼을 글자 기준 수직 중앙 */
		    margin: 0;              /* 불필요한 기본 마진 제거 */
		}


        @media (max-width:768px){
            .main-layout { display:flex; flex-direction:column; align-items:center; }
            .sidebar { width:100%; margin-bottom:30px; }
            .login-box { width:100%; padding:30px 20px; }
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
                <li><a href="${pageContext.request.contextPath}/member/signup" class="active">회원가입</a></li>
                <li><a href="${pageContext.request.contextPath}/member/findPw">비밀번호 찾기</a></li>
            </ul>
        </div>

        <div class="login-box">
            <h2>회원가입</h2>

            <!-- 에러 메시지 -->
            <c:if test="${not empty errorMsg}">
                <div style="color:red; margin-bottom:10px; text-align:center;">
                    ${errorMsg}
                </div>
            </c:if>

            <form class="login-form" action="${pageContext.request.contextPath}/member/signup" method="post">
                <input type="text" name="memberId" placeholder="아이디를 입력해주세요" 
                       pattern="[A-Za-z0-9]{4,20}" title="영어와 숫자만 4~20자리" required>

                <input type="password" name="memberPw" placeholder="비밀번호를 입력해주세요" required>
                <input type="password" name="memberPwConfirm" placeholder="비밀번호 확인" required>

                <input type="text" name="memberName" placeholder="이름을 입력해주세요" 
                       pattern="[가-힣A-Za-z]+" title="이름에는 특수문자를 사용할 수 없습니다." required>

                <input type="text" name="memberPhone" placeholder="전화번호를 입력해주세요" 
                       pattern="\d{11}" title="전화번호는 숫자 11자리만 입력 가능" maxlength="11" required>

                <input type="number" name="memberAge" placeholder="나이를 입력해주세요" required>

                <div class="gender-radio">
				    <label>
				        <input type="radio" name="memberGender" value="남" required> 남
				    </label>
				    <label>
				        <input type="radio" name="memberGender" value="여" required> 여
				    </label>
				</div>



                <button type="submit">회원가입</button>
            </form>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

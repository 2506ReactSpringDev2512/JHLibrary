<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<style>
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
    <meta charset="UTF-8">
    <title>비밀번호 찾기 결과</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/mainHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/footer.css">
</head>
<body>
    <jsp:include page="../common/notMainHeader.jsp"></jsp:include>

    <div style="max-width:500px; margin:100px auto; padding:20px; text-align:center; background:#fff; border-radius:10px; box-shadow:0 2px 10px rgba(0,0,0,0.1);">
        <h2>비밀번호 찾기 결과</h2>
        <p style="font-size:16px; color:#333;">${message}</p>
        <a href="${pageContext.request.contextPath}/member/login" style="display:inline-block; margin-top:20px; padding:10px 20px; background:#ff4444; color:white; text-decoration:none; border-radius:6px;">로그인</a>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

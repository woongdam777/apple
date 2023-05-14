<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>resultPage</title>
</head>
<body>
    <h1>${name}님의 구매목록</h1>
    <h2>
        검은 펜 ${blackPen}개 : ${blackPen*500} <br><br>
        빨간 펜 ${redPen}개 : ${redPen*500} <br><br>
        파란 펜 ${bluePen}개 : ${bluePen*500} <br><br>
        화이트 ${white}개 : ${white*500} 
    </h2>
    <hr>
    <h2>
        총합 ${total}원을 결제하셨습니다.
    </h2>
</body>
</html>
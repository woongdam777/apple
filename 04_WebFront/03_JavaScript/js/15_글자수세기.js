const content = document.getElementById("content");
const count = document.getElementById("count");

content.addEventListener("input", e => {
    // input 이벤트 : 입력과 관련된 모든 행동
    // input, textarea 등 입력 가능한 요소에 값이 입력되면 인식
    count.innerText = e.target.value.length;
    if(content.value.length > 100)count.classList.add("error");
    // 100글자 초과 -> #count에 error클래스 추가
    else count.classList.remove("error");
    // 100글자 이하 -> #count에 error클래스 제거

    // 요소.classList.toggle('클래스명')
    // - 요소에 클래스가 없으면 추가 (true 반환)
    // - 요소에 클래스가 있으면 제거 (false 반환)


});


// 계산 버튼 클릭 시
// input 태그에 작성된 값을 모두 읽어와 합한 결과를 alert로 출력

document.getElementById("calc").addEventListener("click", () => {
    // 계산 버튼이 클릭되는 시점의 .in input태그들을 모두 읽어옴
    const input = document.getElementsByClassName("in");
    let sum = 0;  //합계 저장용 변수
    // for(let i = 0 ; i<input.length ; i++){
    //     // HTML에 작성된 모든 내용, 속성, 값은 string(문자열)!!!
    //     sum += Number(input[i].value);
    // }

    for(let i of input){
        sum += Number(i.value);
    }

    alert(sum);
});

// --------------------------------------

// 추가 버튼이 클릭 되었을때
// .container 요소의 마지막 자식으로
// <div class = "row">
//      <input type = "number" class="in">
//</div>


document.getElementById("add").addEventListener("click", () => {
    
    // 요소 만들기 : document.createElement("태그명")
    // 요소 제거하기 : 요소.remove();
    
    // 요소의 클래스 목록 확인하기 : 요소.classList
    // 요소에 class 추가 : 요소.classList.add("클래스명");
    // 요소에 class 제거 : 요소.classList.remove("클래스명");

    // 요소에 속성, 값 추가 : 요소.setAttribute("속성명","값");
    // 요소에 속성 제거 : 요소.removeAttribute("속성명");

    // 부모요소.append(자식요소) : 부모 요소의 마지막 자식으로 자식 요소를 추가(덧붙이기)
    // 부모요소.preend(자식요소) : 부모 요소의 첫번째 자식으로 자식 요소를 추가

    // A.after(B) A의 다음요소로 B를 추가

    // A.before(B) A의 시작요소로 B를 추가

    //-----------------------------------------------
    // div요소만들기
    const div = document.createElement("div")
    div.classList.add("row"); // div에 row클래스 추가
    //-----------------------------------------------
    // input요소만들기
    const input = document.createElement("input")
    input.classList.add("in"); // div에 in클래스 추가
    input.setAttribute("type","number"); // input에 type="number" 속성 추가
    //----------------------------------------------------------
    // span 요소 만들기
    const span = document.createElement("span")
    // span에 remove-row 클래스 추가
    span.classList.add("remove-row");
    // span에 &times; 내용 추가(innerHTML 사용)
    span.innerHTML= "&times";
    // 만들어진 span 요소에 이벤트리스너 추가
    span.addEventListener("click", e =>{e.target.parentElement.remove()}) // 클릭된 요소의 부모 요소를 삭제 == row 삭제

    //----------------------------------------------------------
    // div의 자식으로 input추가
    // div.append(input);
    div.prepend(input);
    // div의 마지막 자식으로 span 추가
    div.append(span);
    //----------------------------------------------------------

    document.querySelector(".container").append(div);
})


// 삭제 버튼 동작 테스트

// 클래스가 remove-row인 요소 중 첫번째 요소
document.querySelector(".remove-row").addEventListener("click", e => {

    console.log(e.target); //이벤트가 발생한 요소(클릭된 버튼)
    // 이벤트가 발생한 요소의 부모 요소(.row)
    console.log(e.target.parentElement);
    // 이벤트가 발생한 요소의 부모 요소를 제거(remove)
    e.target.parentElement.remove();
});
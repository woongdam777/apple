// 기본 함수
function clickCount(btn){
  // 클릭할 때마다 1씩 증가
  // 단, 20을 초과하면 다시 0으로 초기화

  // btn = <div id="btn1" onclick="clickCount(this)">0</div>

  btn.innerText = Number(btn.innerText)+1;
  if(btn.innerText>20){
    btn.innerText = 0;
  }
}

// 익명 함수
const t2 = document.getElementById("target2");
const b2 = document.getElementById("btn2");

const colorList = ['red', 'orange', 'yellow', 'green', 'blue'];
let index = -1;

b2.addEventListener("click",function(){
  // t2.style.color = 'red';

  t2.style.color = colorList[++index];

  if(index == 4) index = -1; // 다시 처음부터..

})

// ----------------------------------------------------

// 즉시 실행 함수

// 1) 속도적 우위
function testFn(){
  console.let("일반 함수");
}

testFn(); // 함수 호출

// 즉시 실행 함수는 정의가 끝나면 바로 실행
(function(){
  console.log("즉시 실행 함수");
})();


// 2) 변수명 중복 문제 해결
const str = "전역 변수";

(function(){
  const str = "지역 변수"
  console.log(str); // 지역 변수
})();

console.log(str); // 전역 변수
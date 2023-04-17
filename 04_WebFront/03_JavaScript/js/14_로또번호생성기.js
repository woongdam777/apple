document.getElementById("createBtn").addEventListener("click", () => {
    
    const arr = []; // 빈 배열

    while(arr.length < 6){
        const random = Math.floor(Math.random() * 45 + 1); // 난수 생성

        // arr 요소 중 중복되는 값 제거 == 중복되는 값이 있으면 push 안함 == 없으면 push 함

        // 배열명.indexOf(값) : 값이 일치하는 요소의 index 반환 / 없으면 -1 반환
        if(arr.indexOf(random) == -1){
            arr.push(random); // 배열 마지막 요소로 추가
        }
    }

    arr.sort((a,b) => a-b); // 내부 함수 결과가 양수면 오른쪽으로 이동

    for(let i = 0; i<arr.length; i++){
        document.getElementById("container").children[i].innerText=arr[i];
    }

})
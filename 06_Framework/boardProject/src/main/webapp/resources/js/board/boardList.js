const insertBtn = document.querySelector("#insertBtn");

// 글쓰기 버튼 클릭 시
insertBtn.addEventListener("click", () => {
    // JS BOM(brows of model) 객체 중 location
    
    // location.href = '주소';
    // 해당 주소 요청(get방식)

    location.href = `/board2/${location.pathname.split("/")[2]}/insert`;
                    //  /board2/1/insert

});
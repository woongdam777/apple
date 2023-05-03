/* 청원 주요내용 팁보기 */
document.getElementById("titleTipBtn").addEventListener("click", () => {
    document.getElementById("titleTip").style.display = "block";
});
document.getElementById("descriptTipBtn").addEventListener("click", () => {
    document.getElementById("descriptTip").style.display = "block";
});
document.getElementById("imgTipBtn").addEventListener("click", () => {
    document.getElementById("imgTip").style.display = "block";
});

/* 청원 데이터 팁보기 */
function tipHover(input){
    const inputI = document.getElementById(`${input}I`);
    const inputP = document.getElementById(`${input}P`);

    inputI.addEventListener("mouseover", () =>{
        inputP.style.display = "block";
    });
    
    inputI.addEventListener("mouseout", () =>{
        inputP.style.display = "none";
    });

}

tipHover("scope");
tipHover("location");
tipHover("topic");
tipHover("owner");
tipHover("twitter");









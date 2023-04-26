/* 팁 열기 */
document.getElementById("titleTipBtn").addEventListener("click", () => {
    document.getElementById("titleTip").style="display: block";
    document.getElementsByTagNae("body").style="background-color:rgba(0,0,0,0.4)"
    document.getElementsByClassName("tip-bg").style="display: block";
});
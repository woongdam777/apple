// 로고 클릭시 메인페이지
document.getElementById("logoimg").addEventListener("click", () => {
  window.location.href = '/vote/mainFrame.html';
});

// 로그인 클릭시 아이콘 변경 및 로그인화면 전환
document.getElementById("login").addEventListener("click",() => {
  document.getElementById("login").innerHTML = '<a href="#"><i class="fa-sharp fa-solid fa-user"></i></a>';
  document.getElementById("bell").style = "display : inline"
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="/vote/login/login.html"></iframe>';
});

// 프레임 불러오기
document.getElementById("startPetitions").addEventListener("click",function () {
    document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="startPetitions/start_a_petition.html"></iframe>';
});

document.getElementById("myPetitions").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="/vote/myPetitions/myPetitions/login_mypettitions.html"></iframe>';
});

document.getElementById("browse").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="browse/browser.html"></iframe>';
});

document.getElementById("help").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="clientCenter/clientCenter.html"></iframe>';
});

// 프레임 크기 변동
function iframeLoaded() {
  let frame = document.getElementById('iframe');
  let mheight = document.getElementById('mf');
  let height = frame.contentWindow.document.body.scrollHeight;
  let width = frame.contentWindow.document.body.scrollWidth;

  mheight.height = height + "px";
  mheight.width = width + "px";

  frame.height = height + 100 + "px";
  frame.width = width + 100 + "px"
}
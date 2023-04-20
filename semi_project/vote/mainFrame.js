document.getElementById("startPetitions").addEventListener("click",function () {
    document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="startPetitions/start_a_petition.html"></iframe>';
});

document.getElementById("myPetitions").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="myPetitions/myPetitionsDashboard.html"></iframe>';
});

document.getElementById("browse").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="browse/browser.html"></iframe>';
});

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
document.getElementById("startPetitions").addEventListener("click",function () {
    document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="startPetitions/startPetitions.html"></iframe>';
});

document.getElementById("myPetitions").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="myPetitions/myPetitions.html"></iframe>';
});

document.getElementById("browse").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="browse/browser.html"></iframe>';
});

function iframeLoaded() {
  let frame = document.getElementById('iframe');
  let mheight = document.getElementById('mf');
  let height = document.getElementById('iframe').contentWindow.document.body.scrollHeight;
  let width = document.getElementById('iframe').contentWindow.document.body.scrollWidth;

  mheight.height = height + "px";
  mheight.width = width + "px";

  frame.height = height + "px";
  frame.width = width + "px"
}
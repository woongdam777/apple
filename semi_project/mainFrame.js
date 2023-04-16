document.getElementById("startPetitions").addEventListener("click",function () {
    document.getElementById("mf").innerHTML = '<iframe class="myPetitions" src="startPetitions/startPetitions.html"></iframe>';
});

document.getElementById("myPetitions").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe class="myPetitions" src="myPetitions/myPetitions.html"></iframe>';
});

document.getElementById("browse").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe class="myPetitions" src="browse/browser.html"></iframe>';
});
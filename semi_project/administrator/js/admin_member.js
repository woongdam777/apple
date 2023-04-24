const signupId = document.getElementById('signup-id');
const signupPw = document.getElementById('signup-pw');
const signupPww = document.getElementById('signup-pww');
const idBtn = document.getElementById('id-btn');
const voteLogo = document.getElementById('voteLogo');
const menuMember = document.getElementById('menu-member');

voteLogo.addEventListener('click', () => {
  window.location.href = '../html/main_login.html';
});

menuMember.addEventListener('click', function () {
  // '../html/adming_member.html'로 페이지 이동
  window.location.href = '../html/admin_member.html';
});

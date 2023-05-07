<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="/resources/css/common/mainFrame.css">
    <%-- 나눔고딕 --%>
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-gothic.css" rel="stylesheet">
    <!-- font awesome 라이브러리 추가 + key 등록 -->
    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
<header>
  <section class="logo-menu-icon">
    <div class="header-logo"><a href="/"><img id="logoimg" src="/resources/images/common/Logo.png" /></a></div>
    <div class="header-menu">
      <ul>
        <li><a id="startPetitions" href="#">Start a petition</a></li>
        <li><a id="myPetitions" href="/myPetitions/myPetitions">My petitions</a></li>
        <li><a id="browse" href="#">Browse</a></li>
      </ul>
    </div>
    <div class="header-icon">
      <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
      <i class="fa-sharp fa-solid fa-user"></i>
      <i class="fa-sharp fa-solid fa-bell"></i>
    </div>
  </section>
</header>


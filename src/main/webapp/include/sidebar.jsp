<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
/* 노멀라이즈 시작 */
body, ul, li {
  margin: 0;
  padding: 0;
  list-style: none;   /* 해당 태그의 list-style을 none으로 하는 것으로 ●을 제거한다 */
}

a {
  color: inherit;   /* 부모 엘리먼트의 값을 물려받는다 */
  text-decoration: none;    /* 해당 태그의 text-decoration 속성을 none 값으로 하는 것으로 밑줄을 제거한다 */
}
/* 노멀라이즈 끝 */

/* 커스텀 시작 */
.side-bar > ul ul {
  display: none;
}

/* 사이트의 높이를 5000px로 만들어 스크롤 생성 */
body {
  height: 5000px;
  background-color: #FFFFFF;
  position: sticky;
}

/* 사이드바 시작 */

/* 사이드바의 너비와 높이를 변수를 통해 통제 */
:root {
  --side-bar-width: 220px;
  --side-bar-height: 60vh;
}

.side-bar {
  position: fixed;    /* 스크롤을 따라오도록 지정 */
  background-color: black;
  width: var(--side-bar-width);
  min-height: 70%;   /* 사이드바의 높이를 전체 화면 높이의 90%로 지정 */
  margin-top: 13%;    /* 사이드바 위와 아래의 마진을 동일하게 지정 */
  z-index:2;
}

/* 아이콘 시작 */
.side-bar__icon-box {
  display: flex;
  justify-content: flex-end;
}

.side-bar__icon-1 {
  position: relative;
  width: 23px;
  height: 17px;
  margin: 15px;
  margin-top: 20px;
  transition: .5s;
}

:root {
  --side-bar__icon: .5s;
}

.side-bar__icon-1 > div {
  position: absolute;
  width: 100%;
  height: 20%;
  background-color: white;
  transition: all var(--side-bar__icon);
}

.side-bar__icon-1 > div:nth-of-type(1) {
  top: 0;
  width: auto;
  left: 0;
  right: 0;
  transition: all var(--side-bar__icon), left calc(var(--side-bar__icon) / 2) calc(var(--side-bar__icon) / 2), right calc(var(--side-bar__icon) / 2) calc(var(--side-bar__icon) / 2), height calc(var(--side-bar__icon) / 2) 0s;
}

.side-bar__icon-1 > div:nth-of-type(2) {
  top: 40%;
  transform-origin:bottom left;
}

.side-bar__icon-1 > div:nth-of-type(3) {
  top: 80%;
  left: auto;
  right: 0;
  transform-origin:bottom right;
}


.side-bar:hover .side-bar__icon-1 {
  transform: translate(-198px, 0);
}

.side-bar:hover .side-bar__icon-1 > div:nth-of-type(2) {
  transform:rotate(45deg);
  width: 70.5%;
  height: 25%;
}

.side-bar:hover .side-bar__icon-1 > div:nth-of-type(3) {
  top: 40%;
  transform:rotate(-45deg);
  width: 70.5%;
  height: 25%;
}

.side-bar:hover .side-bar__icon-1 > div:nth-of-type(1) {
  left: 41%;
  right: 41%;
  height: 50%;
  transition: all var(--side-bar__icon), left calc(var(--side-bar__icon) / 2) 0s, right calc(var(--side-bar__icon) / 2) 0s, height calc(var(--side-bar__icon) / 2) calc(var(--side-bar__icon) / 2);
}
/* 아이콘 끝 */

/* 모든 메뉴의 a에 속성값 부여 */
.side-bar ul > li > a {
  display: block;
  color: white;
  font-size: 1rem;
  font-weight: bold;
  padding-top:25px;
  padding-bottom: 28px;
  padding-left: 30px;
  transition: .5s;
}

.side-bar ul > li{
  display: block;
  color: white;
  font-size: 0.8rem;
}

/* 자식의 position이 absolute일 때 자식을 영역 안에 가두어 준다 */
.side-bar > ul > li {
  position: relative;
}

/* 모든 메뉴가 마우스 인식 시 반응 */
.side-bar ul > li:hover > a {
  background-color: #555;
  border-bottom: 1px solid #999;
}

/* 1차 메뉴의 항목이 마우스 인식 시에 2차 메뉴 등장 */
.side-bar > ul > li:hover > ul {
  display: block;
  position: absolute;
  background-color: #888;
  top: 0%;         /* 2차 메뉴의 상단을 1차 메뉴의 상단에 고정 */
  left: 100%;     /* 2차 메뉴를 1차 메뉴의 너비만큼 이동 */
  width: 70%;    /* 1차 메뉴의 너비를 상속 */
  padding:0px;
  margin:0;
}

/* 사이드바 너비의 80%만큼 왼쪽으로 이동 */
.side-bar {
  border-radius: 20px;
  transform: translate(calc(var(--side-bar-width) * -0.7), 0);
  transition: .5s;
}

/* 마우스 인식 시 원래의 위치로 이동 */
.side-bar:hover {
  transform: translate(-20px, 0);   /* 둥근 모서리의 너비만큼 숨겨주기 */
}
.side-bar > ul ul {
  display: none;
  max-height: 230px; /* 원하는 높이로 조정하세요 */
  overflow-y: auto; /* 내용이 넘칠 경우 스크롤 표시 */
}


/* 사이드바 끝 */
</style>
</head>
<body>
<aside class="side-bar">
  <section class="side-bar__icon-box">
    <section class="side-bar__icon-1">
      <div></div>
      <div></div>
      <div></div>
    </section>
  </section>
  <ul>
    <li>
      <a href="#">회원</a>
      <ul>
        <li><a href="manager.do">회원관리</a></li>
      </ul>
    </li>
    <li>
      <a href="#">상품</a>
      <ul>
        <li><a href="productmanager.do">상품관리</a></li>
        <li><a href="productinsert.do">상품등록</a></li>
        <li><a href="productupdate.do">상품수정</a></li>
      </ul>
    </li>
    <li>
      <a href="#">게시판</a>
      <ul>
        <li><a href="noticemanager.do">게시판 관리</a></li>
        <li><a href="noticeinsert.do">게시판 작성</a></li>
        <li><a href="noticeupdate.do">게시판 수정</a></li>
      </ul>
    </li>
    <li>
      <a href="totalmanager.do">매출</a>
    </li>
   <li><br> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Counseling Center</span><br>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;02 436 1009</span><br>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;13:00 - 17:00</span><br>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sat.sun.holiday off</span><br>
    </li>
    
    
  

</aside>
</body>
</html>
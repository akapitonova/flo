<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "<c:url value="/resource/static/logo/logo.png"/>
}</script>
<link rel="stylesheet" href="<c:url value="/resource/css/main.css"/>" media="screen">
    <script class="u-script" type="text/javascript" src="<c:url value="/resource/js/jquery.js"/>" defer=""></script>
    <script class="u-script" type="text/javascript" src="<c:url value="/resource/js/main.js"/>" defer=""></script>
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">

<%
String userName=(String)session.getAttribute("userName");
%>

<body>
  <header class="u-clearfix u-header u-header" id="sec-4f41"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="<c:url value="/" />" class="u-image u-logo u-image-1" data-image-width="358" data-image-height="272">
          <img src="<c:url value="/resource/static/logo/logo.png"/>" class="u-logo-image u-logo-image-1">
        </a>
        <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
          <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px;">
            <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
              <svg class="u-svg-link" viewBox="0 0 24 24"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
              <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</g></svg>
            </a>
          </div>
          <div class="u-nav-container">
            <ul class="u-nav u-unstyled u-nav-1">
            <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/" />" style="padding: 10px 20px;">Home</a></li>
            <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/catalog" />" style="padding: 10px 20px;">Catalog</a></li>
            <%if (userName != null) { %>
                <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/userinfo" />" style="padding: 10px 20px;">Welcome <%= userName%></a></li>
                <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/cart" />" style="padding: 10px 20px;">Cart</a></li>
                <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/logout" />" style="padding: 10px 20px;">Logout</a></li>
            <%}else { %>
                <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/login" />" style="padding: 10px 20px;">Cart</a></li>
                <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/register" />" style="padding: 10px 20px;">SignUp</a></li>
                <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="<c:url value="/login" />" style="padding: 10px 20px;">Login</a></li>
            <%} %>
            </ul>
          </div>
          <div class="u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-inner-container-layout u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
                <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/" />">Home</a></li>
                <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/catalog" />">Catalog</a></li>
                <%if (userName != null) { %>
                    <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/userinfo" />">Welcome <%= userName%></a></li>
                    <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/cart" />">Cart</a></li>
                    <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/logout" />">Logout</a></li>
                <%}else { %>
                    <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/login" />">Cart</a></li>
                    <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/register" />">SignUp</a></li>
                    <li class="u-nav-item"><a class="u-button-style u-nav-link" href="<c:url value="/login" />">Login</a></li>
                <%} %>
                </ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
      </div></header>
</body>
</html>
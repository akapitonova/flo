<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-size: 16px;" lang="ru"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="flower&nbsp;Shop">
    <meta name="description" content="">
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/resource/css/main.css"/>" media="screen">
    <link rel="stylesheet" href="<c:url value="/resource/css/general.css"/>" media="screen">
    <script class="u-script" type="text/javascript" src="<c:url value="/resource/js/jquery.js"/>" defer=""></script>
    <script class="u-script" type="text/javascript" src="<c:url value="/resource/js/main.js"/>" defer=""></script>
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">

    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Home">
    <meta property="og:type" content="website">
  <meta data-intl-tel-input-cdn-path="intlTelInput/"></head>
  <body data-home-page-title="Home" data-path-to-root="./" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">

    <%@ include file="header.jsp"%>

    <section class="u-align-center u-clearfix u-image u-section-1" id="carousel_c652" data-image-width="2000" data-image-height="1333">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h2 class="u-align-center u-custom-font u-font-playfair-display u-text u-text-default u-text-1">flower&nbsp;<b>Shop</b>
        </h2>
        <a href="<c:url value="/catalog" />" class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-border-2 u-border-black u-link u-no-underline u-text-body-color u-link-1">view all</a>
      </div>
    </section>

    <%@ include file="footer.jsp"%>

</body>
</html>
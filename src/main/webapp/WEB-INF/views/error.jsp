<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resource/css/error.css"/>" media="screen">
<title>Something went wrong</title>
</head>
<body data-home-page-title="Something went wrong" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">

<%@ include file="header.jsp"%>

<section class="u-clearfix u-section-1" id="sec-8471">
      <div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-text u-text-default u-text-not-found-message u-text-1">something went wrong</p>
        <p class="u-text u-text-2">Try starting over</p>
        <a href="<c:url value="/"/>" class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1"
        style="margin: auto; display: block; width: min-content;">Go to homepage</a>
      </div>
    </section>

<%@ include file="footer.jsp"%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add money for <c:out value = "${user.userId}"/></title>
<link rel="stylesheet" href="<c:url value="/resource/css/add-money.css"/>" media="screen">
<link rel="stylesheet" href="<c:url value="/resource/css/main.css"/>" media="screen">
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
</head>

<body class="u-body u-xl-mode">
    <section class="u-align-center u-clearfix u-section-2" id="sec-b645">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
      <div class="u-form-horizontal">
        <a href="<c:url value="/logout" />" class="u-border-none u-btn u-btn-round u-button-style u-grey-50 u-radius-6 u-btn-1">Logout</a>
        <a href="<c:url value="/admin" />" class="u-border-none u-btn u-btn-round u-button-style u-grey-50 u-radius-6 u-btn-1">Back to admin page</a>
       </div>
        <h4 class="u-text u-text-default u-text-1">Add money for user <c:out value = "${user.userId}"/></h4>
        <div class="u-form u-form-1">
        <form name="addMoney" action="<c:url value="/addmoney_process"/>" method="post" class="u-clearfix u-form-horizontal u-form-spacing-15 u-inner-form">
            <fieldset class="u-clearfix u-form-horizontal u-form-spacing-15 u-inner-form" style="padding: 15px;" >
            <div class="u-form-group u-form-name u-label-none">
              <input type="text" value="${user.userName}" readonly name="j_username" class="u-input u-input-rectangle" required="">
            </div>
            <div class="u-form-email u-form-group u-label-none">
              <input type="number" placeholder="Enter sum" name="j_summ" class="u-input u-input-rectangle" required="">
            </div>
            <div class="u-form-group u-form-submit" id="button">
              <button type="submit" class="u-btn u-btn-round u-btn-submit u-button-style u-grey-70 u-radius-6">Add money</button>
            </div>
            <c:if test="${not empty error}">
                <div class="u-form-send-error u-form-send-message">${error}</div>
            </c:if>
          </fieldset>
          </form>
        </div>
      </div>
    </section>
</body>
</html>
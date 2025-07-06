<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<c:url value="/resource/css/login.css"/>" media="screen">
<title>Login</title>
</head>
<body  data-home-page-title="Login" data-path-to-root="./" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">
	<%@ include file="header.jsp"%>

	<section class="u-clearfix u-section-1" id="sec-5071">
          <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
            <div class="u-align-center u-container-style u-expanded-width-xs u-group u-shape-rectangle u-group-1">
              <div class="u-container-layout u-container-layout-1">
                <h3 class="u-custom-font u-text u-text-default u-text-font u-text-1">Welcome Back</h3>
                <div class="u-expanded-width u-form u-login-control u-white u-form-1">
                <c:if test="${not empty registrationSuccess}">
                	<div style="color: #ff0000;">${registrationSuccess}</div>
                </c:if>

                <c:if test="${not empty logout}">
                	<div style="color: #ff0000;">${logout}</div>
                </c:if>

                  <form action="<c:url value="/login_process"/>" class="u-clearfix u-form-custom-backend u-form-spacing-20 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 30px;" method="post">
                    <div class="u-form-group u-form-name">
                      <label for="username-a30d" class="u-label">Username *</label>
                      <input type="text" placeholder="Enter your Username" id="username-a30d" name="j_username" class="u-grey-5 u-input u-input-rectangle u-input-1" required="">
                    </div>
                    <div class="u-form-group u-form-password">
                      <label for="password-a30d" class="u-label">Password *</label>
                      <input type="password" placeholder="Enter your Password" id="password-a30d" name="j_password" class="u-grey-5 u-input u-input-rectangle u-input-2" required="">
                    </div>
                    <div>
                    	<c:if test="${not empty error}">
                    		<div class="error" style="color: #ff0000">${error}</div>
                    	</c:if>
                    </div>
                    <div class="u-align-right u-form-group u-form-submit">
                      <a href="#" class="u-border-none u-btn u-btn-submit u-button-style u-grey-60 u-btn-1">Login</a>
                      <input type="submit" value="submit" class="u-form-control-hidden">
                    </div>
                    <input type="hidden" value="" name="recaptchaResponse">
                  </form>
                </div>
                <a href="<c:url value="/register"/>" class="u-border-active-palette-2-base u-border-hover-palette-1-base u-border-none u-btn u-button-style u-login-control u-login-create-account u-none u-text-grey-40 u-text-hover-custom-color-2 u-btn-2">Don't have an account?</a>
              </div>
            </div>
          </div>
        </section>

	<%@ include file="footer.jsp"%>

</body>
</html>
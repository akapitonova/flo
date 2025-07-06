<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="<c:url value="/resource/js/reg.js"/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resource/css/register.css"/>" media="screen">
<title>Registration form</title>
</head>
<body data-home-page="Register" data-home-page-title="Регистрация" data-path-to-root="./" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">
	<%@ include file="header.jsp"%>

	<section class="u-clearfix u-section-1" id="sec-fbaf">
          <div class="u-clearfix u-sheet u-sheet-1">
            <div class="u-checkout u-expanded-width u-layout-grid u-checkout-1">
              <div class="u-checkout-blocks-container">
                <div class="u-checkout-billing-details-block u-checkout-block u-indent-30">
                  <div class="u-checkout-block-container u-clearfix">
                    <h5 class="u-checkout-block-header u-text">Register Here!</h5>
                    <div class="u-checkout-block-content u-text">
                      <div class="u-checkout-form u-form">
                        <c:url value="/registration" var="url"></c:url>
                        <form:form method="post" action="${url}" modelAttribute="user" class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" source="custom" name="form">
                          <div class="u-form-group u-form-name u-label-top">
                            <label for="name-f7b1" class="u-label">User Name</label>
                            <form:input type="text" placeholder="Enter Username.." path="userName" id="username" name="username" cssClass="u-input u-input-rectangle" required=""/>
                          </div>
                          <div class="u-form-group u-form-name u-label-top">
                            <label for="name-f7b1" class="u-label">First Name</label>
                            <form:input type="text" placeholder="Enter First Name.." path="firstName" id="firstName" name="name" cssClass="u-input u-input-rectangle" required=""/>
                            <form:errors path="firstName" id="firstName"></form:errors>
                          </div>
                          <div class="u-form-group u-form-group-2 u-form-name u-label-top">
                            <label for="name-592d" class="u-label">Last Name</label>
                            <form:input type="text" placeholder="Enter Last Name.." path="lastName" id="lastName" name="name-1" cssClass="u-input u-input-rectangle" required=""/>
                          </div>
                          <div class="u-form-group u-form-group-5 u-form-phone u-label-top">
                            <label for="phone-089b" class="u-label">Phone</label>
                            <form:input type="tel" pattern="\+?\d{0,3}[\s\(\-]?([0-9]{2,3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})" placeholder="Enter Phone Number.." path="customerPhone" id="phone" name="phone" cssClass="u-input u-input-rectangle" required=""/>
                          </div>
                          <div class="u-form-group u-form-message u-label-top">
                            <label for="message-f7b1" class="u-label">Address</label>
                            <form:textarea placeholder="Enter Shipping Address.." rows="4" cols="50" path="shippingAddress" id="address" name="address" cssClass="u-input u-input-rectangle" required="required"></form:textarea>
                          </div>
                          <div class="u-form-group u-form-group-4 u-label-top">
                            <label for="text-c1e1" class="u-label">Password</label>
                            <form:input type="password" placeholder="********" path="password" id="pass" name="pass" cssClass="u-input u-input-rectangle"></form:input>
                          </div>
                          <div class="u-form-group u-label-top">
                            <label for="text-f7b1" class="u-label">Confirm Password</label>
                            <input type="password" placeholder="********" id="confirmpass" name="confirmpass" class="u-input u-input-rectangle" required=""/>
                          </div>
                          <div class="u-align-right u-form-group u-form-submit u-form-group-9">
                            <button type="submit" id="check" class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1">Submit</button>
                          </div>
                        </form:form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

<%@ include file="footer.jsp"%>

</body>
</html>
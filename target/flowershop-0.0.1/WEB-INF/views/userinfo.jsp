<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="/resource/js/userinfo.js" type="text/javascript"></script>
<link rel="stylesheet" href="userinfo.css" media="screen">
<title>User Info <c:out value = "${user.userName}"/> </title>
</head>
<body data-home-page-title="User Info" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">

<%@ include file="header.jsp"%>

<section class="u-clearfix u-section-1" id="sec-8bb9">
      <div class="u-clearfix u-sheet u-valign-top u-sheet-1">
        <div class="u-checkout u-expanded-width u-layout-grid u-checkout-1">
          <div class="u-checkout-blocks-container">
            <div class="u-checkout-billing-details-block u-checkout-block u-indent-30">
              <div class="u-checkout-block-container u-clearfix">
                <h5 class="u-checkout-block-header u-text">User Details <c:out value = "${user.userName}"/></h5>
                <div class="custom-expanded u-table u-table-responsive u-table-1">
                          <table class="u-table-entity u-table-entity-1">
                            <tbody class="u-table-body">
                              <tr style="height: 31px;">
                                <td class="u-table-cell"> On your balance:</td>
                                <td class="u-table-cell"> $<c:out value = "${user.balance}"/></td>
                              </tr>
                              <c:if test="${not empty user.discount}">
                              <tr style="height: 41px;">
                                <td class="u-table-cell"> You have a discount</td>
                                <td class="u-table-cell"> <c:out value = "${user.discount}"/>%</td>
                              </tr>
                              </c:if>
                            </tbody>
                          </table>
                        </div>
                <div class="u-checkout-block-content u-text">
                  <div class="u-checkout-form u-form">
                    <form:form action="/change_user_info" method="post" cssClass="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" modelAttribute="user">
                      <div class="u-form-group u-form-name u-label-top">
                        <label for="name-f7b1" class="u-label">First Name</label>
                        <form:input type="text" value="${user.firstName}" path="firstName" id="firstName" placeholder="First Name" cssClass="u-input u-input-rectangle"/>
                      </div>
                      <div class="u-form-group u-form-group-2 u-form-name u-label-top">
                        <label for="name-592d" class="u-label">Last Name</label>
                        <form:input type="text" value="${user.lastName}" path="lastName" id="lastName" placeholder="Last Name" cssClass="u-input u-input-rectangle"></form:input>
                      </div>
                      <div class="u-form-group u-form-group-4 u-label-top">
                        <label for="text-c1e1" class="u-label">Address</label>
                        <form:textarea type="text" value="${user.shippingAddress}" path="shippingAddress" id="address" placeholder="Address" class="u-input u-input-rectangle"></form:textarea>
                      </div>
                      <div class="u-form-group u-form-group-5 u-form-phone u-label-top">
                        <label for="phone-089b" class="u-label">Phone</label>
                        <form:input type="tel" value="${user.customerPhone}" path="customerPhone" id="phone" pattern="\+?\d{0,3}[\s\(\-]?([0-9]{2,3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})" placeholder="Phone" class="u-input u-input-rectangle" required=""></form:input>
                      </div>
                      <div class="u-align-right u-form-group u-form-submit u-form-group-9">
                        <button type="submit" onclick="check" class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1">Change info</button>
                      </div>
                    </form:form>
                  </div>
                </div>
              </div>
            </div>
            <div class="u-checkout-block u-checkout-totals-block u-indent-30">

            <c:if test="${not empty orders}">
              <div class="u-checkout-block-container u-clearfix">
                <h5 class="u-checkout-block-header u-text">Info about orders</h5>
                <div class="u-align-right u-checkout-block-content u-text">
                  <div class="u-checkout-totals-table u-table u-table-responsive">
                    <table class="u-table-entity u-table-entity-1">
                      <colgroup>
                        <col width="33.4%">
                        <col width="33.3%">
                        <col width="33.3%">
                      </colgroup>
                      <tbody class="u-align-right u-table-body">
                      <c:forEach var="order" items="${orders}">
                        <tr style="height: 42px;">
                          <td class="u-align-left u-border-1 u-border-grey-dark-1 u-border-no-left u-border-no-right u-first-column u-table-cell u-table-cell-1">${order.customerOrderId}</td>
                          <td class="u-border-1 u-border-grey-dark-1 u-border-no-left u-border-no-right u-table-cell">$${order.total}</td>
                          <td class="u-border-1 u-border-grey-dark-1 u-border-no-left u-border-no-right u-table-cell">
                            <a href="<c:url value="/order/${order.customerOrderId}"/>">Show details</a>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              </c:if>

            </div>
          </div>
        </div>
      </div>
    </section>

	<%@ include file="footer.jsp"%>

</body>
</html>
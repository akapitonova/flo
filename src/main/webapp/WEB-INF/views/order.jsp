<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="/resource/js/order.js" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resource/css/order.css"/>" media="screen">
<title>Order <c:out value = "${order.customerOrderId}"/> </title>
</head>

<%@ include file="header.jsp"%>

<body data-home-page-title="Order" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">

	<section class="u-clearfix u-section-1" id="sec-58eb">
          <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
            <div class="u-checkout u-expanded-width u-layout-grid u-checkout-1">
              <div class="u-checkout-blocks-container">
                <div class="u-checkout-billing-details-block u-checkout-block u-indent-30">
                  <div class="u-checkout-block-container u-clearfix">
                    <h5 class="u-checkout-block-header u-text">Order <c:out value = "${order.customerOrderId}"/></h5>

                    <c:if test="${not empty notHaveFounds}">
                      <div style="color: #ff0000;">${notHaveFounds}</div>
                    </c:if>

                    <h6 class="u-checkout-block-header u-text">Info about shipping</h5>
                    <div class="u-checkout-block-content u-text">
                      <div class="u-checkout-form u-form">
                        <div class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form">
                          <div class="u-form-group u-form-name u-label-top">
                            <label for="name-f7b1" class="u-label">Recipient</label>
                            <input type="text" readonly placeholder="<c:out value = "${user.firstName} ${user.lastName}"/>" class="u-border-none u-input u-input-rectangle" required="">
                          </div>
                          <div class="u-form-group u-form-group-2 u-form-name u-label-top">
                            <label for="name-592d" class="u-label">Phone</label>
                            <input type="text" readonly placeholder="<c:out value = "${user.customerPhone}"/>" class="u-border-none u-input u-input-rectangle" required="">
                          </div>
                          <div class="u-form-group u-form-group-5 u-form-phone u-label-top">
                            <label for="address-089b" class="u-label">Shipping address</label>
                            <input type="text" readonly placeholder="<c:out value = "${user.shippingAddress}"/>" class="u-border-none u-input u-input-rectangle" required="">
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

            <section class="u-clearfix u-section-3" id="sec-83a7">
              <div class="u-clearfix u-sheet u-sheet-1">
              <h6 class="u-checkout-block-header u-text">Info about purchase</h5>
                <div class="u-cart u-layout-grid u-cart-1">
                  <div class="u-cart-products-table u-table u-table-responsive u-table-1">
                    <table class="u-table-entity">
                      <colgroup>
                        <col width="65%">
                        <col width="15%">
                        <col width="15%">
                      </colgroup>
                      <thead class="u-table-header">
                        <tr>
                          <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Product </th>
                          <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Price </th>
                          <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Quantity </th>
                        </tr>
                      </thead>
                      <tbody class="u-table-body">
                      <c:forEach var="item" items="${order.orderItems}">
                        <tr style="height: 29px;">
                          <td class="u-table-cell">
                            <h2 class="u-cart-product-title u-product-control u-text u-text-1">
                              <div class="u-product-title-link" style="font-size: 1rem;">${item.productName}</div>
                            </h2>
                          </td>
                          <td class="u-table-cell">
                            <div class="u-cart-product-price u-product-control u-product-price">
                              <div class="u-price-wrapper">
                                <div class="u-hide-price u-old-price"></div>
                                <div class="u-price">$${item.price}</div>
                              </div>
                            </div>
                          </td>
                          <td class="u-table-cell">
                            <div class="u-cart-product-quantity u-product-control u-product-quantity u-product-quantity-1">
                               <div class="u-hidden u-quantity-label"> Quantity </div>
                               <div class="u-border-1 u-border-grey-25 u-quantity-input">
                                 <div class="u-input">${item.quantity}</div>
                              </div>
                            </div>
                          </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>

                  <div class="u-cart-blocks-container">
                    <div class="u-cart-block u-cart-totals-block u-indent-30">
                      <div class="u-cart-block-container u-clearfix">
                        <div class="u-align-right u-cart-block-content u-text">
                          <div class="u-cart-totals-table u-table u-table-responsive">
                            <table class="u-table-entity">
                              <colgroup>
                                <col width="50%">
                                <col width="50%">
                              </colgroup>
                              <tbody class="u-align-right u-table-body">
                                <tr>
                                  <td class="u-align-left u-first-column u-table-cell u-table-cell-19">Total</td>
                                  <td class="u-table-cell u-table-cell-20"><div id="total" value="${totalDiscount}"> <c:out value = "$${totalDiscount}"/></div></td>
                                </tr>
                                <tr>
                                  <td class="u-align-left u-first-column u-table-cell u-table-cell-19">On your balance</td>
                                  <td class="u-table-cell u-table-cell-20"><div id="userBalance" value="${user.balance}"> <c:out value = "$${user.balance}"/></div></td>
                                </tr>
                                <c:if test="${not empty user.discount}">
                                   <td class="u-align-left u-first-column u-table-cell u-table-cell-19">You have a discount <c:out value = "${user.discount}"/>%.</td>
                                   <td class="u-table-cell u-table-cell-20">Your purchase will be made subject to the available discount.</td>
                                </c:if>
                              </tbody>
                            </table>
                          </div>

                         <div class="u-cart-button-container">
                            <form action="<c:url value="/order/cancel/${order.customerOrderId}"/>">
                                <button class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1" type="submit" >Cancel Order</button>
                            </form>
                            <form action="<c:url value="/order/pay/${order.customerOrderId}"/>">
                                <button class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1" type="submit" id="pay">Pay Order</button>
                            </form>
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
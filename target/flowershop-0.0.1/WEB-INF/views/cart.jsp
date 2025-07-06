<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="<c:url value="/resource/js/cart.js"/>" type="text/javascript"></script>
<link rel="stylesheet" href="cart.css" media="screen">
<title>Cart</title>
</head>

<%@ include file="header.jsp"%>

<body data-home-page-title="Cart" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">

        <section class="u-clearfix u-section-1" id="sec-37c0">
          <div class="u-clearfix u-sheet u-sheet-1">

            <div class="u-cart u-layout-grid u-cart-1" style="margin-top: 63px; margin-bottom: 60px; min-height: 375px;">

            <c:choose>
              <c:when test="${not empty cart.cartItems}">
              <div class="u-cart-products-table u-table u-table-responsive u-table-1">
                <table class="u-table-entity">
                  <colgroup>
                    <col width="65%">
                    <col width="15%">
                    <col width="15%">
                    <col width="15%">
                  </colgroup>
                  <thead class="u-table-header">
                    <tr>
                      <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Product </th>
                      <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Price </th>
                      <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Quantity </th>
                      <th class="u-border-2 u-border-grey-dark-1 u-border-no-left u-border-no-right u-border-no-top u-table-cell">Subtotal </th>
                    </tr>
                  </thead>

                  <tbody class="u-table-body">
                  <c:forEach var="cartItem" items="${cart.cartItems}">
                    <tr style="height: 29px;">
                      <td class="u-table-cell">
                      <button class=" removeButton u-cart-remove-item u-icon u-icon-1" id="<c:out value="${cartItem.productId}"/>"><svg class="u-svg-content" viewBox="0 0 52 52" x="0px" y="0px" style="width: 1em; height: 1em;"><g><path d="M26,0C11.664,0,0,11.663,0,26s11.664,26,26,26s26-11.663,26-26S40.336,0,26,0z M26,50C12.767,50,2,39.233,2,26
    		                S12.767,2,26,2s24,10.767,24,24S39.233,50,26,50z"></path><path d="M35.707,16.293c-0.391-0.391-1.023-0.391-1.414,0L26,24.586l-8.293-8.293c-0.391-0.391-1.023-0.391-1.414,0
    		                s-0.391,1.023,0,1.414L24.586,26l-8.293,8.293c-0.391,0.391-0.391,1.023,0,1.414C16.488,35.902,16.744,36,17,36
    		                s0.512-0.098,0.707-0.293L26,27.414l8.293,8.293C34.488,35.902,34.744,36,35,36s0.512-0.098,0.707-0.293
    		                c0.391-0.391,0.391-1.023,0-1.414L27.414,26l8.293-8.293C36.098,17.316,36.098,16.684,35.707,16.293z"></path>
                            </g></svg></button>
                        <img class="u-cart-product-image u-image u-image-default u-product-control" src="<c:url value="/resource/static/${cartItem.productPhoto}"/>">
                        <h2 class="u-cart-product-title u-product-control u-text u-text-1">
                          <div class="u-product-title-link" style="font-size: 1rem;">${cartItem.productName}</div>
                        </h2>
                      </td>
                      <td class="u-table-cell">
                        <div class="u-cart-product-price u-product-control u-product-price">
                          <div class="u-price-wrapper">
                            <div class="u-hide-price u-old-price"></div>
                            <div class="u-price">$${cartItem.price}</div>
                          </div>
                        </div>
                      </td>
                      <td class="u-table-cell">
                        <div class="u-cart-product-quantity u-product-control u-product-quantity u-product-quantity-1">
                          <div class="u-hidden u-quantity-label"> Quantity </div>
                          <div class="u-border-1 u-border-grey-25 u-quantity-input">
                            <div class="u-input">${cartItem.quantity}</div>
                          </div>
                        </div>
                      </td>
                      <td class="u-table-cell">
                        <div class="u-cart-product-subtotal u-product-control u-product-price">
                          <div class="u-price-wrapper">
                            <div class="u-hide-price u-old-price"></div>
                            <div class="u-price" style="font-weight: 700;">$${cartItem.price * cartItem.quantity}</div>
                          </div>
                        </div>
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>

              </c:when>
              			<c:otherwise>
              			<p class="u-align-center u-text u-text-2" data-animation-name="" data-animation-duration="0" data-animation-delay="0" data-animation-direction="">
              			Your cart is empty!
              			</p>
              			    <div class="u-cart-button-container">
              			        <c:url value="/catalog" var="url"></c:url>
                                <a href="${url}" class="u-active-none u-btn u-button-style u-cart-continue-shopping u-hover-none u-none u-text-body-color u-btn-1"><span class="u-icon"><svg class="u-svg-content" viewBox="0 0 443.52 443.52" x="0px" y="0px" style="width: 1em; height: 1em;"><g><g><path d="M143.492,221.863L336.226,29.129c6.663-6.664,6.663-17.468,0-24.132c-6.665-6.662-17.468-6.662-24.132,0l-204.8,204.8    c-6.662,6.664-6.662,17.468,0,24.132l204.8,204.8c6.78,6.548,17.584,6.36,24.132-0.42c6.387-6.614,6.387-17.099,0-23.712    L143.492,221.863z"></path>
                                    </g>
                                    </g></svg></span>&nbsp;Continue Shopping
                                </a>
                            </div>
              			 </c:otherwise>
              </c:choose>

              <c:if test="${not empty cart.cartItems}">
              <div class="u-cart-button-container">
                <c:url value="/catalog" var="url"></c:url>
                <a href="${url}" class="u-active-none u-btn u-button-style u-cart-continue-shopping u-hover-none u-none u-text-body-color u-btn-1"><span class="u-icon"><svg class="u-svg-content" viewBox="0 0 443.52 443.52" x="0px" y="0px" style="width: 1em; height: 1em;"><g><g><path d="M143.492,221.863L336.226,29.129c6.663-6.664,6.663-17.468,0-24.132c-6.665-6.662-17.468-6.662-24.132,0l-204.8,204.8    c-6.662,6.664-6.662,17.468,0,24.132l204.8,204.8c6.78,6.548,17.584,6.36,24.132-0.42c6.387-6.614,6.387-17.099,0-23.712    L143.492,221.863z"></path>
                    </g>
                    </g></svg></span>&nbsp;Continue Shopping
                </a>
                <button class="removeAllButton u-btn u-button-style u-cart-update u-grey-5">Clear Cart</button>
              </div>
              <div class="u-cart-blocks-container">
                <div class="u-cart-block u-indent-30">
                </div>
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
                              <td class="u-align-left u-first-column u-table-cell u-table-cell-19" style="font-weight: 700;">Total</td>
                              <td class="u-table-cell u-table-cell-20" style="font-weight: 700;">$${cart.totalPrice}</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                      <c:url value="/order" var="url1"></c:url>
                      <a href="${url1}" class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1">Proceed to Checkout</a>
                    </div>
                  </div>
                </div>
              </div>
              </c:if>

            </div>
          </div>
        </section>

        <%@ include file="footer.jsp"%>

</body>
</html>
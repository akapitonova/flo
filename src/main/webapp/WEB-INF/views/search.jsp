<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="<c:url value="/resource/js/catalog.js"/>" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resource/css/catalog.css"/>" media="screen">
<title>Catalog</title>
</head>
<body data-home-page-title="Login" data-path-to-root="./" data-include-products="true" class="u-body u-xl-mode" data-lang="ru">

    <%@ include file="header.jsp"%>

<section class="u-align-center u-clearfix u-section-1" id="carousel_a803">
      <div class="u-clearfix u-sheet u-sheet-1">

            <form action="<c:url value="/search/"/>" class="u-border-1 u-border-grey-30 u-search u-search-right u-white u-search-1">
                  <input class="search-input u-search-input" type="search" name="searchParam" value="" placeholder="Enter product name">
                  <input class="range u-border-grey-30" name="minParam" value="" placeholder="Enter min price">
                  <input class="range u-border-grey-30" name="maxParam" value="" placeholder="Enter max price">
                  <button class="u-search-button" type="submit">
                      <span class="u-file-icon u-search-icon u-spacing-10 u-search-icon-1">
                         <img src="<c:url value="/resource/static/icon/search.png"/>" alt="">
                      </span>
                  </button>
                </form>

<c:choose>
    <c:when test="${not empty products}">
    <p class="u-align-center u-text u-text-2" data-animation-name="" data-animation-duration="0" data-animation-delay="0" data-animation-direction=""><c:out value="${results}"/></p>

        <div class="u-expanded-width u-list u-list-1">
          <div class="u-repeater u-repeater-1">
          <c:forEach var="product" items="${products}">
            <div class="u-align-center u-container-style u-list-item u-repeater-item u-shape-rectangle u-white u-list-item-1">
              <div class="u-container-layout u-similar-container u-container-layout-1">
                <img alt="" class="u-expanded-width u-image u-image-default u-image-1" data-image-width="564" data-image-height="751" src="<c:url value="/resource/static/${product.photo}"/>">
                <h5 class="u-align-left u-custom-font u-text u-text-font u-text-3"> ${product.name}</h5>
                    <span class="u-file-icon u-icon u-icon-1">
                        <img src="<c:url value="/resource/static/icon/waserhouse.png"/>" alt="">
                    </span>
                <p class="u-align-left u-text u-text-4">${product.storeqty }</p>
                <h5 class="u-align-left u-custom-font u-text u-text-font u-text-5"> $${product.price }</h5>
                <div class="u-form u-form-1">
                          <div class="u-clearfix u-form-horizontal u-form-spacing-15 u-inner-form" style="padding: 15px;">
                            <div class="u-form-group u-form-number u-form-number-layout-number u-label-none u-form-group-1">
                              <label for="number-f8b3" class="u-label">Input number field</label>
                              <div class="u-input-row" data-value="1">
                                <input value="1" min="1" max="<c:out value="${product.storeqty}"/>" step="1" type="number" placeholder="" id="number-f8b3" name="<c:out value="${product.productId}"/>" data-qty="${product.storeqty}" class="u-input u-input-rectangle u-text-black">
                              </div>
                            </div>
                            <div class="u-form-group u-form-submit">
                              <button id="<c:out value="${product.productId}"/>" class="u-btn u-btn-round u-btn-submit u-button-style u-grey-60 u-hover-grey-50 u-radius-6 u-btn-1 add-to-cart-btn" data-animation-name="" data-animation-duration="0" data-animation-delay="0" data-animation-direction="">Buy<br>
                              </a>
                            </div>
                          </div>
                        </div>
              </div>
            </div>
            </c:forEach>
          </div>
        </div>
        	</c:when>
        	<c:when test="${not empty noResults}">
        	    <p class="u-align-center u-text u-text-2" data-animation-name="" data-animation-duration="0" data-animation-delay="0" data-animation-direction=""><c:out value="${noResults}"/></p>
        	</c:when>
            	<c:otherwise>
            	    <p class="u-align-center u-text u-text-2" data-animation-name="" data-animation-duration="0" data-animation-delay="0" data-animation-direction="">No search results</p>
            	</c:otherwise>
            </c:choose>

      </div>
    </section>

	<%@ include file="footer.jsp"%>

</body>
</html>
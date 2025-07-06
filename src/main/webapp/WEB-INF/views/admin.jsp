<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/resource/css/admin.css"/>" media="screen">
<title>Admin</title>
</head>
<link rel="stylesheet" href="<c:url value="/resource/css/main.css"/>" media="screen">
<script class="u-script" type="text/javascript" src="<c:url value="/resource/js/jquery.js"/>" defer=""></script>
<script class="u-script" type="text/javascript" src="<c:url value="/resource/js/main.js"/>" defer=""></script>
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">

<body class="u-body u-xl-mode">
    <section class="u-align-center u-clearfix u-section-1" id="sec-3286">
      <div class="u-clearfix u-sheet u-sheet-1">
      <a href="<c:url value="/logout" />" class="u-border-none u-btn u-btn-round u-button-style u-grey-50 u-radius-6 u-btn-1">Logout</a>
        <div class="u-expanded-width u-tab-links-align-left u-tabs u-tabs-1">
          <ul class="u-border-2 u-border-palette-1-base u-spacing-10 u-tab-list u-unstyled" role="tablist">
            <li class="u-tab-item" role="presentation">
              <a class="active u-active-grey-70 u-button-style u-grey-10 u-tab-link u-text-active-white u-text-black u-tab-link-1" id="link-tab-0da5" href="#tab-0da5" role="tab" aria-controls="tab-0da5" aria-selected="true">Orders Details</a>
            </li>
            <li class="u-tab-item" role="presentation">
              <a class="u-active-grey-70 u-button-style u-grey-10 u-tab-link u-text-active-white u-text-black u-tab-link-2" id="link-tab-f0d2" href="#tab-f0d2" role="tab" aria-controls="tab-f0d2" aria-selected="false">Users Details</a>
            </li>
          </ul>
          <div class="u-tab-content">
            <div class="u-container-style u-tab-active u-tab-pane u-white u-tab-pane-1" id="tab-0da5" role="tabpanel" aria-labelledby="link-tab-0da5">
              <div class="u-container-layout u-valign-top u-container-layout-1">
                <div class="u-expanded-width u-table u-table-responsive u-table-1">
                  <table id="orderList" class="u-table-entity">
                    <colgroup>
                      <col width="25%">
                      <col width="25%">
                      <col width="25%">
                      <col width="25%">
                      <col width="25%">
                    </colgroup>
                    <tbody class="u-table-alt-grey-5 u-table-body">
                      <tr style="height: 51px;">
                        <td class="u-table-cell">Order ID</td>
                        <td class="u-table-cell">Customer</td>
                        <td class="u-table-cell">Open Date</td>
                        <td class="u-table-cell">Status</td>
                        <td class="u-table-cell">Action</td>
                      </tr>
                      <c:forEach var="order" items="${orders}">
                      <tr style="height: 51px;">
                        <td class="u-table-cell">${order.customerOrderId}</td>
                        <td class="u-table-cell">${order.user.userId}</td>
                        <td class="u-table-cell">${order.openDate}</td>
                        <td class="u-table-cell">${order.status}</td>
                        <td class="u-table-cell">
                            <c:if test="${order.status eq 'PAYED'}">
                                <a href="<c:url value="/admin/closeOrder/${order.customerOrderId}" />">Close</a>
                            </c:if>
                        </td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div class="u-container-style u-tab-pane u-white u-tab-pane-2" id="tab-f0d2" role="tabpanel" aria-labelledby="link-tab-f0d2">
              <div class="u-container-layout u-valign-top u-container-layout-2">
                <div class="u-expanded-width u-table u-table-responsive u-table-2">
                  <table  id="usersList" class="u-table-entity">
                    <colgroup>
                      <col width="25%">
                      <col width="25%">
                      <col width="25%">
                      <col width="25%">
                    </colgroup>
                    <tbody class="u-table-alt-grey-5 u-table-body">
                      <tr style="height: 51px;">
                        <td class="u-table-cell">User ID</td>
                        <td class="u-table-cell">User Name</td>
                        <td class="u-table-cell">Balance</td>
                        <td class="u-table-cell">Action</td>
                      </tr>
                      <c:forEach var="user" items="${users}">
                      <tr style="height: 51px;">
                        <td class="u-table-cell">${user.userId}</td>
                        <td class="u-table-cell">${user.userName}</td>
                        <td class="u-table-cell">${user.balance}</td>
                        <td class="u-table-cell"><a href="<c:url value="/admin/addMoney/${user.userId}"/>">Add money</a></td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>
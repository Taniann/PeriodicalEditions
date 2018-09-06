<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>Periodical editions</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/bootstrap.css"/>"/>
    <link rel="stylesheet" type="text/css"
             href="<c:url value="/resources/css/style.css"/>"/>
    <c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'uk_UA'}"/>
    <fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="cartPage" var="cartPage"/>
    <fmt:setBundle basename="common" var="common"/>

    </head>
      <body>
        <div class="container-fluid">
            <div class="row">
                <div class="navbar navbar-inverse">
                    <div class="container">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="/view/user/profile.jsp"><fmt:message key="common.myProfile" bundle="${common}"/></a></li>
                                <li><a href="${pageContext.request.contextPath}/controller?command=reviewSubscriptions"><fmt:message key="common.mySubscription" bundle="${common}"/></a></li>
                            </ul>
                             <ul class="nav navbar-nav navbar-right">
                                 <li><a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="common.exit" bundle="${common}"/></a></li>
                                 <li><a href="${pageContext.request.contextPath}/controller?command=changeLocale&locale=en_US"
                                 title="<fmt:message key="common.localeHint" bundle="${common}"/>">ENG</a></li>
                                 <li><a href="${pageContext.request.contextPath}/controller?command=changeLocale&locale=uk_UA"
                                  title="<fmt:message key="common.localeHint" bundle="${common}"/>">УКР</a></li>
                             </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div class="container-fluid">
                <c:forEach items="${sessionScope.cart}" var="cartRecord">
                 <div class="row">
                    <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3 col-md-offset-1">${cartRecord.edition.name}</div>
                    <c:forEach items="${cartRecord.months}" var="month">
                        <c:if test="${month == '0'}">
                           <div class="col-md-1 col-lg-1 col-sm-1 col-xs-1"><fmt:message key="cartPage.january" bundle="${cartPage}"/></div>
                          </c:if>
                        <c:if test="${month == '1'}">
                           <div class="col-md-1 col-lg-1 col-sm-1 col-xs-1"><fmt:message key="cartPage.february" bundle="${cartPage}"/></div>
                          </c:if>
                        <c:if test="${month == '9'}">
                           <div class="col-md-1 col-lg-1 col-sm-1 col-xs-1"><fmt:message key="cartPage.october" bundle="${cartPage}"/></div>
                          </c:if>
                        <c:if test="${month == '10'}">
                           <div class="col-md-1 col-lg-1 col-sm-1 col-xs-1"><fmt:message key="cartPage.november" bundle="${cartPage}"/></div>
                          </c:if>
                        <c:if test="${month == '11'}">
                           <div class="col-md-1 col-lg-1 col-sm-1 col-xs-1"><fmt:message key="cartPage.december" bundle="${cartPage}"/></div>
                          </c:if>
                     </c:forEach>
                     <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3">${cartRecord.amount} <fmt:message key="cartPage.uah" bundle="${cartPage}"/> </div>
                     <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3"><a href="${pageContext.request.contextPath}/controller?command=deleteFromCart&id=${cartRecord.id}">
                     <fmt:message key="cartPage.delete" bundle="${cartPage}"/></a></div>
                   </div>
                    </c:forEach>
              <p><fmt:message key="cartPage.totalAmount" bundle="${cartPage}"/>&nbsp;&nbsp;${totalAmount} <fmt:message key="cartPage.uah" bundle="${cartPage}"/></p>
             </div>
            <a href="${pageContext.request.contextPath}/controller?command=showCatalogPage&currentPage=1" class="btn btn-secondary">
            <fmt:message key="cartPage.continueSelect" bundle="${cartPage}"/><i class="fa fa-arrow left"></i></a>
            <a href="/view/user/order.jsp" class="btn btn-primary">
            <fmt:message key="cartPage.completeOrder" bundle="${cartPage}"/><i class="fa fa-arrow left"></i></a>
      </body>
     <script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>
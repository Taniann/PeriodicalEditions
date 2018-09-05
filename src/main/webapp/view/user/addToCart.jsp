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
    <fmt:setBundle basename="message" var="message"/>

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
                 <div class="row">
                 <form method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
                    <div class="col-md-2 col-md-offset-1">
                        <p>2018</p>
                        <p><input type="checkbox" name="month" value="0" disabled/><fmt:message key="cartPage.january" bundle="${cartPage}"/>
                        <input type="checkbox" name="month" value="1" disabled/><fmt:message key="cartPage.february" bundle="${cartPage}"/></p>
                        <p><input type="checkbox" name="month" value="2" disabled/><fmt:message key="cartPage.march" bundle="${cartPage}"/>
                        <input type="checkbox" name="month" value="3" disabled/><fmt:message key="cartPage.april" bundle="${cartPage}"/></p>
                        <p><input type="checkbox" name="month" value="4" disabled/><fmt:message key="cartPage.may" bundle="${cartPage}"/>
                        <input type="checkbox" name="month" value="5" disabled/><fmt:message key="cartPage.june" bundle="${cartPage}"/></p>
                        <p><input type="checkbox" name="month" value="6" disabled/><fmt:message key="cartPage.july" bundle="${cartPage}"/>
                        <input type="checkbox" name="month" value="7" disabled/><fmt:message key="cartPage.august" bundle="${cartPage}"/></p>
                        <p><input type="checkbox" name="month" value="8" disabled/><fmt:message key="cartPage.september" bundle="${cartPage}"/>
                        <input type="checkbox" name="month" value="9"/><fmt:message key="cartPage.october" bundle="${cartPage}"/></p>
                        <p><input type="checkbox" name="month" value="10"/><fmt:message key="cartPage.november" bundle="${cartPage}"/>
                        <input type="checkbox" name="month" value="11"/><fmt:message key="cartPage.december" bundle="${cartPage}"/></p>
                     </div>
                     <div class="col-md-6">

                      <c:if test="${editionForCart != null}">
                         <input type="hidden" name="id" value="<c:out value='${editionForCart.id}' />" />
                      </c:if>
                       <c:if test="${requestScope.notCkeckedMonths != null}">
                          <h4><fmt:message key="message.notCheckedMonths" bundle="${message}"/></h4>
                       </c:if>
                         <img src="" alt="">
                            <div class="caption">
                                <h2><c:out value="${editionForCart.name}"/></h2>
                                <p><c:out value="${editionForCart.price}"/> <fmt:message key="cartPage.uah" bundle="${cartPage}"/></p>
                                <p><c:out value="${editionForCart.info}"/></p>
                                <p><fmt:message key="cartPage.rules" bundle="${cartPage}"/></p>
                                <p><fmt:message key="cartPage.rulesInfo" bundle="${cartPage}"/></p>
                                <p><fmt:message key="cartPage.dataReliability" bundle="${cartPage}"/></p>
                                <p><fmt:message key="cartPage.subscriptionCancel" bundle="${cartPage}"/></p>
                           </div>
                         <a href="${pageContext.request.contextPath}/controller?command=showCatalogPage&currentPage=1" class="btn btn-secondary">
                         <fmt:message key="cartPage.back" bundle="${cartPage}"/><i class="fa fa-arrow left"></i></a>
                        <button class="btn btn-success" type="submit" value="addToCart" name="command">
                        <fmt:message key="cartPage.addToCart" bundle="${cartPage}"/></button>
                    </div>
                    </form>
                </div>
            </div>
      </body>
     <script src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>

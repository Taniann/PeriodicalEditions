<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>Periodical editions</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/css/bootstrap.css"/>"/>
        <script src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap-formhelpers-phone.js"/>"></script>
     <c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'uk_UA'}"/>
     <fmt:setLocale value="${locale}"/>
     <fmt:setBundle basename="orderPage" var="orderPage"/>
     <fmt:setBundle basename="common" var="common"/>
  </head>
      <body>
        <div class="container-fluid">
            <div class="row">
                <div class="navbar navbar-inverse">
                    <div class="container">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
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
                <form method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
                 <div class="row">
                 </div>
                 <div class="row">
                 <form method="post" action="${pageContext.request.contextPath}/controller" >
                  <c:if test="${user != null}">
                      <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                  </c:if>
                    <div class="col-md-3 col-md-offset-1"><fmt:message key="orderPage.firstName" bundle="${orderPage}"/>
                        <input type="text" name="firstName" size="20"
                        class="form-control"  value= "<c:out value='${user.firstName}' />" required /></div>

                    <div class="col-md-3"><fmt:message key="orderPage.secondName" bundle="${orderPage}"/>
                        <input type="text" name="secondName" size="20"
                        class="form-control" required value="<c:out value='${user.secondName}' />" required /></div>
                    <div class="col-md-3"><fmt:message key="orderPage.middleName" bundle="${orderPage}"/>
                        <input type="text" name="middleName" required size="20"
                        class="form-control" value="<c:out value='${user.middleName}' />" required /></div>
                   </div>
                   <div class="row" style="padding-top: 20px" >
                      <div class="col-md-3 col-md-offset-1"><fmt:message key="orderPage.email" bundle="${orderPage}"/>
                        <input type="email" name="email" size="30"
                        class="form-control" value="<c:out value='${user.email}' />" required/></div>
                      <div class="col-md-3" ><fmt:message key="orderPage.phone" bundle="${orderPage}"/>
                        <input type="text" data-format="+380 (dd) ddd-dddd"
                        name="phone" class="form-control bfh-phone" value="<c:out value='${user.phone}' />" required/></div>
                   </div>
                    <div class="row" style="padding-top: 20px" >
                           <div class="col-md-3 col-md-offset-1"><fmt:message key="orderPage.city" bundle="${orderPage}"/>
                                <input type="text" name="city" size="15"
                                class="form-control" value="" required/></div>
                           <div class="col-md-3" ><fmt:message key="orderPage.streetName" bundle="${orderPage}"/>
                                <input type="text"
                                name="streetName" class="form-control" value="" required/></div>
                            <div class="col-md-3" ><fmt:message key="orderPage.index" bundle="${orderPage}"/>
                                <input type="text"
                                name="index" class="form-control" value="" required/></div>
                        </div>
                    <div class="row" style="padding-top: 20px" >
                             <div class="col-md-2 col-md-offset-1"><fmt:message key="orderPage.houseNumber" bundle="${orderPage}"/>
                                <input type="text" name="houseNumber" size="15"
                                class="form-control" value="" required /></div>
                             <div class="col-md-2" ><fmt:message key="orderPage.flatNumber" bundle="${orderPage}"/>
                                <input type="text"
                                name="flatNumber" class="form-control" value=""/>
                             </div>
                    </div>
                   <div class="row">
                        <div class="col-md-3 col-md-offset-1" style="padding-top: 20px">
                            <button class="btn btn-primary" type="submit" value="makeOrder" name="command">
                            <fmt:message key="orderPage.save" bundle="${orderPage}"/></button>
                         </div>

                  </div>
              </form>
             </div>
      </body>
    </html>
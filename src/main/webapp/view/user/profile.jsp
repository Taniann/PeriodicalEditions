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
     <fmt:setBundle basename="profilePage" var="profilePage"/>
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
                    <div class="col-md-2 col-md-2 col-lg-2 col-sm-3 col-xs-3 col-md-offset-1"><fmt:message key="profilePage.firstName" bundle="${profilePage}"/></div>
                    <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3"><fmt:message key="profilePage.secondName" bundle="${profilePage}"/></div>
                    <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3"><fmt:message key="profilePage.middleName" bundle="${profilePage}"/></div>
                 </div>
                 <div class="row">
                 <form method="post" action="${pageContext.request.contextPath}/controller" >
                  <c:if test="${user != null}">
                      <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                  </c:if>
                    <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3 col-md-offset-1"><input type="text" name="firstName" size="20"
                                                          class="form-control" value="<c:out value='${user.firstName}' />" /></div>
                    <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3"><input type="text" name="secondName" size="20"
                                                          class="form-control" value="<c:out value='${user.secondName}' />" /></div>
                     <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3"><input type="text" name="middleName" size="20"
                                                          class="form-control" value="<c:out value='${user.middleName}' />" /></div>
                   </div>
                 <div class="row">
                           <div class="col-md-4 col-lg-4 col-sm-3 col-xs-3 col-md-offset-1" style="padding-top: 20px"><fmt:message key="profilePage.email" bundle="${profilePage}"/></div>
                           <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3" style="padding-top: 20px"><fmt:message key="profilePage.phone" bundle="${profilePage}"/></div>
                        </div>
                   <div class="row" >
                      <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 col-md-offset-1"><input type="email" name="email" size="30"
                                               class="form-control" value="<c:out value='${user.email}' />" /></div>
                       <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 col-md-offset-1"><input type="text" data-format="+380 (dd) ddd-dddd"
                                              name="phone" class="form-control bfh-phone" value="<c:out value='${user.phone}' />"/></div>
                   </div>
                  <div class="row">
                       <div class="col-md-2 col-lg-2 col-sm-2 col-xs-2 col-md-offset-1" style="padding-top: 20px"><fmt:message key="profilePage.cardBalance" bundle="${profilePage}"/></div>
                       <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 " style="padding-top: 20px" ><input type="text" name="cardBalance" size="10"
                                                                  value="<c:out value='${user.cardBalance}' />" /></div>
                  </div>
                   <div class="row">
                        <div class="col-md-3 col-lg-3 col-sm-4 col-xs-4 col-md-offset-1" style="padding-top: 20px">
                            <button class="btn btn-primary" type="submit" value="editProfile" name="command">
                            <fmt:message key="profilePage.save" bundle="${profilePage}"/></button>
                         </div>
                         <div div class="col-md-3 col-lg-3 col-sm-4 col-xs-4 col-md-offset-1" style="padding-top: 20px">
                             <a href="/view/user/changePassword.jsp" class="btn btn-primary">
                             <fmt:message key="profilePage.changePassword" bundle="${profilePage}"/><i class="fa fa-arrow right"></i></a>
                         </div>
                  </div>
              </form>
                <a href="${pageContext.request.contextPath}/controller?command=showCatalogPage&currentPage=1" class="btn btn-primary">
                <fmt:message key="profilePage.returnToCatalog" bundle="${profilePage}"/><i class="fa fa-arrow left"></i></a>
             </div>
      </body>

    </html>
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
    <c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'uk_UA'}"/>
    <fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="registrationPage" var="registrationPage"/>
    <fmt:setBundle basename="common" var="common"/>

  </head>

<body>
  <div class="container-fluid">
        <div class="row">
            <div class="navbar navbar-inverse">
                <div class="container">
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href=""><fmt:message key="common.myProfile" bundle="${common}"/></a></li>
                            <li><a href=""><fmt:message key="common.mySubscription" bundle="${common}"/></a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="${pageContext.request.contextPath}/controller?command=changeLocale&locale=en_US" title="<fmt:message key="common.localeHint" bundle="${common}"/>">ENG</a></li>
                            <li><a href="${pageContext.request.contextPath}/controller?command=changeLocale&locale=uk_UA" title="<fmt:message key="common.localeHint" bundle="${common}"/>">УКР</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
<div class="row">
    <div class="col-md-5 col-lg-5 col-sm-5 col-xs-5"></div>
    <div class="col-md-2 col-lg-2 col-sm-2 col-xs-2" style="text-align: center;">
        <form style="padding-top: 100%; text-align: center" method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
            <input type="text" placeholder="<fmt:message key="registrationPage.login" bundle="${registrationPage}"/>" name="login"
                   required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />
            <input type="password" placeholder="<fmt:message key="registrationPage.password" bundle="${registrationPage}"/>"
                   minlength="6" name="password" required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />
            <button class="btn btn-primary" type="submit" value="login" name="command"><fmt:message key="loginPage.login" bundle="${registrationPage}"/></button>
        </form>
    </div>
</div>
</body>
</html>

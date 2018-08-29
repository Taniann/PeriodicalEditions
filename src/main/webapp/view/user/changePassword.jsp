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
    <script src="<c:url value="/resources/js/validator.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap-formhelpers-phone.js"/>"></script>
    <c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'en_US'}"/>
    <fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="message" var="message"/>

  </head>

<body>
  <div class="container-fluid">
        <div class="row">
            <div class="navbar navbar-inverse">
                <div class="container">
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="/PeriodicalEditions?command=setUkrainian">UKR</a></li>
                            <li><a href="/PeriodicalEditions?command=setEnglish">ENG</a></li>
                            <li><a href="/view/user/profile.jsp">My profile</a></li>

                    </div>
                </div>
            </div>
        </div>
    </div>
<div class="row">
    <div class="col-md-5"></div>
    <div class="col-md-2" style="text-align: center;">
        <form style="padding-top: 100%; text-align: center" data-toggle="validator" method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
                  <c:if test="${user != null}">
                      <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                  </c:if>
           <c:if test="${requestScope.successfulMessage != null}">
                <h4><fmt:message key="message.uncorrectOldPassword" bundle="${message}"/></h4>
            </c:if>
            <c:if test="${requestScope.uncorrectOldPassword != null}">
                <h4><fmt:message key="message.uncorrectOldPassword" bundle="${message}"/></h4>
            </c:if>
            <input type="password" placeholder="your password"
                   minlength="6" name="password"   required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />
            <input type="password" placeholder="new password"
                   minlength="6" name="newPassword" id="newPassword"  required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />
            <input type="password" placeholder="confirm new password"
                   minlength="6" name="conpassword" required
                   data-match="#newPassword" data-match-error="Whoops, these don't match"
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />

            <button class="btn btn-primary" type="submit" value="changePassword" name="command">Save</button>
        </form>
    </div>
    <div class="col-md-5"></div>
</div>
</body>
</html>

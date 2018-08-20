<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>Periodical editions</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/bootstrap.css"/>"/>
    <script src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <fmt:setBundle basename="registrationPage" var="registrationPage"/>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
<div class="row">
    <div class="col-md-5"></div>
    <div class="col-md-2" style="text-align: center;">
        <form style="padding-top: 100%; text-align: center" method="post" action="/register" class="center-block">
            <input type="email" placeholder="<fmt:message key="registrationPage.email" bundle="${registrationPage}"/>" name="email"
                   required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />
            <input type="text" name="phone" placeholder="<fmt:message key="registrationPage.phone" bundle="${registrationPage}"/>"
                   required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />
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
            <input type="password" placeholder="<fmt:message key="registrationPage.confirmPassword" bundle="${registrationPage}"/>"
                   minlength="6" name="password" required
                   class="form-control"
                   style="width: 100%; margin-bottom: 10px"
            />

            <button class="btn btn-primary" type="submit" value="register" name="command"><fmt:message key="registrationPage.signUp"
                                                                                            bundle="${registrationPage}"/></button>
        </form>
    </div>
    <div class="col-md-5"></div>
</div>
</body>
</html>

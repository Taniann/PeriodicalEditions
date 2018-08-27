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
    <fmt:setBundle basename="catalogPage" var="catalogPage"/>
    </head>
      <body>
        <div class="container-fluid">
            <div class="row">
                <div class="navbar navbar-inverse">
                    <div class="container">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.request.contextPath}/controller?command=logout">Вийти</a></li>
                                <li><a href="/PeriodicalEditions?command=setUkrainian">UKR</a></li>
                                <li><a href="/PeriodicalEditions?command=setEnglish">ENG</a></li>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div class="container-fluid">
                 <div class="row">
                 <form method="post" action="${pageContext.request.contextPath}/controller">
                  <c:if test="${user != null}">
                      <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                  </c:if>
                    <div class="col-md-2 col-md-offset-1"><input type="text" name="firstName" size="20"
                                                          value="<c:out value='${user.firstName}' />" /></div>
                    <div class="col-md-2"><input type="text" name="secondName" size="20"
                                                          value="<c:out value='${user.secondName}' />" /></div>
                     <div class="col-md-2"><input type="text" name="middleName" size="20"
                                                          value="<c:out value='${user.middleName}' />" /></div>
                   </div>
                   <div class="row" >
                      <div class="col-md-2 col-md-offset-1" style="padding: 20px"><input type="text" name="email" size="30"
                                             value="<c:out value='${user.email}' />" /></div>
                       <div class="col-md-2 col-md-offset-1" style="padding: 20px"><input type="phone" name="phone" size="20"
                                             value="<c:out value='${user.phone}' />" /></div>
                   </div>
                   <div class="row" style="padding: 50px">
                       <button class="btn btn-primary" type="submit" value="changeEdition" name="command">Save</button>
                       <a href="#" class="btn btn-primary">Змінити пароль<i class="fa fa-arrow right"></i></a>
                   </div>
             </div>
            <a href="/view/user/catalog.jsp" class="btn btn-primary">Повернутися до каталогу<i class="fa fa-arrow left"></i></a>
      </body>
     <script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>
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
                 <form method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
                    <div class="col-md-2 col-md-offset-1">
                        <p>2018</p>
                        <p><input type="checkbox" name="month" value="0" disabled/>Січень
                        <input type="checkbox" name="month" value="1" disabled/>Лютий</p>
                        <p><input type="checkbox" name="month" value="2" disabled/>Березень
                        <input type="checkbox" name="month" value="3" disabled/>Квітень</p>
                        <p><input type="checkbox" name="month" value="4" disabled/>Травень
                        <input type="checkbox" name="month" value="5" disabled/>Червень</p>
                        <p><input type="checkbox" name="month" value="6" disabled/>Липень
                        <input type="checkbox" name="month" value="7" disabled/>Серпень</p>
                        <p><input type="checkbox" name="month" value="8" disabled/>Вересень
                        <input type="checkbox" name="month" value="9"/>Жовтень</p>
                        <p><input type="checkbox" name="month" value="10"/>Листопад
                        <input type="checkbox" name="month" value="11"/>Грудень</p>
                     </div>
                     <div class="col-md-6">

                      <c:if test="${editionForCart != null}">
                         <input type="hidden" name="id" value="<c:out value='${editionForCart.id}' />" />
                      </c:if>
                         <img src="" alt="">
                            <div class="caption">
                                <h2><c:out value="${editionForCart.name}"/></h2>
                                <p><c:out value="${editionForCart.price}"/></p>
                                <p><c:out value="${editionForCart.info}"/></p>
                           </div>
                         <a href="#" class="btn btn-success">Назад<i class="fa fa-arrow left"></i></a>
                        <button class="btn btn-success" type="submit" value="addToCart" name="command">До корзини</button>
                    </div>
                    </form>
                </div>
            </div>
      </body>
     <script src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>

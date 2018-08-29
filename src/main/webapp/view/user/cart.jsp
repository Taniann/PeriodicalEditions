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
                <c:forEach items="${sessionScope.cart}" var="cartRecord">
                 <div class="row">
                    <div class="col-md-2 col-md-offset-1">${cartRecord.edition.name}</div>
                    <c:forEach items="${cartRecord.months}" var="month">
                        <c:if test="${month == '0'}">
                           <div class="col-md-1">Січень</div>
                          </c:if>
                        <c:if test="${month == '1'}">
                           <div class="col-md-1">Лютий</div>
                          </c:if>
                        <c:if test="${month == '9'}">
                           <div class="col-md-1">Жовтень</div>
                          </c:if>
                        <c:if test="${month == '10'}">
                           <div class="col-md-1">Листопад</div>
                          </c:if>
                        <c:if test="${month == '11'}">
                           <div class="col-md-1">Грудень</div>
                          </c:if>
                     </c:forEach>
                     <div class="col-md-2">${cartRecord.amount}</div>
                     <div class="col-md-2"><a href="${pageContext.request.contextPath}/controller?command=deleteFromCart&id=${cartRecord.id}">Delete</a></div>
                   </div>
                    </c:forEach>
              <p>${totalAmount}</p>
             </div>
            <a href="/view/user/catalog.jsp" class="btn btn-success">Продовжити вибір<i class="fa fa-arrow left"></i></a>
            <a href="/view/user/order.jsp" class="btn btn-success">Оформити замовлення<i class="fa fa-arrow left"></i></a>
      </body>
     <script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>
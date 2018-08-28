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
                <form method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
                 <div class="row">
                    <div class="col-md-2 col-md-offset-1">First name</div>
                    <div class="col-md-2">Second name</div>
                    <div class="col-md-2">Middle name</div>
                 </div>
                 <div class="row">
                 <form method="post" action="${pageContext.request.contextPath}/controller" >
                  <c:if test="${user != null}">
                      <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                  </c:if>
                    <div class="col-md-2 col-md-offset-1"><input type="text" name="firstName" size="20"
                                                          class="form-control" value="<c:out value='${user.firstName}' />" /></div>
                    <div class="col-md-2"><input type="text" name="secondName" size="20"
                                                          class="form-control" value="<c:out value='${user.secondName}' />" /></div>
                     <div class="col-md-2"><input type="text" name="middleName" size="20"
                                                          class="form-control" value="<c:out value='${user.middleName}' />" /></div>
                   </div>
                 <div class="row">
                           <div class="col-md-3 col-md-offset-1" style="padding-top: 20px">Email</div>
                           <div class="col-md-2" style="padding-top: 20px">Phone number</div>
                        </div>
                   <div class="row" >
                      <div class="col-md-2 col-md-offset-1"><input type="email" name="email" size="30"
                                               class="form-control" value="<c:out value='${user.email}' />" /></div>
                       <div class="col-md-2 col-md-offset-1"><input type="text" data-format="+380 (dd) ddd-dddd"
                                              name="phone" class="form-control bfh-phone" value="<c:out value='${user.phone}' />"/></div>
                   </div>
                   <div class="row">
                        <div class="col-md-3 col-md-offset-1" style="padding-top: 20px">
                            <button class="btn btn-primary" type="submit" value="editProfile" name="command">Save</button>
                         </div>
                         <div div class="col-md-3 col-md-offset-1" style="padding-top: 20px">
                             <a href="/view/user/changePassword.jsp" class="btn btn-primary">Змінити пароль<i class="fa fa-arrow right"></i></a>
                         </div>
                  </div>
              </form>
                <a href="/view/user/catalog.jsp" class="btn btn-primary">Повернутися до каталогу<i class="fa fa-arrow left"></i></a>
             </div>
      </body>

    </html>
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
        <h1>Periodical editions</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/controller?command=showAddEdition">Add New Edition</a>
            &nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/controller?command=showAddCategory">Add New Category</a>
        </h2>

        <div class="row">
         <c:forEach var="edition" items="${editionList}">
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                <div class="thumbnail">
                    <img src="" alt="">
                    <div class="caption">
                        <h3><a href=""><c:out value="${edition.name}"/></a></h3>
                        <p><c:out value="${edition.info}"/></p>
                        <p>Categories: </p>
                        <a href="${pageContext.request.contextPath}/controller?command=showChangeEdition&id=${edition.id}" class="btn btn-success">Змінити<i class="fa fa-arrow right"></i></a>
                        <a href="${pageContext.request.contextPath}/controller?command=deleteEdition&id=${edition.id}" class="btn btn-success">Видалити<i class="fa fa-arrow right"></i></a>
                    </div>
                </div>
            </div>
           </c:forEach>
        </div>
      </body>
     <script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>

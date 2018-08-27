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
                                <li><a href="<c:url value="welcome.jsp"/>">Вийти</a></li>
                                <li><a href="/PeriodicalEditions?command=setUkrainian">UKR</a></li>
                                <li><a href="/PeriodicalEditions?command=setEnglish">ENG</a></li>
                        </div>
                    </div>
                </div>
            </div>
        </div>

     <div class="container" align="center">
            <table border="1" cellpadding="5">
            <form style="padding-top: 100%; text-align: center" method="post" action="${pageContext.request.contextPath}/controller" class="center-block">
            <tr>
                <th>Category name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${category.name}' />" />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-primary" type="submit" value="addCategory" name="command">Save</button>
                </td>
            </tr>
        </table>
        </form>
        <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Categories</h2></caption>

            <c:forEach var="category" items="${categoryList}">
                <tr>
                    <td><c:out value="${category.name}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=deleteCategory&id=${category.id}" class="btn btn-success">Видалити<i class="fa fa-arrow right"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
         </div>
    </div>
 </body>
 </html>
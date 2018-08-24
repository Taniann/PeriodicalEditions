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
                <c:if test="${edition != null}">
                    <input type="hidden" name="id" value="<c:out value='${edition.id}' />" />
                </c:if>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${edition.name}' />" />
                </td>
            </tr>
            <tr>
                <th>Info: </th>
                <td>
                    <input type="text" name="info" size="100"
                            value="<c:out value='${edition.info}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${edition.price}' />"
                    />
                </td>
            </tr>
           <tr>
                 <th>Image url: </th>
                 <td>
                    <input type="text" name="image_url" size="100"
                            value="<c:out value='${edition.image_url}' />"
                    />
                 </td>
            </tr>
            <tr>
                 <th>Type: </th>
                <td><select name="type">
                        <option value="друковане">Друковані видання</option>
                        <option value="електронне" >Електронні видання</option>
                    </select></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-primary" type="submit" value="addEdition" name="command">Save</button>
                </td>
            </tr>
        </table>
        </form>
    </div>
 </body>
 </html>

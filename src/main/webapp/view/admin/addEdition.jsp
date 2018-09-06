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
    <c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'uk_UA'}"/>
    <fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="adminPage" var="adminPage"/>
    <fmt:setBundle basename="common" var="common"/>
    </head>

      <body>
        <div class="container-fluid">
            <div class="row">
                <div class="navbar navbar-inverse">
                    <div class="container">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.request.contextPath}/controller?command=showAddCategory"><fmt:message key="adminPage.addCategory" bundle="${adminPage}"/></a></li>
                            </ul>
                             <ul class="nav navbar-nav navbar-right">
                                 <li><a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="common.exit" bundle="${common}"/></a></li>
                                 <li><a href="${pageContext.request.contextPath}/controller?command=changeLocale&locale=en_US"
                                 title="<fmt:message key="common.localeHint" bundle="${common}"/>">ENG</a></li>
                                 <li><a href="${pageContext.request.contextPath}/controller?command=changeLocale&locale=uk_UA"
                                  title="<fmt:message key="common.localeHint" bundle="${common}"/>">УКР</a></li>
                             </ul>
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
                <th><fmt:message key="adminPage.name" bundle="${adminPage}"/> </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${edition.name}' />" />
                </td>
            </tr>
            <tr>
                <th><fmt:message key="adminPage.info" bundle="${adminPage}"/> </th>
                <td>
                    <input type="text" name="info" size="100"
                            value="<c:out value='${edition.info}' />"
                    />
                </td>
            </tr>
            <tr>
                <th><fmt:message key="adminPage.price" bundle="${adminPage}"/> </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${edition.price}' />"
                    />
                </td>
            </tr>
           <tr>
                 <th><fmt:message key="adminPage.imageUrl" bundle="${adminPage}"/></th>
                 <td>
                    <input type="text" name="image_url" size="100"
                            value="<c:out value='${edition.imageUrl}' />"
                    />
                 </td>
            </tr>
            <tr>
                 <th><fmt:message key="adminPage.type" bundle="${adminPage}"/> </th>
                <td><select name="type">
                        <option value="1">Друковані видання</option>
                        <option value="2" >Електронні видання</option>
                    </select></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-primary" type="submit" value="addEdition" name="command"><fmt:message key="adminPage.save" bundle="${adminPage}"/></button>
                </td>
            </tr>
        </table>
        </form>
    </div>
 </body>
 </html>

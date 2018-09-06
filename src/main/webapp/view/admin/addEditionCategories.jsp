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
   <fmt:setBundle basename="message" var="message"/>
    </head>

      <body>
        <div class="container-fluid">
            <div class="row">
                <div class="navbar navbar-inverse">
                    <div class="container">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="${pageContext.request.contextPath}/controller?command=showAddEdition"><fmt:message key="adminPage.addEdition" bundle="${adminPage}"/></a></li>
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
           <c:if test="${requestScope.notCkecked != null}">
                <h4><fmt:message key="message.notChecked" bundle="${message}"/></h4>
            </c:if>
            <tr>
                <th><fmt:message key="adminPage.name" bundle="${adminPage}"/> </th>
                <td>
                    ${edition.name}
                </td>
            </tr>
           <tr>
                <th><fmt:message key="adminPage.categoriesList" bundle="${adminPage}"/> </th>
                <td>
                   <c:forEach var="category" items="${categories}">
                      <input type="checkbox" name="chekedCategory" value="${category.id}">${category.name}
                   </c:forEach>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-primary" type="submit" value="addEditionCategories" name="command">
                    <fmt:message key="adminPage.save" bundle="${adminPage}"/></button>
                </td>
            </tr>
        </table>
        </form>
    </div>
 </body>
 </html>

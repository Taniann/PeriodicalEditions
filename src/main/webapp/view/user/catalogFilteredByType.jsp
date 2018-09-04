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
    <fmt:setBundle basename="catalogPage" var="catalogPage"/>
    <fmt:setBundle basename="common" var="common"/>

    </head>
      <body>
        <div class="container-fluid">
            <div class="row">
                <div class="navbar navbar-inverse">
                    <div class="container">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="/view/user/profile.jsp"><fmt:message key="common.myProfile" bundle="${common}"/></a></li>
                                <li><a href="${pageContext.request.contextPath}/controller?command=reviewSubscriptions"><fmt:message key="common.mySubscription" bundle="${common}"/></a></li>
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

  <div class="row" style="padding-bottom: 20px">
  <form method="post" action="${pageContext.request.contextPath}/controller?command=searchByType&currentPage=1">
        <div class="col-md-10 col-md-offset-2">
            <select name="type">
                <option value="1" <c:if test="${requestScope.type != null && requestScope.type eq '1'}">selected</c:if>>
                <fmt:message key="catalogPage.typePrinted" bundle="${catalogPage}"/></option>
                <option value="2" <c:if test="${requestScope.type != null && requestScope.type eq '2'}">selected</c:if> >
                <fmt:message key="catalogPage.typeElectronic" bundle="${catalogPage}"/></option>
            </select>
            <button class="btn btn-secondary btn-sm" type="submit">
            <fmt:message key="catalogPage.search" bundle="${catalogPage}"/></button>
        </div>
  </form>
  </div>

        <div class="row">
            <div class="col-md-1 col-md-offset-1">
                <c:forEach var="category" items="${categories}">
                    <p><a href="${pageContext.request.contextPath}/controller?command=searchEditionsByCategory&id=${category.id}&currentPage=1">${category.name}</a></p>
                </c:forEach>
            </div>

             <c:forEach var="edition" items="${editionList}">
                <div class="col-md-3">
                    <div class="thumbnail">
                         <img src="" alt="">
                     <div class="caption">
                        <h3><a href="#"><c:out value="${edition.name}"/></a></h3>
                        <p><c:out value="${edition.info}"/></p>
                        <a href="${pageContext.request.contextPath}/controller?command=addToCartPage&id=${edition.id}" class="btn btn-success">
                        <fmt:message key="catalogPage.moreDetails" bundle="${catalogPage}"/><i class="fa fa-arrow right"></i></a>
                    </div>
                     </div>
                </div>
            </c:forEach>
        </div>

         <div class="row">
        <div class="col-md-9 col-md-offset-2">
        <nav aria-label="Navigation for editions">
            <ul class="pagination">
                <c:if test="${currentPage != 1}">
                    <li class="page-item"><a class="page-link"
                        href="${pageContext.request.contextPath}/controller?command=searchByType&type=${requestScope.type}&currentPage=${currentPage-1}">
                        <fmt:message key="catalogPage.previous" bundle="${catalogPage}"/></a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <li class="page-item active"><a class="page-link">
                                    ${i} <span class="sr-only">(current)</span></a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link"
                                href="${pageContext.request.contextPath}/controller?command=searchByType&type=${requestScope.type}&currentPage=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage lt noOfPages}">
                    <li class="page-item"><a class="page-link"
                        href="${pageContext.request.contextPath}/controller?command=searchByType&type=${requestScope.type}&currentPage=${currentPage+1}">
                        <fmt:message key="catalogPage.next" bundle="${catalogPage}"/></a>
                    </li>
                </c:if>
            </ul>
        </nav>
        </div>
        </div>
      </body>
     <script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
     <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    </html>

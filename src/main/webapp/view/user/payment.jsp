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
     <c:set var="locale" value="${not empty sessionScope.locale ? sessionScope.locale : 'uk_UA'}"/>
     <fmt:setLocale value="${locale}"/>
     <fmt:setBundle basename="paymentPage" var="paymentPage"/>
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
            <div class="container-fluid">
                 <form method="post" action="${pageContext.request.contextPath}/controller" >
                  <c:if test="${user != null}">
                      <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                  </c:if>
                  <c:if test="${requestScope.errorInputData != null}">
                     <h4><fmt:message key="message.errorInputData" bundle="${message}"/></h4>
                  </c:if>
                  <c:if test="${requestScope.errorMessage != null}">
                     <h4><fmt:message key="message.paymentError" bundle="${message}"/></h4>
                  </c:if>
                   <div class="row">
                    <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 col-md-offset-1"><fmt:message key="paymentPage.cardNumber" bundle="${paymentPage}"/>
                        <input type="text" data-format="dddd dddd dddd dddd"
                        name="cardNumber" size="20"
                        class="form-control  bfh-phone" required /></div>
                   </div>
                   <div class="row" style="padding-top: 20px" >
                      <div class="col-md-1 col-md-offset-1"><fmt:message key="paymentPage.expiresEnd" bundle="${paymentPage}"/>
                            <select name="expiresEndMonth">
                                <option value="1">01</option>
                                <option value="2">02</option>
                                <option value="3">03</option>
                                <option value="4">04</option>
                                <option value="5">05</option>
                                <option value="6">06</option>
                                <option value="7">07</option>
                                <option value="8">08</option>
                                <option value="9">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            <select name="expiresEndYear">
                                  <option value="19">19</option>
                                  <option value="20">20</option>
                                  <option value="21">21</option>
                                  <option value="22">22</option>
                                  <option value="23">23</option>
                                  <option value="24">24</option>
                                  <option value="25">25</option>
                                  <option value="26">26</option>
                                  <option value="27">27</option>
                                  <option value="28">28</option>
                                  <option value="29">29</option>
                                  <option value="30">30</option>
                             </select>
                       </div>
                   </div>
                   <div class="row" style="padding-top: 20px">
                    <div class="col-md-1 col-lg-1 col-sm-1 col-xs-1 col-md-offset-1">CVV<input type="text" data-format="ddd"
                                name="cvv"  class="form-control  bfh-phone" required /></div>
                   </div>
                    <div class="row">
                        <div class="col-md-3 col-lg-3 col-sm-3 col-xs-3 col-md-offset-1" style="padding-top: 20px">
                            <button class="btn btn-primary" type="submit" value="addSubscription" name="command">
                            <fmt:message key="paymentPage.save" bundle="${paymentPage}"/></button>
                         </div>
                  </div>
              </form>
             </div>
      </body>
    </html>
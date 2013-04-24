<%-- 
    Document   : header
    Created on : Dec 28, 2009, 1:14:48 PM
    Author     : gabriel
--%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

   


      <!-- Header -->
        <div id="header"  class="borderColor">
            <div id="headerLeft" class="borderColor">
                <a href="<c:url value="/main.htm"/>">
                    <img src="<c:url value="/images/logo_120x100.gif"/>">
                    <img src="<c:url value="/images/softvj.gif"/>">
                </a>

            </div>
            <div id="headerRight" class="borderColor">
                    
                <div id="topMenu">

                     <security:authorize ifNotGranted="ROLE_GUEST">
                        <span>  
                            <spring:message code="header.welcome.title" text="Welcome!" />
                            <security:authentication property="name" />
                        </span>
                    </security:authorize>
                     <span class="topMenuText"><a href="<c:url value="/main.htm?language=en"/>">English</a></span>
                     <span class="topMenuText"><a href="<c:url value="/main.htm?language=es"/>">Espa<span>&ntilde</span>ol</a></span>

                </div>
                
                
             </div>
            <div id="headerLine"></div>
        </div>
        <!-- End Header -->
                
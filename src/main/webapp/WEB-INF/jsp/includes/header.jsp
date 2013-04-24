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
            <div id="headerLeft" class="borderColor"><a href="<c:url value="/index.htm"/>"><img src="<c:url value="/images/car-logo3.jpg"/>" width="150" height="75"></a></div>
            <div id="headerRight" class="borderColor">
                    
                <div id="topMenu">

                     <security:authorize ifNotGranted="ROLE_GUEST">
                        <span>  
                            <spring:message code="header.welcome.title" text="Welcome!" />
                            <security:authentication property="name" />
                        </span>
                    </security:authorize>
                    <security:authorize ifAnyGranted="ROLE_GUEST">
                        <span><a href="<c:url value="/login/login.htm"/>"><spring:message code="header.topmenu.login" text="Login"/></a></span>
                    </security:authorize>
                        
                    <security:authorize ifNotGranted="ROLE_GUEST">
                        <span class="topMenuText"><a href="<c:url value="/j_spring_security_logout"/>"><spring:message code="header.topmenu.logout" text="Logout"/></a></span>
                        <span class="topMenuText"><a href="<c:url value="/web/admin/admin.htm"/>"><spring:message code="header.topmenu.admin" text="Administration"/></a></span>
                    </security:authorize>

                                     <span class="topMenuText"><a href="<c:url value="/index.htm?language=en"/>">English</a></span>
                                     <span class="topMenuText"><a href="<c:url value="/index.htm?language=es"/>">Espa<span>&ntilde</span>ol</a></span>

                </div>
                Address:
                City:
                Phone Number:
                Fax:
                
             </div>
            <div id="headerLine"></div>
        </div>
        <!-- End Header -->
                
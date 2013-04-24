<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="admin.title" text="Administration" /></title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">

        Admin
        <security:authorize ifAnyGranted="ROLE_ADMIN_USERS">
            <br />
            <span class="topMenuText"><a href="<c:url value="/web/admin/users/managerUsers.htm"/>"><spring:message code="admin.users" text="User Administration" /></a></span>
        </security:authorize>
        
        <security:authorize ifAnyGranted="ROLE_ADMIN_AUTOS">
            <br />
            <span class="topMenuText"><a href="<c:url value="/web/admin/autos/managerAutos.htm"/>"><spring:message code="admin.autos" text="Auto Administration" /></a></span>
        
        </security:authorize >

	       <security:authorize ifAnyGranted="ROLE_ADMIN_AUTOSPEC">
        	    <br />
            <span class="topMenuText"><a href="<c:url value="/web/admin/autospec/managerAutoSpec.htm"/>"><spring:message code="admin.autosspec" text="Auto Specifications Administration" /></a></span>
        
        </security:authorize >
	


    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

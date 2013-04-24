<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />
    <div id="content" class="borderColor">
        Error Page
        <div class="error">
            <c:if test="${not empty param.error}">
                    Login error. <br />
                    Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </c:if>
        </div>

    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Auto</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">
        <h1>
            <c:out value="${successMessage}" escapeXml="true"/>
        </h1>
        <a href="managerAutos.htm">Return to User Administration</a>




    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

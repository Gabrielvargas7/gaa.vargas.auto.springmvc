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

       
        ${autoid}
        ${operation}
        <c:out value="${errorMessage}" />


    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

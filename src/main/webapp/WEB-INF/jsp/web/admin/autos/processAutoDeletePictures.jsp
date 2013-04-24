<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Auto</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">

        <div >
        <h2>Change Auto</h2>
        <form method="post" action="processAutoDeletePictures.htm" >
            <ul >
                <li><label>Auto Id:</label>
                    <input id="autoid" title="autoid" type="text" readonly="readonly" name="autoid" maxlength="30"
                         value="<c:out value="${auto.autoid}" escapeXml="true"/>" />
                </li>

                <c:forEach var="picture" items="${pictures}" >
                    <li>
                        <img src="<c:url value="/images/autos/"></c:url><c:out value="${picture}"/>"  width="100" height="75" >
                        <c:out value="${picture}"/>
                        <input type="checkbox" name="picture" value="<c:out value="${picture}"/>" />
                    </li>
                
                </c:forEach>

            </ul>

            <ul>
        
                <li><label for="deletepicture"></label>
                        <input id="deletepicture" title="deletepicture" type="submit" value="Delete Picture" name="deletepicture" />
                </li>
            </ul>

        </form>
        </div>



    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

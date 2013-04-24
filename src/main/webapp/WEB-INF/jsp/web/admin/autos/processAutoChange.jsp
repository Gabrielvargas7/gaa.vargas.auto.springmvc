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
        <form method="post" action="processAutoChange.htm" >
            <ul >
                 <li><label>Auto Id:</label>
                    <input id="autoid" title="autoid" type="text" readonly="readonly" name="autoid" maxlength="30"
                         value="<c:out value="${auto.autoid}" escapeXml="true"/>" />
                </li>
                <li><label>Brand:</label>
                    <input id="brand" title="brand" type="text" name="brand" maxlength="30"
                         value="<c:out value="${auto.brand}" escapeXml="true"/>" />
                         <c:out value="${mbrand}" escapeXml="true"/>
                    <em class="error" id="mbrand"></em>
                </li>
                <li><label for="model">Model: </label>
                    <input id="model" title="model" type="text" name="model" maxlength="30"
                           value="<c:out value="${auto.model}" escapeXml="true"/>"/>
                    <c:out value="${mmodel}" escapeXml="true"/>
                    <em class="error" id="mmodel"> </em>
                </li>
                <li><label for="year">Year: </label>
                    <input id="year" title="year" type="text" name="year" maxlength="30"
                           value="<c:out value="${auto.year}" escapeXml="true"/>"/>
                            <c:out value="${myear}" escapeXml="true"/>
                    <em class="error" id="myear"> </em>
                </li>
                <li><label for="price">Price: </label>
                    <input id="price" title="price" type="text" name="price" maxlength="50"
                           value="<c:out value="${auto.price}" escapeXml="true"/>"/>
                    <c:out value="${mprice}" escapeXml="true"/>
                    <em class="error" id="mprice"> </em>
                </li>

                <li><label for="miles">Miles: </label>
                    <input id="miles" title="miles" type="text" name="miles" maxlength="50"
                           value="<c:out value="${auto.miles}" escapeXml="true"/>"/>
                    <c:out value="${mmiles}" escapeXml="true"/>
                    <em class="error" id="mmiles"> </em>
                </li>
                <li><label for="sold">Sold: </label>
                    <input id="sold" title="sold" type="checkbox" name="sold" value="sold" <c:out value="${soldchecked}"/> />
                </li>
            </ul>

            <table>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Specifications</th>
                </tr>
                <c:forEach var="spec" items="${specs}" >
                <tr>
                    <td><input type="checkbox" name="spec"
                               value="<c:out value="${spec.specid}"/>"
                               <c:out value="${spec.checked}"/>/>
                    </td>
                    <td><c:out value="${spec.name}"/></td>
                    <td><c:out value="${spec.spec}"/></td>
                </tr>
                </c:forEach>
            </table>
            <ul>
        
                <li><label for="changeauto"></label>
                        <input id="changeauto" title="changeauto" type="submit" value="Change auto Info " name="chengeauto" />
                </li>
            </ul>

        </form>
        </div>



    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

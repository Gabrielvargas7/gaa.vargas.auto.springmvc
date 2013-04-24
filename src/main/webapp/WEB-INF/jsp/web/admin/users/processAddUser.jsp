<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">

        <div >
        <h2>Add User</h2>
        <form method="post" action="createUser.htm">
            <ul >

                <li><label>First Name:</label>
                    <input id="firstname" title="firstname" type="text" name="firstname" maxlength="30"
                         value="<c:out value="${user.firstname}" escapeXml="true"/>" />
                         <c:out value="${mfirstname}" escapeXml="true"/>
                    <em class="error" id="mfirstname"></em>
                </li>
                <li><label for="lastname">Last Name: </label>
                    <input id="lastname" title="lastname" type="text" name="lastname" maxlength="30"
                           value="<c:out value="${user.lastname}" escapeXml="true"/>"/>
                    <c:out value="${mlastname}" escapeXml="true"/>
                    <em class="error" id="mlastname"> </em>
                </li>
                <li><label for="email">Email: </label>
                    <input id="email" title="email" type="text" name="email" maxlength="30"
                           value="<c:out value="${user.username}" escapeXml="true"/>"/>
                            <c:out value="${memail}" escapeXml="true"/>
                    <em class="error" id="memail"> </em>
                </li>
                <li><label for="password">Password: </label>
                    <input id="password" title="password" type="password" name="password" maxlength="20"/>
                   <c:out value="${mpassword}" escapeXml="true"/>
                    <em class="error" id="mpassword"> </em>
                </li>
                <li><label for="address">Address: </label>
                    <input id="address" title="address" type="text" name="address" maxlength="50"
                           value="<c:out value="${user.address}" escapeXml="true"/>"/>
                    <c:out value="${maddress}" escapeXml="true"/>
                    <em class="error" id="maddress"> </em>
                </li>
                <li><label for="city">City: </label>
                    <input id="city" title="city" type="text" name="city" maxlength="50"
                           value="<c:out value="${user.city}" escapeXml="true"/>"/>
                    <c:out value="${mcity}" escapeXml="true"/>
                    <em class="error" id="mcity"> </em>
                </li>
                <li><label for="state">State: </label>
                    <input id="state" title="state" type="text" name="state" maxlength="30"
                           value="<c:out value="${user.state}" escapeXml="true"/>"/>
                    <c:out value="${mstate}" escapeXml="true"/>
                    <em class="error" id="mstate"> </em>
                </li>
                <li><label for="zip">Zip: </label>
                    <input id="zip" title="zip" type="text" name="zip" maxlength="10"
                           value="<c:out value="${user.zip}" escapeXml="true"/>"/>
                   <c:out value="${mzip}" escapeXml="true"/>
                    <em class="error" id="mzip"> </em>
                </li>
                <li><label for="cellphone">Cell Phone: </label>
                    <input id="cellphone" title="cellphone" type="text" name="cellphone" maxlength="20"
                           value="<c:out value="${user.phone1}" escapeXml="true"/>"/>
                    <c:out value="${mcellphone}" escapeXml="true"/>
                    <em class="error" id="mcellphone"> </em>
                </li>
                <li><label for="homephone">Home Phone: </label>
                    <input id="homephone" title="homephone" type="text" name="homephone" maxlength="20"
                           value="<c:out value="${user.phone2}" escapeXml="true"/>"/>
                    <c:out value="${mhomephone}" escapeXml="true"/>
                    <em class="error" id="mhomephone"> </em>
                </li>
            </ul>
            <table>
                <tr>
                    <th>Roles</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="role" items="${authoritiestypes}" >
                <tr>
                    <td><input type="checkbox" name="authorities" 
                               value="<c:out value="${role.authority}"/>"
                               <c:out value="${role.checked}"/>/>

                    </td>
                    <td><c:out value="${role.authority}"/></td>
                    <td><c:out value="${role.description}"/></td>
                 
                </tr>
                </c:forEach>
            </table>
            

            

            <ul>
            <li><label for="createuser"></label>
                    <input id="createuser" title="createuser" type="submit" value="Create the user " name="createuser" />
            </li>
            </ul>

        </form>
        </div>
    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

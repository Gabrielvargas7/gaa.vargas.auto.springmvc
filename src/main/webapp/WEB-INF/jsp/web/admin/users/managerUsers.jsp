<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">

    <div class="top-title">
        <h1>
            User Administration
        </h1>
    </div>
    <div>
        <h3>What do you want to do</h3>

        <form action="processUser.htm" method="post">
          

            <h3>Select the User</h3>
            <div id="disableradio">
            <table>
                <tr>
                    <th>Select</th>
                    <th><a href="managerUsers.htm?value=firstname" />First Name</th>
                    <th><a href="managerUsers.htm?value=lastname" />Last Name</th>
                    <th><a href="managerUsers.htm?value=username" />Email</th>
                    <th><a href="managerUsers.htm?value=address" />Address</th>
                    <th><a href="managerUsers.htm?value=city" />City</th>
                    <th><a href="managerUsers.htm?value=state" />State</th>
                    <th><a href="managerUsers.htm?value=zip" />Zip</th>
                    <th><a href="managerUsers.htm?value=phone1" />Phone</th>
                    <th><a href="managerUsers.htm?value=phone2" />Phone</th>
                    <th><a href="managerUsers.htm?value=enabled" />Enabled</th>


                </tr>

                <c:forEach var="user" items="${users}" >
                <tr>
                    <c:if test="${user.enabled==1}" >
                    <td><input type="radio" name="userid" value="<c:out value="${user.userid}"/>"/></td>
                    <td><c:out value="${user.firstname}"/></td>
                    <td><c:out value="${user.lastname}"/></td>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.address}"/></td>
                    <td><c:out value="${user.city}"/></td>
                    <td><c:out value="${user.state}"/></td>
                    <td><c:out value="${user.zip}"/></td>
                    <td><c:out value="${user.phone1}"/></td>
                    <td><c:out value="${user.phone2}"/></td>
                    <td>Enabled</td>

                    </c:if>
                    <c:if test="${user.enabled==0}" >
                    <td><input type="radio" name="userid" value="<c:out value="${user.userid}"/>"/></td>
                    <td class="error"><c:out value="${user.firstname}"/></td>
                    <td class="error"><c:out value="${user.lastname}"/></td>
                    <td class="error"><c:out value="${user.username}"/></td>
                    <td class="error"><c:out value="${user.address}"/></td>
                    <td class="error"><c:out value="${user.city}"/></td>
                    <td class="error"><c:out value="${user.state}"/></td>
                    <td class="error"><c:out value="${user.zip}"/></td>
                    <td class="error"><c:out value="${user.phone1}"/></td>
                    <td class="error"><c:out value="${user.phone2}"/></td>
                    <td class="error">Diasable</td>
                    </c:if>
                </tr>
             </c:forEach>
            </table>
            </div>

            <input type="submit" name="operation" value="add"    id="add" />
            <input type="submit" name="operation" value="change" id="change" />
            <input type="submit" name="operation" value="disable" id="disable" />
            <input type="submit" name="operation" value="enabled" id="enabled" />

            <input type="submit" name="operation" value="change password" id="changepassword" />

        </form>
    </div>
    
    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

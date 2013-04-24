<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change User Password </title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">

        <div >
        <h2>Change User Password</h2>
        <form method="post" action="changePasswordUser.htm">
            <ul >

                <li><label>First Name:</label>
                    <c:out value="${user.firstname}" escapeXml="true"/>
                </li>
                <li><label for="lastname">Last Name: </label>
                    <c:out value="${user.lastname}" escapeXml="true"/>
                </li>
                <li><label for="email">Email: </label>
                    <c:out value="${user.username}" escapeXml="true"/>
                </li>
                <li><label for="password">New Password: </label>
                    <input id="password" title="password" type="password" name="password" maxlength="20"/>
                   <c:out value="${mpassword}" escapeXml="true"/>
                    <em class="error" id="mpassword"> </em>
                </li>
            </ul>
            <ul>
            <li><label for="changeuser"></label>
                    <input id="changeuser" title="changeuser" type="submit" value="Change Password" name="changeuser" />
                    <input id="userid" title="userid" type="hidden" value="<c:out value="${user.userid}"/>" name="userid" />

            </li>
            </ul>

        </form>
        </div>



    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

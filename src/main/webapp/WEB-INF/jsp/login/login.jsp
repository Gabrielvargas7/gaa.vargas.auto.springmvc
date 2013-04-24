<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>

    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    
    <div id="login">
        <div class="error">
            <c:if test="${not empty param.error}">
                    Login error. <br />
                    Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </c:if>
        </div>    
             <div id="linelogin">
                 <form method="POST" action="<c:url value="/j_spring_security_check" />">
                     
                        <label for="user">Username:</label>
                        <br />
                        <input type="text" name="j_username" />
                        <br />
                        <label for="pass">Password:</label>
                        <br />
                        <input type="password" name="j_password" />
                        <br />
                        <input type="submit" value="Login" />
                
                    </form>

             </div>

    </div>
  
   <c:import url="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>

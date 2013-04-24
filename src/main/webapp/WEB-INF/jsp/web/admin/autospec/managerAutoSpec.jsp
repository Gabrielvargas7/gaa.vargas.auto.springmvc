<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Auto Specification</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="content" class="borderColor">

        <div >
        <h2>Add Auto Specification</h2>
        
            
        
        <form method="post" action="processAutoSpec.htm" >
			<h3>Specification Availables</h3>         
            <table>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Specifications</th>
                </tr>
                <c:forEach var="spec" items="${specs}" >
                <tr>
                    <td><input type="radio" name="spec"
                               value="<c:out value="${spec.specid}"/>"/>
                    </td>
                
                    <td><c:out value="${spec.name}"/></td>
                    <td><c:out value="${spec.spec}"/></td>
                </tr>
                </c:forEach>
            </table>
            <ul>
                <li><label for="addautospec"></label>
                        <input id="addautospec" title="addautospec" type="submit" value="add new specification" name="operation" />
                </li>
                <li><label for="deleteautospec"></label>
                        <input id="deleteautospec" title="deleteautospec" type="submit" value="delete a specification" name="operation" />
                </li>
            
                
            </ul>

        </form>
        </div>



    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

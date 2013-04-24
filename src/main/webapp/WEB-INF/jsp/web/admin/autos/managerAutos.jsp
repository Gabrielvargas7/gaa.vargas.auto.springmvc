<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Auto</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />
        <div id="content" class="borderColor">

    <div class="top-title">
        <h1>
            Auto Administration
        </h1>
    </div>
    <div>
        <h3><a href="managerAutos.htm?value=pre" ><<<----</a>
        <a href="managerAutos.htm?value=next"  > ---->>></a></h3>
        <form action="processAuto.htm" method="post">
        <div id="disableradio">
            <table>
                <tr>
                    <th>Select</th>
                    <th><a href="managerAutos.htm?value=autoid" />Auto Id</th>
                    <th><a href="managerAutos.htm?value=brand" />Brand</th>
                    <th><a href="managerAutos.htm?value=model" />Model</th>
                    <th><a href="managerAutos.htm?value=year" />Year</th>
                    <th><a href="managerAutos.htm?value=price" />Price</th>
                    <th><a href="managerAutos.htm?value=miles" />Miles</th>
                    <th><a href="managerAutos.htm?value=sold" />Sold</th>
                    <th><a href="managerAutos.htm?value=createddate" />Created Date</th>
                </tr>


                <c:forEach var="auto" items="${autos}" >
                <tr>
                    <c:if test="${auto.enabled==1}" >

                        <td><input type="radio" name="autoid" value="<c:out value="${auto.autoid}"/>"/></td>
                        <td><c:out value="${auto.autoid}" /></td>
                        <td><c:out value="${auto.brand}"/></td>
                        <td><c:out value="${auto.model}"/></td>
                        <td><c:out value="${auto.year}"/></td>
                        <td><c:out value="${auto.price}"/></td>
                        <td><c:out value="${auto.miles}"/></td>
                        <td class="soldAdmin"><c:out value="${auto.sold}"/></td>
                        <td><c:out value="${auto.createddate}"/></td>
                        <td>Enabled</td>

                        <c:forEach var="picture" items="${auto.pictures}" >
                            <td><img src="<c:url value="/images/autos/"/><c:out value="${picture}"/>"  width="100" height="75" ></td>
                        </c:forEach>

                    </c:if>
                    <c:if test="${auto.enabled==0}" >
                        <td><input type="radio" name="autoid" value="<c:out value="${auto.autoid}"/>"/></td>
                        <td><c:out value="${auto.autoid}"/></td>
                        <td><c:out value="${auto.brand}"/></td>
                        <td><c:out value="${auto.model}"/></td>
                        <td><c:out value="${auto.year}"/></td>
                        <td><c:out value="${auto.price}"/></td>
                        <td><c:out value="${auto.miles}"/></td>
                        <td><c:out value="${auto.sold}"/></td>
                        <td><c:out value="${auto.createddate}"/></td>
                        <td class="error">Diasable</td>
                        <c:forEach var="picture" items="${auto.pictures}" >
                            <td><img src="<c:url value="/images/autos/"/><c:out value="${picture}"/>"  width="100" height="75" ></td>
                        </c:forEach>

                    </c:if>
                </tr>
             </c:forEach>
            </table>
            </div>


   			<input type="submit" name="operation" value="change information" id="changeinfo" />
            <input type="submit" name="operation" value="delete picture" id="deletepic" />
            <input type="submit" name="operation" value="add picture" id="addpic" />
            <input type="submit" name="operation" value="disable" id="disable" />
            <input type="submit" name="operation" value="enabled" id="enabled" />
         	<h3>Add a car</h3>
            <input type="submit" name="operation" value="add a car" id="add" />
            <h3>Show Cars</h3>
            <input type="submit" name="operation" value="show disable" id="showdisable" />
            <input type="submit" name="operation" value="show enabled" id="showenabled" />
          	<h3>Add a new specification for all cars</h3>
            <input type="submit" name="operation" value="add a spec" id="add" />
            


            




        </form>
    </div>

    </div>



    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

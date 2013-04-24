<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auto Details</title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />
        <script src="<c:url value="/js/utils.js"/>" type="text/javascript"></script>
</head>

<body>
    <c:import url="/WEB-INF/jsp/includes/header.jsp" />

    <div id="detailsWrapper">
      <div id="autoDetailsColum1"> 
       
		<span>ID#:</span><c:out value="${auto.autoid}"></c:out> 
    	<span>Brand:</span><c:out value="${auto.brand}"></c:out>  
    	<span>Model:</span><c:out value="${auto.model}"></c:out>  
    	<span>Miles:</span><c:out value="${auto.miles}"></c:out>  
 		<span>Year:</span><c:out value="${auto.year}"></c:out>   
      	<span>Price:$</span><c:out value="${auto.price}"></c:out>  
        <c:forEach  var="sp" items="${spec}"> 
        	<c:out value="${sp.name}"></c:out><span>:</span>
        	<c:out value="${sp.spec}"></c:out> 
        </c:forEach>
      </div>
       
      <div id="autoDetailsColum2"> 
           <img id="bigPic" src="<c:url value="/images/autos/"></c:url><c:out value="${auto.autoid}"/>_main.jpg"  width="500" height="375" >
           
           <div id="smallPic">
           	<c:forEach var="picture" items="${pictures}">           	
 	             	   <img src="<c:url value="/images/autos/"></c:url><c:out value="${picture}"/>"  width="75" height="50" >
 	       	</c:forEach>
           </div>           
      </div>
      <div id="autoDetailsColumClear"></div>

    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />

</body>

<script src="<c:url value="/js/autoDetails.js"/>" type="text/javascript"></script>

</html>

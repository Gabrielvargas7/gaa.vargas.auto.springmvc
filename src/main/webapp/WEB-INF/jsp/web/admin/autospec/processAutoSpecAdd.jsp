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
        
            
        
        <form method="post" action="processAutoSpecAdd.htm" >
            <label>Add one or more Specification</label>
            <ul >
            	<li>
   					<label>Name</label>
   					<label>Specification</label>         	
            	</li>
                <li>
                    <input id="namespec1" title="namespec1" type="text" name="namespec1" maxlength="30"/>
                    <input id="spec1" title="spec1" type="text" name="spec1" maxlength="30"/>
                </li>
                <li>
                    <input id="namespec2" title="namespec2" type="text" name="namespec2" maxlength="30"/>
               	    <input id="spec2" title="spec2" type="text" name="spec2" maxlength="30"/>
            
                </li>
                <li>
                    <input id="namespec3" title="namespec3" type="text" name="namespec3" maxlength="30"/>
               	    <input id="spec3" title="spec3" type="text" name="spec3" maxlength="30"/>
            
                </li>
            
	    
                <li><label for="createautospec"></label>
                        <input id="createautospec" title="createautospec" type="submit" value="Create Specifications" name="createautospec" />
                </li>
    		</ul>
        </form>
        </div>



    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

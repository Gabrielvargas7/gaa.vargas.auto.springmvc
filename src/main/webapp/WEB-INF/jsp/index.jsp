<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="index.title" text="My Car Dealer WebSite" /></title>
        <c:import url="/WEB-INF/jsp/includes/header_css_js.jsp" />

    </head>
    <body>
       <c:import url="/WEB-INF/jsp/includes/header.jsp" />
        <!-- Content -->
 <div id="wrapper">
 <div id="sortAutoMenu">
  	<h3>
      <a href="index.htm?frontend_value=pre" > <<<<--------- </a>
      <a href="index.htm?frontend_value=brand"> Brand </a>
      <a href="index.htm?frontend_value=model"> Model </a>
      <a href="index.htm?frontend_value=year">  Year </a>
      <a href="index.htm?frontend_value=price"> Price </a>
	  <a href="index.htm?frontend_value=miles"> Miles </a>
	  <a href="index.htm?frontend_value=next"> --------->>>> </a>	  
	</h3>
 </div>	
 <div id="filterAutoMenu">
	<span class="colorAutoValue">Filter By:</span>
	<br></br>
		<span class="autoFilterMenu"><a href="index.htm?filter_value=all_autos">All Autos &nbsp</a></span>
		<c:forEach var="brand" items="${brands}"> 
	 		<span class="autoFilterMenu">
	  			<a  href="index.htm?filter_value=<c:out value="${brand}"></c:out>"><c:out value="${brand}"></c:out>&nbsp</a>
	 		</span>
	 	</c:forEach>
	 
	 
	
	 <br></br>
  </div>	
    <div id="section1">
    
    
        <div id="column1">
         <!--  Column One Content -->
         <c:if test="${autoid_1!=null}">
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_1}"></c:out>">
           	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_1}"/>" width="150" height="100"  alt=""/>
           </a>
           <br ></br>
           <span></span><span class="colorAutoValue"><c:out value="${autoid_1}"></c:out></span>
		   <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_1}"></c:out></span>
		   <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_1}"></c:out></span>
		   <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_1}"></c:out></span>
		   <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_1}"></c:out></span>
		   <span class="colorAutoField">&nbsp </span><span class="colorAutoValue"> <c:out value="${year_1}"></c:out></span>
			<span class="sold" ><c:out value="${sold_1}"></c:out></span>
		 </c:if>
		   
	    <c:if test="${autoid_5!=null}">
	       <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_5}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_5}"/>" width="150" height="100"  alt=""/>
           </a>
           <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_5}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_5}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${model_5}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${miles_5}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${price_5}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${year_5}"></c:out></span>
    	   <span class="sold" >
		   		<c:out value="${sold_5}"></c:out>
		   </span>
        </c:if>
        
        <c:if test="${autoid_9!=null}">   
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_9}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_9}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	   <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_9}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_9}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${model_9}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_9}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_9}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_9}"></c:out></span>
       	   <span class="sold" >
		   		<c:out value="${sold_9}"></c:out>
		   </span>
	 	</c:if>
        </div>

        <div id="column2">
           <!--  Column Two Content -->
        <c:if test="${autoid_2!=null}">    
		   <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_2}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_2}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	   <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_2}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${brand_2}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_2}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_2}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_2}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_2}"></c:out></span>
   		   <span class="sold" >
		   		<c:out value="${sold_2}"></c:out>
		   </span>		   
        </c:if>
        
        <c:if test="${autoid_6!=null}">	
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_6}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_6}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	 	<br ></br>           
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_6}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${brand_6}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_6}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_6}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_6}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_6}"></c:out></span>
           <span class="sold" ><c:out value="${sold_6}"></c:out></span>
      	</c:if>
      	
      	<c:if test="${autoid_10!=null}">
      	   <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_10}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_10}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	    <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_10}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_10}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_10}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_10}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_10}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_10}"></c:out></span>
           <span class="sold" ><c:out value="${sold_10}"></c:out></span>
       </c:if>
        </div>

    </div>

    <div id="section2">

        <div id="column3">
        <!--  Column Three Content -->
		<c:if test="${autoid_3!=null}">
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_3}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_3}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	     <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_3}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_3}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_3}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_3}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_3}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_3}"></c:out></span>
            <span class="sold" ><c:out value="${sold_3}"></c:out></span>
        </c:if>
        
        <c:if test="${autoid_7!=null}">   
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_7}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_7}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	   <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_7}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_7}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_7}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_7}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_7}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_7}"></c:out></span>
	      <span class="sold" ><c:out value="${sold_7}"></c:out></span>
         </c:if>
     
		 <c:if test="${autoid_11!=null}"> 
		   <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_11}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_11}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	   <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_11}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_11}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_11}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_11}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_11}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_11}"></c:out></span>
           <span class="sold" ><c:out value="${sold_11}"></c:out></span>
         </c:if>
        </div>

        <div id="column4">
        <!--  Column Four Content -->
        <c:if test="${autoid_4!=null}">
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_4}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_4}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	     <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_4}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_4}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_4}"></c:out></span>
	       <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_4}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_4}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_4}"></c:out></span>
           <span class="sold" ><c:out value="${sold_4}"></c:out></span>
      	</c:if>
      		
      	<c:if test="${autoid_8!=null}">
  		   <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_8}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_8}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	   <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_8}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_8}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_8}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_8}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_8}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_8}"></c:out></span>
            <span class="sold" ><c:out value="${sold_8}"></c:out></span>
        </c:if>
        
 		<c:if test="${autoid_12!=null}">	       
           <a href="web/frontend/autoDetails.htm?autoid=<c:out value="${autoid_12}"></c:out>">
    	   	<img src="<c:url value="/images/autos/"/><c:out value="${mainpicture_12}"/>" width="150" height="100"  alt=""/>
    	   </a>
    	   <br ></br>
           <span></span><span class="colorAutoValue"> <c:out value="${autoid_12}"></c:out></span>
           <span class="colorAutoField" >&nbsp</span><span class="colorAutoValue"> <c:out value="${brand_12}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${model_12}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${miles_12}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${price_12}"></c:out></span>
           <span class="colorAutoField" >&nbsp </span><span class="colorAutoValue"> <c:out value="${year_12}"></c:out></span>
              <span class="sold" ><c:out value="${sold_12}"></c:out></span>
     
       </c:if>
        </div>

    </div>

    <div id="clearcolumns">
     </div>


</div>
        
       
        <!-- End Content -->
      
        <c:import url="/WEB-INF/jsp/includes/footer.jsp" />        
    </body>

</html>

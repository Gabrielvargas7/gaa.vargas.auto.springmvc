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

        <div >
        <h2>Add Auto Pictures</h2>
        <form method="post" action="processAutoAddPictures.htm" enctype="multipart/form-data">
            <li>Select Main Picture<input type="file" name="mainpicture" value="" /></li>
            <li>Select Extra Picture<input type="file" name="picture" value="" /></li>
            <li>Select Extra Picture<input type="file" name="picture" value="" /></li>
            <li>Select Extra Picture<input type="file" name="picture" value="" /></li>
            <li>Select Extra Picture<input type="file" name="picture" value="" /></li>
            <li>Select Extra Picture<input type="file" name="picture" value="" /></li>
            <li><label for="addpicture"></label>
                <input id="addpicture" title="addpicture" type="submit" value="Add Picture " name="addpicture" />
            </li>

     
        </form>
        </div>



    </div>
    <c:import url="/WEB-INF/jsp/includes/footer.jsp" />


</body>
</html>

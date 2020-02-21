
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<section style="padding":10px; min-height: 400px;"></section>

<h1>WELCOME to COGNIZANT</h1>
<h2>${pageTitle }</h2>
<h1>developers</h1>
<ol>
   <c:forEach var="d" items="${developers}">
   <h3><li>${d}</li></h3>
   </c:forEach>
</ol>
</body>

</html>
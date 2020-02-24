


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<jsp:include page="/header" />

<section style="padding: 10px; min-height: 400px;">

	<h2>${pageTitle}</h2>
	<h3>developers</h3>

	<c:forEach var="d" items="${developers}">
		<ol>
			<li>${d}</li>

	   </ol>
		</c:forEach>

</section>



<jsp:include page="/footer" />



<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<jsp:include page="/header" />

<section style="padding: 10px; min-height: 400px;">

	
	
	<h3>Visitor registration </h3>
	<form method="post">
	   		<label> NAME :
	   		<input type="text"  name="firstName"  required/> 
	   		<input type="text" name="lastName"  required/> 
	   		</label><br />
	   		
	   		<label> dateOfBirth:
	   		<input type="date" name="dateOfbirth" required>
	   		</label>
	   		<br />
	   		
	   		<button>REGISTER</button>
	   		
	   		
	
	
	</form>

</section>



<jsp:include page="/footer" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h3>Welcome to Update Pet Home Page</h3>

<form action="updatePetPath" method="post">
	
	<!-- Select Species:<select name="frmSpeciesId">
		<option value="0">SELECT</option>
		<c:forEach var="l" items="${requestScope.mySpeciesForm.frmSpeciesList}">
			<option value="${l.speciesId}">${l.speciesName}</option>
		</c:forEach>
	</select><br> -->
	<input type="hidden"
		name="frmOwnerId" value="${requestScope.frmOwnerId}" />
	<input type="hidden"
		name="frmSpeciesId" value="${requestScope.frmSpeciesId}" />
	<input type="hidden"
		name="frmPetId" value="${requestScope.frmPetId}" />
	<input
		type="hidden" name="frmOwnerId"
		value="${requestScope.myPetForm.frmOwner.ownerId}"/>
	<input
		type="hidden" name="frmSpeciesId"
		value="${requestScope.myPetForm.frmSpecies.speciesId}"/>
	Enter Pet Name:<input type='text' name='frmName'/><br>
	Enter Pet Sex:<input type='radio' name="frmSex" value="F">female
	<input type='radio' name="frmSex" value="M">male<br>
				
	Enter Pet Birth Date:<input type='text' name='frmBirthDate'/><br>
	Enter Pet Death Date:<input type='text' name='frmDeathDate'/><br>
	<input type="submit" value="Update"/><br>
</form>

<font color='red'>Owner ID :${requestScope.frmOwnerId}</font><br>
<font color='red'>Species ID :${requestScope.frmSpeciesId}</font><br>
<font color='red'>Pet ID :${requestScope.frmPetId}</font>

<h4><a href="registerSpeciesPath">Go Back</a></h4>

<c:if test="${empty requestScope.myPetForm1.frmPetList}">
	<font color='red'>NO Pet</font>
</c:if>
<c:if test="${not empty requestScope.myPetForm1.frmPetList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>Pet Sex</th>
			<th>Pet BirthDate</th>
			<th>Pet DeathDate</th>
		</tr>
		<c:forEach var="p" items="${requestScope.myPetForm1.frmPetList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${p.petId}</td>
				<td>${p.petName}</td>
				<td>${p.petSex}</td>
				<td>
					<f:formatDate value="${p.petBirth}" pattern="dd-MM-yyyy hh:mm:ss a"/>
				</td>
				<td>
					<f:formatDate value="${p.petDeath}" pattern="dd-MM-yyyy hh:mm:ss a"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>


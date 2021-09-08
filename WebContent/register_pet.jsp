<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h3>Welcome to Register Pet Home Page</h3>
<c:if test="${(sql!='update')}">
<form action="registerPetPath" method="post" enctype="multipart/form-data">
	Select Species:
	<select name="frmSpeciesId">
		<option value="0">SELECT</option>
		<c:forEach var="l" items="${requestScope.mySpeciesForm.frmSpeciesList}">
			<option value="${l.speciesId}">${l.speciesName}</option>
		</c:forEach>
	</select><br>
	<input type="hidden"
		name="frmOwnerId" value="${requestScope.frmOwnerId}" />
	Enter Pet Id:<input type='text' name='frmId'/><br>
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
		Select your file:<input type="file" name="frmFile"/><br>
	<input type="submit" value="SAVE"/><br>
</form>
</c:if>
<font color='red'>Owner ID :${requestScope.frmOwnerId}</font><br>
<font color='red'>Pet ID :${requestScope.myPetForm.frmId}</font>

<h4><a href="registerSpeciesPath">Go Back</a></h4>

<c:if test="${empty requestScope.myPetForm.frmPetList}">
	<font color='red'>NO Pet</font>
</c:if>
<c:if test="${not empty requestScope.myPetForm.frmPetList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Owner Id</th>
			<th>Owner Name</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>Pet Sex</th>
			<th>Pet BirthDate</th>
			<th>Pet DeathDate</th>
			<th>Species Id</th>
			<th>Species Name</th>
			<th></th>
		</tr>
		<c:forEach var="p" items="${requestScope.myPetForm.frmPetList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${p.owner.ownerId}</td>
				<td>${p.owner.ownerName}</td>
				<td>${p.petId}</td>
				<td>${p.petName}</td>
				<td>${p.petSex}</td>
				<td>
					<f:formatDate value="${p.petBirth}" pattern="dd-MM-yyyy hh:mm:ss a"/>
				</td>
				<td>
					<f:formatDate value="${p.petDeath}" pattern="dd-MM-yyyy hh:mm:ss a"/>
				</td>
				<td>${p.species.speciesId}</td>
				<td>${p.species.speciesName}</td>
				<td>
					<a href=
						"updatePetPath?oId=${p.owner.ownerId}&
						sId=${p.species.speciesId}&pId=${p.petId}">
						Update Pet
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>


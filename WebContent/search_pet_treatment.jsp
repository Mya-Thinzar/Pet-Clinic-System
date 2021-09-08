<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<form action="searchPetTreatmentPath" method="post">
	<input type="hidden" name="frmDoctorId" value="${requestScope.frmDoctorId}"/>
	Choose Pet for Treatment
	 <select name="frmPetId">
		<option value="0">SELECT</option>
		<c:forEach var="l" items="${requestScope.myPetForm1.frmPetList}">
			<option value="${l.petId}">${l.petId}</option>
		</c:forEach>
	 </select><br> 
	 <input type="submit" value="OK"/>
</form>
<br>
<font color='red'>Doctor ID :${requestScope.frmDoctorId}</font><br>
<font color='red'>Drug ID :${requestScope.myDrugTypeForm.frmDrugId}</font><br>

<c:if test="${empty requestScope.myPetForm.frmPetList}">
	<font color='red'>NO Pet</font>
</c:if>
<c:if test="${not empty requestScope.myPetForm.frmPetList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>SpeciesName</th>
			<th>Pet Sex</th>
			<th>Pet BirthDate</th>
			<th>Owner Name</th>
			<th>Owner Phone</th>
			<th>Owner Email</th>
			<th>Owner Id</th>
			<th>Appointment Id</th>
			<th>Appointment Date</th>
			<th>Appointment Time</th>
			<th></th>
		</tr>
		<c:forEach var="p" items="${requestScope.myPetForm.frmPetList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${p.petId}</td>
				<td>${p.petName}</td>
				<td>${p.species.speciesName}</td>
				<td>${p.petSex}</td>
				<td>
					<f:formatDate value="${p.petBirth}" pattern="dd-MM-yyyy hh:mm:ss a"/>
				</td>
				<td>${p.owner.ownerName}</td>
				<td>${p.owner.ownerPh}</td>
				<td>${p.owner.ownerEmail}</td>							
				<td>${p.owner.ownerId}</td>
				<td>${p.appointment.appId}</td>
				<td>
					<f:formatDate value="${p.appointment.appDate}" pattern="dd-MM-yyyy hh:mm:ss a"/>
				</td>
				<td>${p.appointment.appTime}</td>

				<td><a href="registerPetDrugPath?frmPetId=${p.petId}&frmDoctorId=${requestScope.frmDoctorId}&frmControl=petTreatment">Create Pet Treatment Record</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
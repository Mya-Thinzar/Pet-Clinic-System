<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h3>Enter New Drug Type</h3>
<form action="registerDrugTypePath" method="post">
	<input type="hidden"
		name="frmDoctorId" value="${requestScope.frmDoctorId}" />
	Enter Drug Name:<input type='text' name='frmName'/><br>
	Enter Drug Duration:<input type='text' name='frmDuration'/><br>
	 Select Drug Duration Type:
	 <select name="frmDurationType">
		<option value="0">SELECT</option>
		<option value="year">year</option>
		<option value="month">month</option>
		<option value="day">day</option>
	 </select><br>	
	 <input type="submit" value="Save"/>
</form>
<br>
<font color='red'>Doctor ID :${requestScope.frmDoctorId}</font><br>
<font color='red'>Drug ID :${requestScope.myDrugTypeForm.frmDrugId}</font><br>

<c:if test="${empty requestScope.myDrugTypeForm.frmDrugTypeList}">
	<font color='red'>NO Drug Type</font>
</c:if>
<c:if test="${not empty requestScope.myDrugTypeForm.frmDrugTypeList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Drug Id</th>
			<th>Drug Name</th>
			<th>Drug Duration</th>
			<th>Drug Duration Type</th>
		</tr>
		<c:forEach var="d" items="${requestScope.myDrugTypeForm.frmDrugTypeList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${d.drugId}</td>
				<td>${d.drugName}</td>
				<td>${d.drugDuration}</td>
				<td>${d.drugDurationType}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<%-- 
<h3>Click Pet to Treatment below</h3><br>
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
			</tr>
		</c:forEach>
	</table>
</c:if>--%>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
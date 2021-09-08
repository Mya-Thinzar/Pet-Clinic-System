<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<c:if test="${(frmControl!='petHistory') && (frmControl!='drugTime')}">
<h3>Pet Drug Detail</h3>
<form action="registerPetDrugPath" method="post">
	<input type="hidden"
		name="frmDoctorId" value="${requestScope.frmDoctorId}" />
		
	<input type="hidden"
		name="frmPetId" value="${requestScope.frmPetId}" />
	
	<input type="hidden"
		name="frmControl" value="${requestScope.frmControl}" />
			
	Enter Drug Date:<input type='text' name='frmDate'/><br>

	 Select Drug Type:
	 <select name="frmDrugType">
		<option value="0">SELECT</option>
		<c:forEach var="l" items="${requestScope.myDrugTypeForm.frmDrugTypeList}">
			<option value="${l.drugId}">${l.drugName}</option>
		</c:forEach>
	 </select><br> 
	 
	Enter Drug Next Date:<input type='text' name='frmNextDate'/><br>
	Enter Drug Description:<input type='text' name='frmDescription'/><br>

	 <input type="submit" value="Save"/>
</form>
<br>
<font color='red'>Doctor ID :${requestScope.frmDoctorId}</font><br>
<font color='red'>Pet ID :${requestScope.frmPetId}</font><br>
<font color='red'>Drug ID :${requestScope.frmDrugId}</font><br>
<font color='red'>Drug DURATION :${requestScope.frmDrugDuration}</font><br>
<font color='red'>Drug DURATION TYPE:${requestScope.frmDrugDurationType}</font><br>

<br><br>
</c:if>

<c:if test="${(frmControl=='petHistory')}">
<h3>Pet History</h3>
<c:if test="${empty requestScope.myPetHistoryForm.frmPetDrugList}">
	<font color='red'>NO Pet History</font>
</c:if>
<c:if test="${not empty requestScope.myPetHistoryForm.frmPetDrugList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>Pet Sex</th>
			<th>Pet BirthDate</th>
			<th>Drug Name</th>
			<th>Drug Duration</th>
			<th>Drug Duration Type</th>
			<th>Pet Drug Date</th>
			<th>Pet Drug Next Date</th>
			<th>Pet Drug Description</th>
			<th>Doctor Name</th>			
			<th>Doctor Rank</th>			
		</tr>
		<c:forEach var="p" items="${requestScope.myPetHistoryForm.frmPetDrugList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${p.pet.petId}</td>
				<td>${p.pet.petName}</td>
				<td>${p.pet.petSex}</td>
				<td>
					<f:formatDate value="${p.pet.petBirth}" pattern="dd-MM-yyyy"/>
				</td>
				<td>${p.drugType.drugName}</td>
				<td>${p.drugType.drugDuration}</td>
				<td>${p.drugType.drugDurationType}</td>
				<td>
					<f:formatDate value="${p.drugDate}" pattern="dd-MM-yyyy"/>
				</td>
				<td>
					<f:formatDate value="${p.drugNextDate}" pattern="dd-MM-yyyy"/>
				</td>
				<td>${p.drugDesc}</td>
				<td>${p.doctor.doctorName}</td>
				<td>${p.doctor.doctorRank}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</c:if>

<c:if test="${(frmControl=='drugTime')}">
<h3>Check Drug Time</h3>
<c:if test="${empty requestScope.myDrugTimeForm.frmPetDrugList}">
	<font color='red'>NO Drug Time</font>
</c:if>
<c:if test="${not empty requestScope.myDrugTimeForm.frmPetDrugList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>Pet Sex</th>
			<th>Pet BirthDate</th>
			<th>Pet Drug Date</th>
			<th>Pet Drug Next Date</th>
			<th>Pet Drug Description</th>
			<th>Doctor Name</th>			
			<th>Doctor Rank</th>			
		</tr>
		<c:forEach var="p" items="${requestScope.myDrugTimeForm.frmPetDrugList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${p.pet.petId}</td>
				<td>${p.pet.petName}</td>
				<td>${p.pet.petSex}</td>
				<td>
					<f:formatDate value="${p.pet.petBirth}" pattern="dd-MM-yyyy"/>
				</td>
				<td>
					<f:formatDate value="${p.drugDate}" pattern="dd-MM-yyyy"/>
				</td>
				<td>
					<f:formatDate value="${p.drugNextDate}" pattern="dd-MM-yyyy"/>
				</td>
				<td>${p.drugDesc}</td>
				<td>${p.doctor.doctorName}</td>
				<td>${p.doctor.doctorRank}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</c:if>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
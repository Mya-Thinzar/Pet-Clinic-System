<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Welcome to Update doctor Home Page</h3>
<c:if test="${(action!='doctor')}">
<form action="updateDoctorPath" method="post">
	Enter Doctor Name:
		<input type="text" name="frmName" value=""/><br>
	Enter Doctor Rank:
		<input type="text" name="frmRank" value=""/><br>
	<input type="submit" value="Update"/>
	<input type="hidden" name="frmDoctorId" value="${requestScope.frmDid}"/>
</form>
</c:if>
<c:if test="${not empty frmDoctorForm.frmDoctorList}">
<table border="1" width="100%">
	<tr>
		<th>No</th>
		<th>Id</th>
		<th>Name</th>
		<th>Rank</th>
		<c:if test="${(action=='doctor')}">
			<th></th>
		</c:if>			
	</tr>
	<c:forEach var="d" items="${frmDoctorForm.frmDoctorList}" varStatus="s">
		<tr>
			<td>${s.index+1}</td>
			<td>${d.doctorId}</td>
			<td>${d.doctorName}</td>
			<td>${d.doctorRank}</td>
			<c:if test="${(action=='doctor')}">
			<td>
				<a href="updatePwPath?frmId=${d.doctorId}&frmPw=${requestScope.frmDoctorPassword}">Update Password</a>
			</td>
			<td>
				<a href="registerDrugTypePath?frmDoctorId=${d.doctorId}">New Drug Type</a><br>
				<a href="searchPetTreatmentPath?frmDoctorId=${d.doctorId}">Choose Pet For Treatment</a>		
			</td>
			<td>
				<a href="registerPetDrugPath?frmControl=petHistory">View Pet History</a>
			</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</c:if>
<h4><a href="registerDoctorPath">Go Back</a></h4>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
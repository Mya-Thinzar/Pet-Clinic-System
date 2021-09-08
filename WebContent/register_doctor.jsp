<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Welcome to Register doctor Home Page</h3>
<form action="registerDoctorPath" method="post">
	Enter Doctor Id:
		<input type="text" name="frmId" value=""/><br>
	Enter Doctor Name:
		<input type="text" name="frmName" value=""/><br>
	Enter Doctor Rank:
		<input type="text" name="frmRank" value=""/><br>
	Enter Doctor Password:
		<input type="password" name="frmPassword" value=""/><br>
	<input type="submit" value="SAVE"/>
</form>
<c:if test="${not empty frmDoctorForm.frmDoctorList}">
<table border="1" width="100%">
	<tr><th>No</th><th>Id</th><th>Name</th><th>Rank</th>
	<th></th>
	</tr>
	<c:forEach var="d" items="${frmDoctorForm.frmDoctorList}" varStatus="s">
		<tr>
			<td>${s.index+1}</td>
			<td>${d.doctorId}</td>
			<td>${d.doctorName}</td>
			<td>${d.doctorRank}</td>
			<td><a href="updateDoctorPath?frmDoctorId=${d.doctorId}">Update Doctor's Info</a></td>
			<td><a href="registerSchedulePath?frmDoctorId=${d.doctorId}">Manage Schedule</a></td>
		</tr>
	</c:forEach>
</table>
</c:if>
<h4><a href="admin_home.jsp">Go Back</a></h4>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
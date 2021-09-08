<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h3>Appointment Home Page</h3>
<c:if test="${(action!='admin')}">

<font color='red'>${requestScope.frmOwnerId}</font><br>
<c:if test="${empty requestScope.myScheduleForm1.frmScheduleList}">
	<font color='red'>NO Schedule</font>
</c:if>
<c:if test="${not empty requestScope.myScheduleForm1.frmScheduleList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Day Name</th>
			<th>Doctor Name</th>
			<th>Doctor Rank</th>
			<th>Start Time</th>
			<th>End Time</th>
		</tr>
		<c:forEach var="d" items="${requestScope.myScheduleForm1.frmScheduleList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${d.dayName}</td>
				<td>${d.doctor.doctorName}</td>				
				<td>${d.doctor.doctorRank}</td>
				<td>${d.startTime}</td>
				<td>${d.endTime}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
<form action="registerAppPath" method="post">
	<input type="hidden" name="frmOwnerId" value="${requestScope.frmOwnerId}"/>
	 Select Appointment Date:
	<select name="frmAppDate">
		<option value="0">SELECT</option>
			<option value="${requestScope.frmAppDate}">${requestScope.frmAppDate}</option>
	</select><br>
	 Enter Appointment Time(04:00:00 or 06:00:00)pm:
	 <input type="text" name="frmAppTime"/>
	<br><br>
	<input type="submit" value="Save"/><br>
</form>
</c:if>
<c:if test="${(action=='admin')}">
<c:if test="${empty requestScope.myAppForm.frmAppList}">
	<font color='red'>NO Appointment</font>
</c:if>
<c:if test="${not empty requestScope.myAppForm.frmAppList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Owner Name</th>
			<th>Owner Phone</th>
			<th>Owner Email</th>
			<th>Owner Address</th>
			<th>Appointment Date</th>
			<th>Appointment Time</th>
		</tr>
		<c:forEach var="a" items="${requestScope.myAppForm.frmAppList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${a.owner.ownerName}</td>
				<td>${a.owner.ownerPh}</td>
				<td>${a.owner.ownerEmail}</td>
				<td>${a.owner.ownerAdd}</td>
				<td><f:formatDate value="${a.appDate}" pattern="dd-MM-yyyy hh:mm:ss a"/></td>
				<td>${a.appTime}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</c:if>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>


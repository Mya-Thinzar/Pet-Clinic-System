<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h3>Welcome to Register Species Home Page</h3>
<form action="registerSchedulePath" method="post">
	<input type="hidden" name="frmDoctorId" value="${requestScope.frmDoctorId}"/>
	 Select Day:
	  <select name="frmDay">
		<option value="0">SELECT</option>
		<option value="MON">MON</option>
		<option value="TUE">TUE</option>
		<option value="WED">WED</option>
		<option value="THU">THU</option>
		<option value="FRI">FRI</option>
		<option value="SAT">SAT</option>
		<option value="SUN">SUN</option>
	 </select><br>
	 Enter Start Time(04:00:00 or 06:00:00)pm:
	 <input type="text" name="frmStartTime"/><br>
	 Enter End Time(06:00:00 or 08:00:00)pm:
	 <input type="text" name="frmEndTime"/>
	<br><br>
	<input type="submit" value="SAVE" /><br>
</form>
<font color='red'>Doctor ID :${requestScope.frmDoctorId}</font>

<c:if test="${empty requestScope.myScheduleForm.frmScheduleList}">
	<font color='red'>NO Schedule</font>
</c:if>
<c:if test="${not empty requestScope.myScheduleForm.frmScheduleList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Doctor Id</th>
			<th>Doctor Name</th>
			<th>Doctor Rank</th>
			<th>Schedule Id</th>
			<th>Day Name</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th></th>
		</tr>
		<c:forEach var="d" items="${requestScope.myScheduleForm.frmScheduleList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${d.doctor.doctorId}</td>
				<td>${d.doctor.doctorName}</td>
				<td>${d.doctor.doctorRank}</td>
				<td>${d.scheduleId}</td>
				<td>${d.dayName}</td>
				<td>${d.startTime}</td>
				<td>${d.endTime}</td>
				<td><a href="updateSchedulePath?frmDoctorId=${d.doctor.doctorId}&frmScheduleId=${d.scheduleId}">Update Schedule</a>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
<br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
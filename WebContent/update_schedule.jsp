<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h3>Welcome to Update Pet Home Page</h3>

<form action="updateSchedulePath" method="post">

	<input type="hidden"
		name="frmScheduleId" value="${requestScope.frmScheduleId}" />
	<input type="hidden"
		name="frmDoctorId" value="${requestScope.frmDoctorId}" />
	<input
		type="hidden" name="frmDoctorId"
		value="${requestScope.myScheduleForm.frmDoctor.doctorId}"/>
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
	<input type="submit" value="Update"/><br>
</form>

<font color='red'>Doctor ID :${requestScope.frmDoctorId}</font><br>
<font color='red'>Schedule ID :${requestScope.frmScheduleId}</font><br>

<c:if test="${empty requestScope.myScheduleForm1.frmScheduleList}">
	<font color='red'>NO Schedule</font>
</c:if>
<c:if test="${not empty requestScope.myScheduleForm1.frmScheduleList}">
	<table border="1" width="100%">
		<tr>
			<th>No</th>
			<th>Schedule Id</th>
			<th>Day Name</th>
			<th>Start Time</th>
			<th>End Time</th>
		</tr>
		<c:forEach var="d" items="${requestScope.myScheduleForm1.frmScheduleList}"
			varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${d.scheduleId}</td>
				<td>${d.dayName}</td>
				<td>${d.startTime}</td>
				<td>${d.endTime}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>


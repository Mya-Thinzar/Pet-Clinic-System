<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Welcome to Register Admin Home Page</h3>
<c:if test="${(sql!='update')}">
<form action="registerPath" method="post">
	Enter Admin Id:
		<input type="text" name="frmId" value=""/><br>
	Enter Admin Password:
		<input type="password" name="frmPassword" value=""/><br>
	<input type="submit" value="SAVE"/>
</form>
</c:if>
<h4><a href="admin_home.jsp">Go Back</a></h4>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
<c:if test="${not empty myUserForm && (sql!='insert')}">
		<table border="1" width="100%">
			<tr>
				<th>No</th>
				<th>Id</th>
				<th>Password</th>
			</tr>
			<tr>
				<td>1</td>
				<td>${myUserForm.frmId}</td>
				<td>${myUserForm.frmPassword}</td>
				<td><a href="updatePwPath?frmId=${myUserForm.frmId}&frmPw=${myUserForm.frmPassword}">Update Password</a>
			</tr>
		</table>
	</c:if>
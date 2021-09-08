<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Admin Home Page</h3>
${requestScope.myFormLogin.frmId}
${requestScope.myFormLogin.frmPassword}
<table border="1" width="100%">
		<tr>
			<th>Admin</th>
			<th>Doctor</th>
			<th>Owner and Owner's pets</th>	
			<th></th>
		</tr>
			<tr>
				<td>
				<a href="registerPath?id=${requestScope.myFormLogin.frmId}&pw=${requestScope.myFormLogin.frmPassword}&sql=insert">Register Admin</a><br>
				<a href="registerPath?id=${requestScope.myFormLogin.frmId}&pw=${requestScope.myFormLogin.frmPassword}&sql=update">Update Password</a>
				</td>
				<td>
				<a href="registerDoctorPath">Manage Doctor</a>
				</td>
				<td>
				<a href="registerOwnerPath?action=admin">Manage Owner</a>
				</td>
				<td>
				<a href="registerAppPath?action=admin">View Appointment List</a><br>
				<a href="paymentPath">Payment</a>				
				</td>
			</tr>			
</table>
<h4><a href="loginPath">Go Back</a></h4>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
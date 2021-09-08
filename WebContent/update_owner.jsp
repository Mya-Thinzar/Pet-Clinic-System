<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Welcome to Update Owner Home Page</h3>
<form action="updateOwnerPath" method="post">
	<input type="hidden" name="frmOwnerId" value="${requestScope.frmOwnerId}"/>
	Enter Owner Name:<input type='text' name='frmName'/><br>
	Enter Owner Phone:<input type='text' name='frmPhone'/><br>
	Enter Owner Email:<input type='text' name='frmEmail'/><br>
	Enter Owner Address:<input type='text' name='frmAddress'/><br>
	<input type="submit" value="Update"/>
</form>
	<c:if test="${(not empty myOwnerForm.frmOwnerList) && (action!='newMember')}">
		<table border="1" width="100%">
			<tr>
				<th>No</th>
				<th>Id</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
			<c:forEach var="o" items="${myOwnerForm.frmOwnerList}" varStatus="s">
				<tr>
					<td>${s.index+1}</td>
					<td>${o.ownerId}</td>
					<td>${o.ownerName}</td>
					<td>${o.ownerPh}</td>
					<td>${o.ownerEmail}</td>
					<td>${o.ownerAdd}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if><br>
	
<form action="loginPath">
<input type="submit" value="Logout"/>
</form><br>
<h4><a href="registerOwnerPath?action=admin">Go Back</a></h4>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Welcome to Owner Home Page</h3>
<c:if test="${(action!='owner')}">
<form action="registerOwnerPath" method="post" enctype="multipart/form-data">
	Enter Owner Id:<input type='text' name='frmOwnerId'/><br>
	Enter Owner Name:<input type='text' name='frmName'/><br>
	Enter Owner Phone:<input type='text' name='frmPhone'/><br>
	Enter Owner Email:<input type='text' name='frmEmail'/><br>
	Enter Owner Address:<input type='text' name='frmAddress'/><br>
	Enter Owner Password:
		<input type="password" name="frmPassword" value=""/><br>
		Select Species:
	<select name="frmSpeciesId">
		<option value="0">SELECT</option>
		<c:forEach var="l" items="${requestScope.mySpeciesForm.frmSpeciesList}">
			<option value="${l.speciesId}">${l.speciesName}</option>
		</c:forEach>
	</select><br>
	<input type="hidden"
		name="frmOwnerId" value="${requestScope.frmOwnerId}" />
	Enter Pet Id:<input type='text' name='frmId'/><br>
	<input
		type="hidden" name="frmOwnerId"
		value="${requestScope.myPetForm.frmOwner.ownerId}"/>
	<input
		type="hidden" name="frmSpeciesId"
		value="${requestScope.myPetForm.frmSpecies.speciesId}"/>
	Enter Pet Name:<input type='text' name='frmPetName'/><br>
	Enter Pet Sex:<input type='radio' name="frmSex" value="F">female
	<input type='radio' name="frmSex" value="M">male<br>
				
	Enter Pet Birth Date:<input type='text' name='frmBirthDate'/><br>
	Enter Pet Death Date:<input type='text' name='frmDeathDate'/><br>
	Select your file:<input type="file" name="frmFile"/><br>
	<input type="submit" value="SAVE"/><br>
	<input type="hidden" name="action" value="${requestScope.action}"/>
</form>
</c:if>
	<c:if test="${(not empty myOwnerForm.frmOwnerList) && (action!='newMember')}">
		<table border="1" width="100%">
			<tr>
				<th>No</th>
				<th>Id</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="o" items="${myOwnerForm.frmOwnerList}" varStatus="s">
				<tr>
					<td>${s.index+1}</td>
					<td>${o.ownerId}</td>
					<td>${o.ownerName}</td>
					<td>${o.ownerPh}</td>
					<td>${o.ownerEmail}</td>
					<td>${o.ownerAdd}</td>
					<c:if test="${(action!='owner')}">
					<td>
						<a href="registerSpeciesPath?&action=${requestScope.action}&frmOwnerId=${o.ownerId}">Update Species</a>
					</td>
					</c:if>
					<c:if test="${(action=='owner')}">
					<td>
						<a href="updatePwPath?frmId=${requestScope.frmOwnerId}&frmPw=${requestScope.frmOwnerPassword}">Update Password</a>
						<br><a href="registerAppPath?frmOwnerId=${o.ownerId}">Create Appointment</a>
						<br><a href="registerPetDrugPath?frmControl=drugTime&frmOwnerId=${o.ownerId}">Check Drug Time</a>
					</td>
					</c:if>
					<td>
						<a href="registerPetPath?&action=${requestScope.action}&frmOwnerId=${o.ownerId}">Add Pet</a><br>
						<a href="registerPetPath?frmOwnerId=${o.ownerId}&sql=update">Update Pet</a>
					</td>
					<td>
						<a href="updateOwnerPath?frmAction=updateOwner&frmOwnerId=${o.ownerId}">Update Owner's Info</a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
<c:if test="${(action=='owner')}">
	<font color="red">${requestScope.frmOwnerId}</font><br>
	<font color="red">${requestScope.frmOwnerPassword}</font><br>
</c:if>
<c:if test="${(action=='admin')}">
	<h4><a href="admin_home.jsp">Go Back</a></h4>
</c:if>
<c:if test="${(action=='newMember') || (action=='owner')}">
	<h4><a href="loginPath">Go Back</a></h4>
</c:if>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
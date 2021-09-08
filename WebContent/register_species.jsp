<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Welcome to Register Species Home Page</h3>
<form action="registerSpeciesPath" method="post">

	Enter Species Name:<input type='text' name='frmName' />
	<input type="submit" value="SAVE" /><br>
	<input type="hidden"
		name="frmOwnerId" value="${requestScope.frmOwnerId}" />
	 
	 <%-- Select Species: <select>
		<option value="0">SELECT</option>
		<c:forEach var="l" items="${requestScope.mySpeciesForm.frmSpeciesList}">
			<option value="${l.speciesId}">${l.speciesName}</option>
		</c:forEach>
	 </select><br> --%>
	 <a href="registerPetPath?frmOwnerId=${requestScope.frmOwnerId}">
	 	Register Pet</a>
</form>
<font color='red'>Owner ID :${requestScope.frmOwnerId}</font>
<c:if test="${not empty mySpeciesForm.frmSpeciesList}">
<table border="1" width="100%">
	<tr>
		<th>No</th>
		<th>Id</th>
		<th>Name</th>
		<th></th>
	</tr>
	<c:forEach var="p" items="${mySpeciesForm.frmSpeciesList}" varStatus="s">
		<tr>
			<td>${s.index+1}</td>
			<td>${p.speciesId}</td>
			<td>${p.speciesName}</td>
			<td><a href="updateSpeciesPath?frmSpeciesId=${p.speciesId}&frmOwnerId=${requestScope.frmOwnerId}">Update Species</a></td>
		</tr>
	</c:forEach>
</table>
</c:if>
<c:if test="${(action=='admin')}">
	<h4><a href="registerOwnerPath?action=admin&frmOwnerId=${requestScope.frmOwnerId}">Go Back</a></h4>
</c:if>
<c:if test="${(action=='owner')}">
	<h4><a href="registerOwnerPath?action=owner&frmOwnerId=${requestScope.frmOwnerId}">Go Back</a></h4>
</c:if>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
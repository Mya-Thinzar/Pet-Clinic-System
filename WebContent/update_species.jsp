<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Welcome to Update Species Home Page</h3>
<form action="updateSpeciesPath" method="post">

	Enter Update Species Name:<input type='text' name='frmName' />
	<input type="submit" value="Update" /><br>
	<input type="hidden"
		name="frmSpeciesId" value="${requestScope.frmSpeciesId}" />
</form>
<font color='red'>Owner ID :${requestScope.frmOwnerId}</font>
<c:if test="${not empty mySpeciesForm.frmSpeciesList}">
<table border="1" width="100%">
	<tr>
		<th>No</th>
		<th>Id</th>
		<th>Name</th>
	</tr>
	<c:forEach var="p" items="${mySpeciesForm.frmSpeciesList}" varStatus="s">
		<tr>
			<td>${s.index+1}</td>
			<td>${p.speciesId}</td>
			<td>${p.speciesName}</td>
		</tr>
	</c:forEach>
</table>
</c:if>
<br>
	<h4><a href="registerSpeciesPath?&action=admin&frmOwnerId=${requestScope.frmOwnerId}">Go Back</a></h4>

<br>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
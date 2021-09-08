<form  method="post">
	Enter Id: <input type="text" name="frmId" value="${requestScope.id}"/><br>
	Enter password: <input type="password" name="frmPassword" value="${requestScope.password}"/><br>
	<input type="submit" value="Login"/>
</form>
<font color='red'>${requestScope.error}</font>
<h4><a href="registerOwnerPath?action=newMember">New Member</a></h4>

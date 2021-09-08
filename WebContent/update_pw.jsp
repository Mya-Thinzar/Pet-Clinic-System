<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Update Password Page</h3>
<h4>Yor old password is ${requestScope.frmPw}</h4>
<form action="updatePwPath" method="post">
	<input type="hidden" name="frmId" value="${requestScope.frmId}"/>
	<input type="hidden" name="frmPw" value="${requestScope.frmPw}"/>
	Enter Update Password:
		<input type="password" name="frmPassword" value=""/><br>
	<input type="submit" value="SAVE"/>
</form>

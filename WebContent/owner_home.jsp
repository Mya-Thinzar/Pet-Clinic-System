<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:redirect url="registerOwnerPath?action=owner&frmOwnerId=${requestScope.myFormLogin.frmId}&frmOwnerPassword=${requestScope.myFormLogin.frmPassword}"/>


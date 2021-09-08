<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<h3>Payment Home Page</h3>
<form action="cardPath" method="post">
	<input type="hidden" name="frmVno" value="${requestScope.frmVno}"/>
	Enter Card Number:
		<input type="text" name="frmCardNo" value=""/><br>
	 <input type="submit" value="Save"/>
</form>

<c:if test="${not empty requestScope.myPaymentForm.frmPaymentList}">
<table border="1" width="100%">
	<tr>
	<th>No</th>
	<th>Voucher No</th>
	<th>Payment Date</th>
	<th>Payment Amount</th>
	<th>Payment Status</th>
	<th></th>
	</tr>
	<c:forEach var="p" items="${requestScope.myPaymentForm.frmPaymentList}" varStatus="s">
		<tr>
			<td>${s.index+1}</td>
			<td>${p.voucherNo}</td>
			<td>
				<f:formatDate value="${p.paymentDate}" pattern="dd-MM-yyyy hh:mm:ss a"/>
			</td><br>
			<td>${p.paymentAmt}</td>
			<td>${p.paymentStatus}</td>
			<c:if test="${(p.paymentStatus=='card')}">
			<td><a href="cardPath?frmVno=${p.voucherNo}">Card Service</a></td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</c:if>
<form action="loginPath">
<input type="submit" value="Logout"/>
</form>
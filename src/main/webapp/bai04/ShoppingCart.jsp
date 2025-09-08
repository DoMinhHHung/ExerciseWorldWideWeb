<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session" class="fit.iuh.se.bai04_JSP_Session.model.CartBean"/>

<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<p><a href="ModelList.jsp">Product List</a></p>

<table width="100%" border="1" bgcolor="#CCCCCC">
    <tr>
        <td>Model Description</td>
        <td>Quantity</td>
        <td>Unit Price</td>
        <td>Total</td>
    </tr>

    <c:if test="${cart.lineItemCount == 0}">
        <tr>
            <td colspan="4">Cart is currently empty</td>
        </tr>
    </c:if>

    <c:forEach var="cartItem" items="${cart.cartItem}" varStatus="counter">
        <tr>
            <form method="POST" action="CartController">
                <td>
                    <c:out value="${cartItem.strPartNumber}"/> -
                    <c:out value="${cartItem.modelDescription}"/>
                    <input type="hidden" name="itemIndex" value="${counter.count}"/>
                </td>
                <td>
                    <input type="text" name="quantity" value="${cartItem.iQuantity}" size="2"/>
                    <input type="submit" name="action" value="Update"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
                <td><c:out value="${cartItem.unitCost}"/></td>
                <td><c:out value="${cartItem.totalCost}"/></td>
            </form>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="2"></td>
        <td><b>Subtotal:</b></td>
        <td><c:out value="${cart.orderTotal}"/></td>
    </tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm chi tiết đặt bàn</title>
     <link rel="stylesheet" href="./css/add.css">
</head>
<body>
	<h1 class="title_addPr">Thêm chi tiết đặt bàn</h1>
    <div class="addPd_container">
    	
        <div class="form_add">
        <form action="./dat-ban-chi-tiet" method="post">
            <label>Mã đơn đặt bàn</label>
            <select id="danh-muc" name="maDDB" required>
                <c:forEach var="o" items="${listD}">
                	<option value="${o.maDDB}">${o.maDDB}</option>
                </c:forEach>
            </select>
            <label>Mã hàng</label>
            <select id="danh-muc" name="maH" required>
                <c:forEach var="o" items="${listH}">
                	<option value="${o.maH}">${o.tenHang}</option>
                </c:forEach>
            </select>
            <label for="ten-san-pham">Đơn vị</label>
            <input type="number" id="ten-san-pham" name="soLuong" required>
            <label for="ten-san-pham">Thành tiền</label>
            <input type="number" id="ten-san-pham" name="thanhTien" required>
            <div class="addPr_btn">
                <a href="./datbanchitiet"><button type="button">Trở về</button></a>
                <button type="submit">OK</button>
            </div>
        </form>
        </div>
    </div>
</body>

</html>
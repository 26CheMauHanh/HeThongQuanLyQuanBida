<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập nhật hàng</title>
     <link rel="stylesheet" href="./css/add.css">
</head>
<body>
	<h1 class="title_addPr">Cập nhật hàng</h1>
    <div class="addPd_container">
    	
        <div class="form_add">
        <form action="./hang" method="post">
            <input value="update" type="hidden" id="ten-san-pham" name="action" required>
            <input value="${o.maH}" type="hidden" id="ten-san-pham" name="maH" required>
            <label for="ten-san-pham">Tên hàng:</label>
            <input type="text" value="${o.tenHang}" id="ten-san-pham" name="tenHang" required>
            <label for="ten-san-pham">Đơn vị:</label>
            <input value="${o.donVi}"  type="number" id="ten-san-pham" name="donVi" required>
            <label for="ten-san-pham">Giá:</label>
            <input value="${o.gia}"  type="text" id="ten-san-pham" name="gia" required>
        	<div class="addPr_btn">
                <a href="./hang"><button type="button">Trở về</button></a>
                <button type="submit">OK</button>
            </div>
        </form>
        </div>
    </div>
</body>

</html>
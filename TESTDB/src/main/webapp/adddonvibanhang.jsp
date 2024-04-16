<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm đơn vị bán hàng</title>
     <link rel="stylesheet" href="./css/add.css">
</head>
<body>
	<h1 class="title_addPr">Thêm đơn vị bán hàng</h1>
    <div class="addPd_container">
    	
        <div class="form_add">
        <form action="./don-vi-ban-hang" method="post">
            <label>Mã đơn vị bán hàng</label>
            <input type="text" id="ten-san-pham" name="maDVBan" required>
            <label for="ten-san-pham">Tên đơn vị bán:</label>
            <input type="text" id="ten-san-pham" name="tenDVBH" required>
            <label for="ten-san-pham">Mã ST Bán:</label>
            <input type="text" id="ten-san-pham" name="maSTBan" required>
            <label for="ten-san-pham">Địa chỉ:</label>
            <input type="text" id="ten-san-pham" name="diaChiBan" required>
            <label for="ten-san-pham">SDT:</label>
            <input type="text" id="ten-san-pham" name="SDTBan" required>
            <div class="addPr_btn">
                <a href="./don-vi-dat-hang"><button type="button">Trở về</button></a>
                <button type="submit">OK</button>
            </div>
        </form>
        </div>
    </div>
</body>

</html>
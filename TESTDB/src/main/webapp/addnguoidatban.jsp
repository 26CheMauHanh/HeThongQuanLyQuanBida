<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm đơn người đặt bàn</title>
     <link rel="stylesheet" href="./css/add.css">
</head>
<body>
	<h1 class="title_addPr">Thêm người đặt bàn</h1>
    <div class="addPd_container">
    	
        <div class="form_add">
        <form action="./nguoi-dat-ban" method="post">
            <label>Mã người đặt hàng</label>
            <input type="text" id="ten-san-pham" name="maNDB" required>
            <label for="ten-san-pham">Tên người đặt bàn:</label>
            <input type="text" id="ten-san-pham" name="tenNDB" required>
            <label for="ten-san-pham">SDT:</label>
            <input type="text" id="ten-san-pham" name="SDT" required>
            <div class="addPr_btn">
                <a href="./nguoi-dat-ban"><button type="button">Trở về</button></a>
                <button type="submit">OK</button>
            </div>
        </form>
        </div>
    </div>
</body>

</html>
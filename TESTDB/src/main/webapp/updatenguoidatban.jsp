<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập nhật người đặt bàn</title>
     <link rel="stylesheet" href="./css/add.css">
</head>
<body>
	<h1 class="title_addPr">Cập nhật người đặt bàn</h1>
    <div class="addPd_container">
    	
        <div class="form_add">
        <form action="./nguoi-dat-ban" method="post">
            <input value="update" type="hidden" id="ten-san-pham" name="action" required>
            <input value="${o.maNDB}" type="hidden" id="ten-san-pham" name="maNDB" required>
            <label for="ten-san-pham">Tên đơn vị bán:</label>
            <input type="text" value="${o.tenNDB}" id="ten-san-pham" name="tenNDB" required>
            <label for="ten-san-pham">SDT:</label>
            <input value="${o.SDT}"  type="text" id="ten-san-pham" name="SDT" required>
        	<div class="addPr_btn">
                <a href="./nguoi-dat-ban"><button type="button">Trở về</button></a>
                <button type="submit">OK</button>
            </div>
        </form>
        </div>
    </div>
</body>

</html>
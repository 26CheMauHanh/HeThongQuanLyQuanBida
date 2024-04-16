<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập nhật nhân viên</title>
     <link rel="stylesheet" href="./css/add.css">
</head>
<body>
	<h1 class="title_addPr">Cập nhật nhân viên</h1>
    <div class="addPd_container">
    	
        <div class="form_add">
        <form action="./nhan-vien" method="post">
            <input value="update" type="hidden" id="ten-san-pham" name="action" required>
            <input value="${o.maNV}" type="hidden" id="ten-san-pham" name="maNV" required>
            <label for="ten-san-pham">Tên nhân viên:</label>
            <input type="text" value="${o.tenNV}" id="ten-san-pham" name="tenNV" required>
            <label for="ten-san-pham">SDT:</label>
            <input value="${o.SDT}"  type="text" id="ten-san-pham" name="SDT" required>
            <label for="ten-san-pham">Chức vụ:</label>
            <input value="${o.chucVu}"  type="text" id="ten-san-pham" name="chucVu" required>
        	<div class="addPr_btn">
                <a href="./nhan-vien"><button type="button">Trở về</button></a>
                <button type="submit">OK</button>
            </div>
        </form>
        </div>
    </div>
</body>

</html>
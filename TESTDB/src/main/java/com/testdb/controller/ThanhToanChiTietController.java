package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.ThanhToanChiTietDAO;
import com.testdb.model.ThanhToanChiTietModel;
@WebServlet(urlPatterns = {"/thanh-toan-chi-tiet"})
public class ThanhToanChiTietController extends HttpServlet{
	public ThanhToanChiTietDAO ttdao = new ThanhToanChiTietDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ThanhToanChiTietModel> list = ttdao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("./thanhtoanchitiet.jsp").forward(req, resp);
	}
}

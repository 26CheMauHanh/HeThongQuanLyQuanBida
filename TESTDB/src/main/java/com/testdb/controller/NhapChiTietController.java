package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.NhapChiTietDAO;
import com.testdb.model.NhapChiTietModel;
@WebServlet(urlPatterns = {"/nhap-chi-tiet"})
public class NhapChiTietController extends HttpServlet{
	public NhapChiTietDAO nctdao = new NhapChiTietDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<NhapChiTietModel> list = nctdao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("./nhapchitiet.jsp").forward(req, resp);
	}
}

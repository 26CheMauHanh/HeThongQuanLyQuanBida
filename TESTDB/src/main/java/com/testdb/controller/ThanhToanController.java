package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.ThanhToanDAO;
import com.testdb.model.ThanhToanModel;
@WebServlet(urlPatterns = {"/thanh-toan"})
public class ThanhToanController extends HttpServlet{
	public ThanhToanDAO ttdao = new ThanhToanDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ThanhToanModel> list = ttdao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("./thanhtoan.jsp").forward(req, resp);
	}
}

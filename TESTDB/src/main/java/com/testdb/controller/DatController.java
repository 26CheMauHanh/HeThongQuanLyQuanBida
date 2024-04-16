package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.DatDAO;
import com.testdb.dao.DonViBanHangDAO;
import com.testdb.dao.NhanVienDAO;
import com.testdb.model.DatModel;
import com.testdb.model.DonViBanHangModel;
import com.testdb.model.NhanVienModel;
@WebServlet(urlPatterns = {"/dat"})
public class DatController extends HttpServlet{
	public DatDAO ddao = new DatDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DatModel> list = ddao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("./dat.jsp").forward(req, resp);
	}
}

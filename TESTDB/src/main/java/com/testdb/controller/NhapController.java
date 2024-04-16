package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.NhapDAO;
import com.testdb.model.NhapModel;
@WebServlet(urlPatterns = {"/nhap"})
public class NhapController extends HttpServlet{
	public NhapDAO ndao = new NhapDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<NhapModel> list = ndao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("./nhap.jsp").forward(req, resp);
	}
}

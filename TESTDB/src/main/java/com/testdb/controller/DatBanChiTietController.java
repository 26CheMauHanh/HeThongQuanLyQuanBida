package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.DatBanChiTietDAO;
import com.testdb.dao.DatDAO;
import com.testdb.dao.HangDAO;
import com.testdb.model.DatBanChiTietModel;
import com.testdb.model.DatModel;
import com.testdb.model.HangModel;
@WebServlet(urlPatterns = {"/dat-ban-chi-tiet"})
public class DatBanChiTietController extends HttpServlet{
	public DatBanChiTietDAO dbctdao = new DatBanChiTietDAO();
	public DatDAO ddao = new DatDAO();
	public HangDAO hdao = new HangDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac = req.getParameter("action");
		if(ac== null) {
			List<DatBanChiTietModel> list = dbctdao.findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("./datbanchitiet.jsp").forward(req, resp);
			return;
		}else if(ac.equals("add")) {
			List<HangModel> listH = hdao.findAll();
			List<DatModel> listD = ddao.findAll();
			req.setAttribute("listH", listH);
			req.setAttribute("listD", listD);
			req.getRequestDispatcher("./adddatbanchitiet.jsp").forward(req, resp);
			return;
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DatBanChiTietModel dbct = new DatBanChiTietModel();
		dbct.setMaDDB(req.getParameter("maDDB"));
		dbct.setMaH(req.getParameter("maH"));
		dbct.setSoLuong(Integer.valueOf(req.getParameter("soLuong")));
		dbct.setThanhTien(Double.valueOf(req.getParameter("thanhTien")));
		dbctdao.insert(dbct);
		req.getRequestDispatcher("./datbanchitiet.jsp").forward(req, resp);
	}
}

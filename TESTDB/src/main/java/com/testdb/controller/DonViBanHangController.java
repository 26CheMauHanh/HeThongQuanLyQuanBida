package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.DonViBanHangDAO;
import com.testdb.dao.NhanVienDAO;
import com.testdb.model.DonViBanHangModel;
import com.testdb.model.NguoiDatBanModel;
import com.testdb.model.NhanVienModel;
@WebServlet(urlPatterns = {"/don-vi-ban-hang"})
public class DonViBanHangController extends HttpServlet{
	public DonViBanHangDAO dvbhdao = new DonViBanHangDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action == null) {
			List<DonViBanHangModel> list = dvbhdao.findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("./donvibanhang.jsp").forward(req, resp);
			return;
		}else if(action.equals("add")) {
			req.getRequestDispatcher("./adddonvibanhang.jsp").forward(req, resp);
			return;
		}else if(action.equals("update")) {
			String id = req.getParameter("id");
			DonViBanHangModel dvbh = dvbhdao.findOneById(id);
			req.setAttribute("o", dvbh);
			req.getRequestDispatcher("./updatedonvibanhang.jsp").forward(req, resp);
			return;
		}else if(action.equals("delete")) {
			String id = req.getParameter("id");
			dvbhdao.delete(id);
			resp.sendRedirect("./don-vi-ban-hang");
		}else if(action.equals("search")) {
			String txtSearch = req.getParameter("txtSearch");
			List<DonViBanHangModel> list = dvbhdao.findAllLikeName(txtSearch);
			req.setAttribute("list", list);
			req.setAttribute("txtSearch", txtSearch);
			req.getRequestDispatcher("./donvibanhang.jsp").forward(req, resp);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String ac = req.getParameter("action");
		if(ac == null) {
			DonViBanHangModel dvbh = new DonViBanHangModel(req.getParameter("maDVBan"), req.getParameter("tenDVBH"), req.getParameter("maSTBan"), req.getParameter("diaChiBan"), req.getParameter("SDTBan"));
			dvbhdao.insert(dvbh);
			resp.sendRedirect("./don-vi-ban-hang");
			return;
		}
		else if(ac.equals("update")) {
			doPut(req, resp);
			return;
		}
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		DonViBanHangModel dvbh = new DonViBanHangModel(req.getParameter("maDVBan"), req.getParameter("tenDVBH"), req.getParameter("maSTBan"), req.getParameter("diaChiBan"), req.getParameter("SDTBan"));
		dvbhdao.update(dvbh);
		resp.sendRedirect("./don-vi-ban-hang");
	}
}

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
import com.testdb.dao.HangDAO;
import com.testdb.dao.NhanVienDAO;
import com.testdb.model.DatModel;
import com.testdb.model.DonViBanHangModel;
import com.testdb.model.HangModel;
import com.testdb.model.NhanVienModel;
@WebServlet(urlPatterns = {"/hang"})
public class HangController extends HttpServlet{
	public HangDAO hdao = new HangDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action == null) {
			List<HangModel> list = hdao.findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("./hang.jsp").forward(req, resp);
			return;
		}else if(action.equals("add")) {
			req.getRequestDispatcher("./addhang.jsp").forward(req, resp);
			return;
		}else if(action.equals("update")) {
			String id = req.getParameter("id");
			HangModel dvbh = hdao.findOneById(id);
			req.setAttribute("o", dvbh);
			req.getRequestDispatcher("./updatehang.jsp").forward(req, resp);
			return;
		}else if(action.equals("delete")) {
			String id = req.getParameter("id");
			hdao.delete(id);
			resp.sendRedirect("./hang");
		}else if(action.equals("search")) {
			String txtSearch = req.getParameter("txtSearch");
			List<HangModel> list = hdao.findAllLikeName(txtSearch);
			req.setAttribute("list", list);
			req.setAttribute("txtSearch", txtSearch);
			req.getRequestDispatcher("./hang.jsp").forward(req, resp);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String ac = req.getParameter("action");
		if(ac == null) {
			HangModel dvbh = new HangModel(req.getParameter("maH"), req.getParameter("tenHang"), Integer.valueOf(req.getParameter("donVi")), Double.valueOf(req.getParameter("gia")));
			hdao.insert(dvbh);
			resp.sendRedirect("./hang");
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
		HangModel dvbh = new HangModel(req.getParameter("maH"), req.getParameter("tenHang"), Integer.valueOf(req.getParameter("donVi")), Double.valueOf(req.getParameter("gia")));
		hdao.update(dvbh);
		resp.sendRedirect("./hang");
	}
}

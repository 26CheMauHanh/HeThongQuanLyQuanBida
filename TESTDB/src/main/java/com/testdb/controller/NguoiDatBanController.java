package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.DonViBanHangDAO;
import com.testdb.dao.NguoiDatBanDAO;
import com.testdb.dao.NhanVienDAO;
import com.testdb.model.DonViBanHangModel;
import com.testdb.model.HangModel;
import com.testdb.model.NguoiDatBanModel;
import com.testdb.model.NhanVienModel;
@WebServlet(urlPatterns = {"/nguoi-dat-ban"})
public class NguoiDatBanController extends HttpServlet{
	public NguoiDatBanDAO ndbdao = new NguoiDatBanDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action == null) {
			List<NguoiDatBanModel> list = ndbdao.findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("./nguoidatban.jsp").forward(req, resp);
			return;
		}else if(action.equals("add")) {
			req.getRequestDispatcher("./addnguoidatban.jsp").forward(req, resp);
			return;
		}else if(action.equals("update")) {
			String id = req.getParameter("id");
			NguoiDatBanModel dvbh = ndbdao.findOneById(id);
			req.setAttribute("o", dvbh);
			req.getRequestDispatcher("./updatenguoidatban.jsp").forward(req, resp);
			return;
		}else if(action.equals("delete")) {
			String id = req.getParameter("id");
			ndbdao.delete(id);
			resp.sendRedirect("./nguoi-dat-ban");
		}else if(action.equals("search")) {
			String txtSearch = req.getParameter("txtSearch");
			List<NguoiDatBanModel> list = ndbdao.findAllLikeName(txtSearch);
			req.setAttribute("list", list);
			req.setAttribute("txtSearch", txtSearch);
			req.getRequestDispatcher("./nguoidatban.jsp").forward(req, resp);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String ac = req.getParameter("action");
		if(ac == null) {
			NguoiDatBanModel dvbh = new NguoiDatBanModel(req.getParameter("maNDB"),req.getParameter("tenNDB"),req.getParameter("SDT"));
			ndbdao.insert(dvbh);
			resp.sendRedirect("./nguoi-dat-ban");
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
		NguoiDatBanModel dvbh = new NguoiDatBanModel(req.getParameter("maNDB"),req.getParameter("tenNDB"),req.getParameter("SDT"));
		ndbdao.update(dvbh);
		resp.sendRedirect("./nguoi-dat-ban");
	}
	
}

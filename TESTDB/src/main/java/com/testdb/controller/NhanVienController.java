package com.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testdb.dao.NhanVienDAO;
import com.testdb.model.DonViBanHangModel;
import com.testdb.model.NguoiDatBanModel;
import com.testdb.model.NhanVienModel;
@WebServlet(urlPatterns = {"/nhan-vien"})
public class NhanVienController extends HttpServlet{
	public NhanVienDAO nvdao = new NhanVienDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action == null) {
			List<NhanVienModel> listNv = nvdao.findAll();
			req.setAttribute("list", listNv);
			req.getRequestDispatcher("./nhanvien.jsp").forward(req, resp);
			return;
		}else if(action.equals("add")) {
			req.getRequestDispatcher("./addnhanvien.jsp").forward(req, resp);
			return;
		}else if(action.equals("update")) {
			String id = req.getParameter("id");
			NhanVienModel dvbh = nvdao.findOneById(id);
			req.setAttribute("o", dvbh);
			req.getRequestDispatcher("./updatenhanvien.jsp").forward(req, resp);
			return;
		}else if(action.equals("delete")) {
			String id = req.getParameter("id");
			nvdao.delete(id);
			resp.sendRedirect("./nhan-vien");
		}else if(action.equals("search")) {
			String txtSearch = req.getParameter("txtSearch");
			List<NhanVienModel> list = nvdao.findAllLikeName(txtSearch);
			req.setAttribute("list", list);
			req.setAttribute("txtSearch", txtSearch);
			req.getRequestDispatcher("./nhanvien.jsp").forward(req, resp);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String ac = req.getParameter("action");
		if(ac == null) {
			NhanVienModel nv = new NhanVienModel(req.getParameter("maNV"),req.getParameter("tenNV"),req.getParameter("SDT"),req.getParameter("chucVu"));
			nvdao.insert(nv);
			resp.sendRedirect("./nhan-vien");
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
		NhanVienModel nv = new NhanVienModel(req.getParameter("maNV"),req.getParameter("tenNV"),req.getParameter("SDT"),req.getParameter("chucVu"));
		nvdao.update(nv);
		resp.sendRedirect("./nhan-vien");
	}
}

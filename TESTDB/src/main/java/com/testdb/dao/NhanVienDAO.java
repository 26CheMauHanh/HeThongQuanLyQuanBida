package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.NhanVienModel;

public class NhanVienDAO extends CommonDAO<NhanVienModel>{
	public NhanVienDAO() {
		super();
	}
	
	@Override
	public List<NhanVienModel> findAll() {
		List<NhanVienModel> list = new ArrayList();
		String sql = "select * from Nhanvien";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				NhanVienModel o = new NhanVienModel(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NhanVienModel findOneById(NhanVienModel o) {
		NhanVienModel kq =null;
		String sql = "select * from NhanVien where MaNV = ?";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			pst.setString(1, o.getMaNV());
			while(rs.next()) {
				kq = new NhanVienModel(rs.getString(0), rs.getString(1), rs.getString(2),rs.getString(3));
				return kq;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<NhanVienModel> findAllLikeName(String txtSearch) {
		List<NhanVienModel> list =new ArrayList<NhanVienModel>();
		String sql = "select * from NhanVien where TenNV like ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, "%"+txtSearch+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				NhanVienModel kq = new NhanVienModel(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				list.add(kq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public NhanVienModel findOneById(String id) {
		NhanVienModel kq =null;
		String sql = "select * from NhanVien where MaNV = ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1,id);
			rs = pst.executeQuery();
			while(rs.next()) {
				kq = new NhanVienModel(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				return kq;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int insert(NhanVienModel o) {
		String sql = "insert NhanVien"
				+ " values(?,?,?,?)";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getMaNV());
			pst.setString(2, o.getTenNV());
			pst.setString(3, o.getSDT());
			pst.setString(4, o.getChucVu());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(NhanVienModel o) {
		String sql = "update NhanVien"
				+ " set TenNV = ?, SDT = ?, ChucVu = ? where maNV = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getTenNV());
			pst.setString(2, o.getSDT());
			pst.setString(3, o.getChucVu());
			pst.setString(4, o.getMaNV());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void delete(String id) {
		String sql = "delete NhanVien where MaNV = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.HangModel;
import com.testdb.model.NhanVienModel;

public class HangDAO extends CommonDAO<HangModel> {

	@Override
	public List<HangModel> findAll() {
		List<HangModel> list = new ArrayList();
		String sql = "select * from Hang";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				HangModel o = new HangModel(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public HangModel findOneById(HangModel o) {
		// TODO Auto-generated method stub
		return null;
	}
	public HangModel findOneById(String id) {
		HangModel kq =null;
		String sql = "select * from Hang where MaH = ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1,id);
			rs = pst.executeQuery();
			while(rs.next()) {
				kq = new HangModel(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getDouble(4));
				return kq;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<HangModel> findAllLikeName(String txtSearch) {
		List<HangModel> list =new ArrayList<HangModel>();
		String sql = "select * from Hang where TenHang like ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1,"%"+txtSearch+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				HangModel kq = new HangModel(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getDouble(4));
				list.add(kq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(HangModel o) {
		String sql = "insert NhanVien"
				+ " values(?,?,?,?)";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getMaH());
			pst.setString(2, o.getTenHang());
			pst.setInt(3, o.getDonVi());
			pst.setDouble(4, o.getGia());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(HangModel o) {
		String sql = "update Hang"
				+ " set TenHang = ?, DonVi = ?, Gia = ? where MaH = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getTenHang());
			pst.setInt(2, o.getDonVi());
			pst.setDouble(3, o.getGia());
			pst.setString(4, o.getMaH());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void delete(String id) {
		String sql = "delete Hang where MaH = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.NguoiDatBanModel;

public class NguoiDatBanDAO extends CommonDAO<NguoiDatBanModel>{

	@Override
	public List<NguoiDatBanModel> findAll() {
		List<NguoiDatBanModel> list = new ArrayList();
		String sql = "select * from NguoiDatBan";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				NguoiDatBanModel o = new NguoiDatBanModel(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NguoiDatBanModel findOneById(NguoiDatBanModel o) {
		NguoiDatBanModel ndb =null;
		String sql = "select * from NguoiDatBan where MaNDB = ?";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			pst.setString(1, o.getMaNDB());
			while(rs.next()) {
				ndb = new NguoiDatBanModel(rs.getString("MaNDB"), rs.getString("TenNDB"), rs.getString("SDT"));
				return ndb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public NguoiDatBanModel findOneById(String id) {
		NguoiDatBanModel ndb =null;
		String sql = "select * from NguoiDatBan where MaNDB = ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				ndb = new NguoiDatBanModel(rs.getString("MaNDB"), rs.getString("TenNDB"), rs.getString("SDT"));
				return ndb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<NguoiDatBanModel> findAllLikeName(String txtSearch) {
		List<NguoiDatBanModel> list =new ArrayList<NguoiDatBanModel>();
		String sql = "select * from NguoiDatBan where tenNDB like ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, "%"+txtSearch+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				NguoiDatBanModel ndb = new NguoiDatBanModel(rs.getString("MaNDB"), rs.getString("TenNDB"), rs.getString("SDT"));
				list.add(ndb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(NguoiDatBanModel o) {
		String sql = "insert NguoiDatBan"
				+ " values(?,?,?)";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getMaNDB());
			pst.setString(2, o.getTenNDB());
			pst.setString(3, o.getSDT());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(NguoiDatBanModel o) {
		String sql = "update NguoiDatBan"
				+ " set TenNDB = ?, SDT = ? where MaNDB = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getTenNDB());
			pst.setString(2, o.getSDT());
			pst.setString(3, o.getMaNDB());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public void delete(String id) {
		String sql = "delete NguoiDatBan where MaNDB = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}

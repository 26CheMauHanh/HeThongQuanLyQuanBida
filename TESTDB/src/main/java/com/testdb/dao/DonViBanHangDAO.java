package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.DonViBanHangModel;

public class DonViBanHangDAO extends CommonDAO<DonViBanHangModel>{

	@Override
	public List<DonViBanHangModel> findAll() {
		List<DonViBanHangModel> list = new ArrayList();
		String sql = "select * from DonViBanHang";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				DonViBanHangModel o = new DonViBanHangModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DonViBanHangModel findOneById(DonViBanHangModel o) {
		DonViBanHangModel kq = null;
		String sql = "select * from DonViBanHang where MaDVBan=?";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				kq = new DonViBanHangModel(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return kq;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}
	public DonViBanHangModel findOneById(String id) {
		DonViBanHangModel kq = null;
		String sql = "select * from DonViBanHang where MaDVBan=?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				kq = new DonViBanHangModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return kq;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}
	public List<DonViBanHangModel> findAllLikeName(String txtSearch) {
		List<DonViBanHangModel> list = new ArrayList<DonViBanHangModel>();
		String sql = "select * from DonViBanHang where TenDVBH like ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1,"%"+ txtSearch+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				DonViBanHangModel kq = new DonViBanHangModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(kq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public int insert(DonViBanHangModel o) {
		String sql = "insert DonViBanHang"
				+ " values(?,?,?,?,?)";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getMaDVBan());
			pst.setString(2, o.getTenDVBH());
			pst.setString(3, o.getMaSTBan());
			pst.setString(4, o.getDiaChiBan());
			pst.setString(5, o.getSDTBan());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(DonViBanHangModel o) {
		String sql = "update DonViBanHang"
				+ " set TenDVBH = ?, MaSTBan = ?, DiaChiBan = ?,SDTBan=? where MaDVBan = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, o.getTenDVBH());
			pst.setString(2, o.getMaSTBan());
			pst.setString(3, o.getDiaChiBan());
			pst.setString(4, o.getSDTBan());
			pst.setString(5, o.getMaDVBan());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void delete(String id) {
		String sql = "delete DonViBanHang where MaDVBan = ?";
		try {
			pst= cnt.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

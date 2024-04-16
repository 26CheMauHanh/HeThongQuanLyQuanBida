package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.DatBanChiTietModel;

public class DatBanChiTietDAO extends CommonDAO<DatBanChiTietModel>{

	@Override
	public List<DatBanChiTietModel> findAll() {
		List<DatBanChiTietModel> list = new ArrayList<DatBanChiTietModel>();
		String sql = "select * from DatBanChiTiet";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				DatBanChiTietModel o = new DatBanChiTietModel(rs.getString(1), rs.getInt(2), rs.getDouble(3),rs.getString(4));
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public DatBanChiTietModel findOneById(DatBanChiTietModel o) {
		// TODO Auto-generated method stub
		return null;
	}
	public DatBanChiTietModel findOneByMaDDBAndMaH(String maDDB ,String maH) {
		String sql = "select * from DatBanChiTiet where MaDDB = ? and MaH = ?";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				DatBanChiTietModel o = new DatBanChiTietModel(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
				return o;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(DatBanChiTietModel o) {
		String sql = "insert DatBanChiTiet "
				+ "values(?,?,?,?)";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, o.getMaDDB());
			pst.setInt(2, o.getSoLuong());
			pst.setDouble(3, o.getThanhTien());
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
		String sql = "delete DatBanChiTiet "
				+ "where MaDDB = ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteByMaDDBAndMaH(String maDDB,String maH) {
		String sql = "delete DatBanChiTiet "
				+ "where MaDDB = ? and MaH = ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setString(1, maDDB);
			pst.setString(2, maH);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int update(DatBanChiTietModel o) {
		String sql = "update DatBanChiTiet "
				+ "SLuong = ?, ThanhTien = ? where MaH = ? and MaDDB = ?";
		try {
			pst = cnt.prepareStatement(sql);
			pst.setInt(1, o.getSoLuong());
			pst.setDouble(2, o.getThanhTien());
			pst.setString(3, o.getMaH());
			pst.setString(4, o.getMaDDB());
			int kq = pst.executeUpdate();
			return kq;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}

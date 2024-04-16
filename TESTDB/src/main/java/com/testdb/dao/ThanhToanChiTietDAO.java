package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.ThanhToanChiTietModel;

public class ThanhToanChiTietDAO extends CommonDAO<ThanhToanChiTietModel>{

	@Override
	public List<ThanhToanChiTietModel> findAll() {
		List<ThanhToanChiTietModel> list = new ArrayList();
		String sql = "select * from ThanhToanChiTiet";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ThanhToanChiTietModel o = new ThanhToanChiTietModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6), rs.getDouble(7));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ThanhToanChiTietModel findOneById(ThanhToanChiTietModel o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ThanhToanChiTietModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ThanhToanChiTietModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}

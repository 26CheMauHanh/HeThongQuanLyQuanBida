package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.NhapChiTietModel;

public class NhapChiTietDAO extends CommonDAO<NhapChiTietModel>{

	@Override
	public List<NhapChiTietModel> findAll() {
		List<NhapChiTietModel> list = new ArrayList();
		String sql = "select * from NhapChiTiet";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				NhapChiTietModel o = new NhapChiTietModel(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public NhapChiTietModel findOneById(NhapChiTietModel o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NhapChiTietModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NhapChiTietModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	

}

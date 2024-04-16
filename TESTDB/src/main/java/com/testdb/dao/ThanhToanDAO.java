package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.ThanhToanModel;

public class ThanhToanDAO extends CommonDAO<ThanhToanModel>{

	@Override
	public List<ThanhToanModel> findAll() {
		List<ThanhToanModel> list = new ArrayList();
		String sql = "select * from ThanhToan";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ThanhToanModel o = new ThanhToanModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ThanhToanModel findOneById(ThanhToanModel o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ThanhToanModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ThanhToanModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	

}

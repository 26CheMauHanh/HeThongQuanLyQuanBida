package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.testdb.model.DatModel;
import com.testdb.model.DonViBanHangModel;

public class DatDAO extends CommonDAO<DatModel>{

	@Override
	public List<DatModel> findAll() {
		List<DatModel> list = new ArrayList();
		String sql = "select * from Dat";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				DatModel o = new DatModel(rs.getString(1),new Date(rs.getDate(2).getTime()),rs.getInt(3),rs.getString(4));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DatModel findOneById(DatModel o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DatModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DatModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}

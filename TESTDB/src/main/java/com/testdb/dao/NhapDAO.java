package com.testdb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testdb.model.DatBanChiTietModel;
import com.testdb.model.DonViBanHangModel;
import com.testdb.model.NhapModel;

public class NhapDAO extends CommonDAO<NhapModel>{

	@Override
	public List<NhapModel> findAll() {
		List<NhapModel> list = new ArrayList();
		String sql = "select * from Nhap";
		try {
			pst = cnt.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				NhapModel o = new NhapModel(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public NhapModel findOneById(NhapModel o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NhapModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NhapModel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	
}

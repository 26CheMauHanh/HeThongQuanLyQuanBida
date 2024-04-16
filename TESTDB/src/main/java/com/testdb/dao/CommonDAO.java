package com.testdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.testdb.utils.connectDB;

public abstract class CommonDAO<T> {
	Connection cnt = connectDB.getConnectionSqlServer();
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	public abstract List<T> findAll();
	public abstract T findOneById(T o);
	public abstract int insert(T o);
	public abstract int update(T o);
	public abstract void delete(String id);
	
}

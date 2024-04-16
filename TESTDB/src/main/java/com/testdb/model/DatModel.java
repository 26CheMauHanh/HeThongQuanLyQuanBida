package com.testdb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DatModel {
	private String maDDB;
	private Date ngayDat;
	private int timeDV;
	private String maNDB;
	public String viewNgayDat() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(ngayDat);
	}
}

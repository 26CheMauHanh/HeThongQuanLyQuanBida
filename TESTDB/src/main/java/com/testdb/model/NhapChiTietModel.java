package com.testdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhapChiTietModel {
	private String maDNH;
	private int SL;
	private double thanhTien;
	private double tongTienH;
	private double thueGTGT;
	private double tongTienTT;
	private String maNV;
}

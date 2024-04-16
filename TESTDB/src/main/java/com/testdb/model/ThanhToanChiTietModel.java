package com.testdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThanhToanChiTietModel {
	private String maDTT;
	private String maH;
	private int soLuong;
	private double thanhTien;
	private double tongDV;
	private int TTGio;
	private double tongTT;
}

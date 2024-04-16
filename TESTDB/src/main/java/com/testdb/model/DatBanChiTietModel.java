package com.testdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DatBanChiTietModel {
	private String maDDB;
	private int soLuong;
	private double thanhTien;
	private String maH;
}

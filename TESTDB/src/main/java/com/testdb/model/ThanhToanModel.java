package com.testdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThanhToanModel {
	private String maDTT;
	private String gioVao;
	private String gioRa;
	private int timeSD;
	private String maNV;
}

package com.model;

public class Lop {
	private String maLop;
	private String tenLop;
	private int maGiaoVien;
	private String maKhoa;

	public Lop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lop(String maLop, String tenLop, int maGiaoVien, String maKhoa) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.maGiaoVien = maGiaoVien;
		this.maKhoa = maKhoa;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

}

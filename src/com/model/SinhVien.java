package com.model;

public class SinhVien {

	private int maSinhVien;
	private String tenSinhVien;
	private String ngaySinh;
	private String diaChi;
	private String gioiTinh;
	private String maLop;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int maSinhVien, String tenSinhVien, String ngaySinh, String diaChi, String gioiTinh, String maLop) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.maLop = maLop;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	

}

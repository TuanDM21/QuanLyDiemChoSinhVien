package com.model;

public class GiaoVien {

	private int maGiaoVien;
	private String tenGiaoVien;
	private String ngaySinh;
	private String tenDangNhap;
	private String matKhau;
	private Boolean isAdmin;
	private String gioiTinh;

	public GiaoVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoVien(int maGiaoVien, String tenGiaoVien, String ngaySinh, String tenDangNhap, String matKhau,
			Boolean isAdmin, String gioiTinh) {
		super();
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
		this.ngaySinh = ngaySinh;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.isAdmin = isAdmin;
		this.gioiTinh = gioiTinh;
	}

	public int getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getTenGiaoVien() {
		return tenGiaoVien;
	}

	public void setTenGiaoVien(String tenGiaoVien) {
		this.tenGiaoVien = tenGiaoVien;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}

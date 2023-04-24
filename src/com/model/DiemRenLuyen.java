package com.model;

public class DiemRenLuyen {

	private int maDiemRenLuyen;
	private float diemRenLuyen;
	private int hocKi;
	private int maSinhVien;

	public DiemRenLuyen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiemRenLuyen(int maDiemRenLuyen, float diemRenLuyen, int hocKi, int maSinhVien) {
		super();
		this.maDiemRenLuyen = maDiemRenLuyen;
		this.diemRenLuyen = diemRenLuyen;
		this.hocKi = hocKi;
		this.maSinhVien = maSinhVien;
	}

	public int getMaDiemRenLuyen() {
		return maDiemRenLuyen;
	}

	public void setMaDiemRenLuyen(int maDiemRenLuyen) {
		this.maDiemRenLuyen = maDiemRenLuyen;
	}

	public float getDiemRenLuyen() {
		return diemRenLuyen;
	}

	public void setDiemRenLuyen(float diemRenLuyen) {
		this.diemRenLuyen = diemRenLuyen;
	}

	public int getHocKi() {
		return hocKi;
	}

	public void setHocKi(int hocKi) {
		this.hocKi = hocKi;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

}
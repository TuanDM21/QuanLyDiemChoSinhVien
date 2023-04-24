package com.service;

import java.util.List;

import com.dao.KhoaDao;
import com.model.Khoa;

public class KhoaService {

	public List<Khoa> getAllKhoa() throws Exception {
		KhoaDao dao = new KhoaDao();
		return dao.getAllKhoa();

	}
}

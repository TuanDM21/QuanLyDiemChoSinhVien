package com.service;

import java.util.List;

import com.dao.LopDao;
import com.model.Lop;

public class LopService {

	LopDao lopDao = new LopDao();

	public List<Lop> getAllLop() throws Exception {
		return lopDao.getAllLop();
	}
}

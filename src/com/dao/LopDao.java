package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Lop;

public class LopDao {
	public List<Lop> getAllLop() throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Select * from lop";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		List<Lop> listLop = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			Lop lop = new Lop();
			String maLop = rs.getString("maLop");
			String tenLop = rs.getString("tenLop");
			lop.setMaLop(maLop);
			lop.setTenLop(tenLop);
			listLop.add(lop);
		}
		connect.cn.close();
		return listLop;
	}

}

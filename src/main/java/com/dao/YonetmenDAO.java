package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.entity.Yonetmen;

public class YonetmenDAO implements com.dao.abstracts.YonetmenDAO{

	public boolean yeniYonetmenEkle(Yonetmen y) {
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "INSERT INTO `yonetmen` (`ad`) VALUES (?)";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, y.getAd());
			
			psmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public int getSonYonetmenId() {
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select COUNT(id) from yonetmen";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {	
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}

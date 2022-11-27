package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Film;
import com.entity.Kategori;
import com.entity.Yonetmen;

public class KullaniciDAO implements com.dao.abstracts.KullaniciDAO {

	@Override
	public boolean kullaniciKontrol(String ka, String sf) {
		// TODO Auto-generated method stub
			
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select * from hesap where kullanici_adi=? and kullanici_sifre=?";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, ka);
			psmt.setString(2, sf);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return true;
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.entity.Kategori;

public class KategoriDAO implements com.dao.abstracts.KategoriDAO{
	
	public ArrayList<Kategori> butunKategorileriGetir() {
		
		ArrayList<Kategori> kategoriler = new ArrayList<Kategori>();
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "select * from kategori";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Kategori kat = new Kategori(rs.getInt("id"), rs.getString("ad"));
				kategoriler.add(kat);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kategoriler;
	}

	public boolean yeniKategoriEkle(Kategori k) {
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "INSERT INTO `kategori` (`ad`) VALUES (?)";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, k.getAd());
			
			psmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getSonKategoriId() {
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select  COUNT(id) from kategori";
			
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


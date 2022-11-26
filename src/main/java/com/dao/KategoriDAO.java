package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Kategori;

public class KategoriDAO {
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
} 


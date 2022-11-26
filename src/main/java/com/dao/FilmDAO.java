package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.Film;
import com.entity.Kategori;
import com.entity.Yonetmen;

public class FilmDAO {
	
	public Film filmAyrintiGetir(int filmid) {
		
		Film f = new Film();
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select * from film where f.id=?";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setInt(1, filmid);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Yonetmen yonetmen = new Yonetmen(rs.getInt("yonid"), rs.getString("ad"));
				Kategori kategori = new Kategori(rs.getInt("katid"), rs.getString("katad"));
				f = new Film( rs.getInt("id"), rs.getInt("sene"), rs.getString("ad"), yonetmen, kategori );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * @return  ArrayList<Film> filmler
		 */
		return f; 
		
	}
	
	
	
	
	
	
	public ArrayList<Film> butunFilmleriGetir() {
		 
		ArrayList<Film> filmler = new ArrayList<Film>();
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select * from film";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sorgu);
			
			while(rs.next()) {	
				Film f = new Film( rs.getInt("id"), rs.getString("ad"), rs.getInt("sene") );
				filmler.add(f);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * @return  ArrayList<Film> filmler
		 */
		return filmler;  
	}
	
	
	public ArrayList<Film> kategoriyeAitFilmleriGetir(int kategoriid) {
		ArrayList<Film> filmler = new ArrayList<Film>();
		
		Connection conn = ConnectionManager.getConnection();
		
		String query = "select * from film where kategori_id=?";
		// kategori_id= " + id . şeklindede kullanabiliriz ama sql injection yer
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, kategoriid);
		
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {	
				Film f = new Film( rs.getInt("id"), rs.getString("ad"), rs.getInt("sene") );
				filmler.add(f);	
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filmler;
	}
	

}

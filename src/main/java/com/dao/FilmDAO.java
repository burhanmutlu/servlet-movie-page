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

public class FilmDAO implements com.dao.abstracts.FilmDAO {
	
	public Film filmAyrintiGetir(int filmid) {
		
		Film f = new Film();
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			StringBuilder sorgu = new StringBuilder();
			sorgu.append("select f.id, f.ad, f.sene, k.id as katid, k.ad as katad, y.id as yonid, ");
			sorgu.append("y.ad as yonad from film f inner join kategori k on f.kategori_id=k.id ");
			sorgu.append("inner join yonetmen y on f.yonetmen_id=y.id where f.id=?");
			
			PreparedStatement psmt = conn.prepareStatement(sorgu.toString());
			psmt.setInt(1, filmid);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Yonetmen yonetmen = new Yonetmen(rs.getInt("yonid"), rs.getString("yonad"));
				Kategori kategori = new Kategori(rs.getInt("katid"), rs.getString("katad"));
				f = new Film( rs.getInt("id"), rs.getInt("sene"), rs.getString("ad"), yonetmen, kategori );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	
	
	public boolean yeniFilmEkle(Film f) {
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "INSERT INTO `film` (`ad`, `sene`, `kategori_id`, `yonetmen_id`) VALUES (?, ?, ?, ?)";
			
			KategoriDAO katdao = new KategoriDAO();
			katdao.yeniKategoriEkle(f.getKategori());
			
			YonetmenDAO yondao = new YonetmenDAO();
			yondao.yeniYonetmenEkle(f.getYonetmen());
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, f.getAd());
			psmt.setInt(2, f.getSene() );
			psmt.setInt(3, katdao.getSonKategoriId());
			psmt.setInt(4, yondao.getSonYonetmenId());
			
			psmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean yeniFavoriEkle(Film f, int hesapId) {
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "INSERT INTO `favori` (`ad`, `hesap_id`) VALUES (?,?)";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, f.getAd());
			psmt.setInt(2, hesapId );
		
			psmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.entity.Kisi;

public class KullaniciDAO implements com.dao.abstracts.KullaniciDAO {

	public boolean kullaniciKontrol(Kisi k) {
			
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select * from hesap where kullanici_adi=? and kullanici_sifre=?";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, k.getKullaniciAdi());
			psmt.setString(2, k.getSifre());
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return true;
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean kullaniciKayit(Kisi k) {
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "INSERT INTO `hesap` (`kullanici_adi`, `kullanici_sifre`) VALUES (?, ?)";
			
			if (this.kullaniciKontrol(k)) {
				return false;
			}
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, k.getKullaniciAdi());
			psmt.setString(2, k.getSifre());
			
			psmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean kullaniciSil(Kisi k) {
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "DELETE FROM `hesap` WHERE kullanici_adi=? and kullanici_sifre=?";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, k.getKullaniciAdi());
			psmt.setString(2, k.getSifre());
			
			psmt.executeUpdate();

			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int getKullaniciHesapId(Kisi k) {
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			String sorgu = "select id from hesap where kullanici_adi=? and kullanici_sifre=?";
			
			PreparedStatement psmt = conn.prepareStatement(sorgu);
			psmt.setString(1, k.getKullaniciAdi());
			psmt.setString(2, k.getSifre());
			
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

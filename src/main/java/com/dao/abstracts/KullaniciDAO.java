package com.dao.abstracts;

public interface KullaniciDAO {
// interface sınıfta metot tanımlarında static olamaz. eğer olursa içini yazmak gerekiyor.
// çünkü static= classadi.metot şeklinde olduğu için interface de saçma oluyor
	
	public boolean kullaniciKontrol(String ka, String sf);
	


}

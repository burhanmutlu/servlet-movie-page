package com.dao.abstracts;

import com.entity.Kisi;

public interface KullaniciDAO {
// interface sınıfta metot tanımlarında static olamaz. eğer olursa içini yazmak gerekiyor.
// çünkü static= classadi.metot şeklinde olduğu için interface de saçma oluyor
	
	public boolean kullaniciKontrol(Kisi k);
	
	public boolean kullaniciKayit(Kisi k);
	
	public boolean kullaniciSil(Kisi k);
	
	public int getKullaniciHesapId(Kisi k);
	


}

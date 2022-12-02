package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dao.FilmDAO;
import com.dao.KullaniciDAO;
import com.entity.Film;
import com.entity.Kategori;
import com.entity.Kisi;
import com.entity.Yonetmen;

public class Test1 {

	KullaniciDAO k = new KullaniciDAO(); 
	FilmDAO f = new FilmDAO();
	
	@Test
	public void test() {
		Kisi kisi = new Kisi();
		kisi.setId(1);
		assertTrue(k.kullaniciSil(kisi));
	}
	
	@Test
	public void test2() {
		Film film = new Film();
		Yonetmen y = new Yonetmen();
		y.setId(2);
		
		Kategori k = new Kategori();
		k.setId(2);
		
		film.setAd("yenifilmdeneme");
		film.setKategori(k);
		film.setSene(2022);
		film.setYonetmen(y);

		film.display();
	
		assertTrue(f.yeniFilmEkle(film));

	}

}

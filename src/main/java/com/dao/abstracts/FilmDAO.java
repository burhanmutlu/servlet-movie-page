package com.dao.abstracts;

import java.util.ArrayList;
import com.entity.Film;

public interface FilmDAO {

	public Film filmAyrintiGetir(int filmid);	
	
	public ArrayList<Film> butunFilmleriGetir();
	
	public ArrayList<Film> kategoriyeAitFilmleriGetir(int kategoriid);
	
	public boolean yeniFilmEkle(Film f);
	
	public boolean yeniFavoriEkle(Film f, int hesapId);
}

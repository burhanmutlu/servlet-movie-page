package com.dao.abstracts;

import java.util.ArrayList;
import com.entity.Kategori;

public interface KategoriDAO {

	public ArrayList<Kategori> butunKategorileriGetir();
	
	public boolean yeniKategoriEkle(Kategori k);
	
	public int getSonKategoriId();
	
}

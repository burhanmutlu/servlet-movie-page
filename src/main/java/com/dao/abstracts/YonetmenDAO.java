package com.dao.abstracts;

import com.entity.Yonetmen;

public interface YonetmenDAO {
	
	public boolean yeniYonetmenEkle(Yonetmen y);
	
	public int getSonYonetmenId();

}

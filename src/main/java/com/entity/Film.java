package com.entity;

public class Film {
	private int id;
	private String ad;
	private Yonetmen yonetmen;
	private Kategori kategori;
	private int sene; 
	
	public Film() {
		
	}
	
	public Film(int id, String ad, int sene) {
		super();
		this.id = id;
		this.ad = ad;
		this.sene = sene;
	}

	public Film(int id, int sene, String ad,  Yonetmen yonetmen, Kategori kategori) {
		super();
		this.id = id;
		this.ad = ad;
		this.yonetmen = yonetmen;
		this.kategori = kategori;
		this.sene = sene;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Yonetmen getYonetmen() {
		return yonetmen;
	}

	public void setYonetmen(Yonetmen yonetmen) {
		this.yonetmen = yonetmen;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	public int getSene() {
		return sene;
	}

	public void setSene(int sene) {
		this.sene = sene;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " - "+ this.ad + " - " + this.sene;
	}
	
	public void display() {
		System.out.println("id:" +id + "yonetmen:"+yonetmen.getId() + "kategori:"+kategori.getId() + "filmad:" +ad+ "sene:"+ sene); 
	}
	
	

}

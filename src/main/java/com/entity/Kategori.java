package com.entity;

public class Kategori {
	private int id;
	private String ad;
	
	public Kategori() {
		
	}

	public Kategori(int id, String ad) {
		super();
		this.id = id;
		this.ad = ad;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ad;
	}
	
	

}

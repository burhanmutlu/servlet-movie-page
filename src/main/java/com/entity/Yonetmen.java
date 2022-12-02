package com.entity;

public class Yonetmen {
	private int id;
	private String ad;
	
	public Yonetmen() {
		
	}

	public Yonetmen(int id, String ad) {
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
	
}

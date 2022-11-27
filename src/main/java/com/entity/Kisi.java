package com.entity;

public class Kisi {
	private int id;
	private String kullaniciAdi;
	private String Sifre;
	
	public Kisi() {
		
	}
	
	public Kisi(String kullaniciAdi, String sifre) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		Sifre = sifre;
	}
	
	public Kisi(int id, String kullaniciAdi, String sifre) {
		super();
		this.id = id;
		this.kullaniciAdi = kullaniciAdi;
		Sifre = sifre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return Sifre;
	}

	public void setSifre(String sifre) {
		Sifre = sifre;
	}

	
}

package net.DemirbasUygulaması.model;

import java.sql.Date;

public class MarkaYönetimi {
	protected String ID;
	protected String markaAdi;
	protected String kullaniciAdi;
	protected Date sonDuzenlenenTarih;
	
	public MarkaYönetimi() {
	}
	
	public MarkaYönetimi(String markaAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		this.markaAdi = markaAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}

	public MarkaYönetimi(String ID, String markaAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		this.ID = ID;
		this.markaAdi = markaAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}

	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getmarkaAdi() {
		return markaAdi;
	}
	public void setmarkaAdi(String markaAdi) {
		this.markaAdi = markaAdi;
	}
	public String getkullaniciAdi() {
		return kullaniciAdi;
	}
	public void setkullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public Date getSonDuzenlenenTarih() {
		return sonDuzenlenenTarih;
	}
	public void setSonDuzenlenenTarih(Date sonDuzenlenenTarih) {
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
}
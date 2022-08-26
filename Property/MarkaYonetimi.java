package demirbasUygulama.Property;

import java.sql.Date;

public class MarkaYonetimi {
	private int ID;
	private String markaAdi;
	private String kullaniciAdi;
	private Date sonDuzenlenenTarih;
	
	
	
	
	
	public MarkaYonetimi(String markaAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		this.markaAdi = markaAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
	public MarkaYonetimi(int iD, String markaAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		ID = iD;
		this.markaAdi = markaAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMarkaAdi() {
		return markaAdi;
	}
	public void setMarkaAdi(String markaAdi) {
		this.markaAdi = markaAdi;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public Date getSonDuzenlenenTarih() {
		return sonDuzenlenenTarih;
	}
	public void setSonDuzenlenenTarih(Date sonDuzenlenenTarih) {
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
	
}
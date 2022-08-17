package net.DemirbasUygulaması.model;

import java.sql.Date;

public class DemirbastipiYönetimi {
	protected int ID;
	protected String demirbasTipiYonetimiAdi;
	protected String kullaniciAdi;
	protected Date sonDuzenlenenTarih;
	
	public DemirbastipiYönetimi() {
	}
	
	public DemirbastipiYönetimi(String demirbasTipiYonetimiAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		this.demirbasTipiYonetimiAdi = demirbasTipiYonetimiAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}

	public DemirbastipiYönetimi(int ID, String demirbasTipiYonetimiAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		this.ID = ID;
		this.demirbasTipiYonetimiAdi = demirbasTipiYonetimiAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}

	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getdemirbasTipiYonetimiAdi() {
		return demirbasTipiYonetimiAdi;
	}
	public void setdemirbasTipiYonetimiAdi(String demirbasTipiYonetimiAdi) {
		this.demirbasTipiYonetimiAdi = demirbasTipiYonetimiAdi;
	}
	public String getkullaniciAdi() {
		return kullaniciAdi;
	}
	public void setkullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public Date getsonDuzenlenenTarih() {
		return sonDuzenlenenTarih;
	}
	public void setsonDuzenlenenTarih(Date sonDuzenlenenTarih) {
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
}

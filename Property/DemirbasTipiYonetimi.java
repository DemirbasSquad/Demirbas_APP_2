package demirbasUygulama.Property;

import java.sql.Date;

public class DemirbasTipiYonetimi {
	
	private int ID;
	private String demirbasTipiAdi;
	private String kullaniciAdi;
	private Date sonDuzenlenenTarih;
	
	
	
	
	
	public DemirbasTipiYonetimi(String demirbasTipiAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		this.demirbasTipiAdi = demirbasTipiAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
	
	public DemirbasTipiYonetimi(int iD, String demirbasTipiAdi, String kullaniciAdi, Date sonDuzenlenenTarih) {
		super();
		ID = iD;
		this.demirbasTipiAdi = demirbasTipiAdi;
		this.kullaniciAdi = kullaniciAdi;
		this.sonDuzenlenenTarih = sonDuzenlenenTarih;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDemirbasTipiAdi() {
		return demirbasTipiAdi;
	}
	public void setDemirbasTipiAdi(String demirbasTipiAdi) {
		this.demirbasTipiAdi = demirbasTipiAdi;
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
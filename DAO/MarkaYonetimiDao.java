package demirbasUygulama.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import demirbasUygulama.Property.MarkaYonetimi;

public class MarkaYonetimiDao {
	private String jdbcUrl = "jdbc:mysql://10.10.10.241:3306/staj2022?useSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPassword = "Staj2022staj";
	
	
	private static final String INSERT = "INSERT INTO MarkaYonetimi" + " (markaAdi, kullaniciAdi, sonDuzenlenenTarih) VALUES " +
			"(?, ?, ?);";
	private static final String UPDATE = "UPDATE MarkaYonetimi set markaAdi=?, kullaniciAdi=?, sonDuzenlenenTarih=? where ID=?;";
	private static final String DELETE = "DELETE from MarkaYonetimi where markaAdi = ?;";
	private static final String SELECT = "SELECT * from MarkaYonetimi";
	
	
	public MarkaYonetimiDao() {}
	
	protected Connection getConnection() {
		Connection myCon = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myCon = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		}
		catch(SQLException sqlExc) {
			sqlExc.printStackTrace();
		}
		catch(ClassNotFoundException cnfExc) {
			cnfExc.printStackTrace();
		}
		return myCon;
	}
	
	
	public void markaEkle(MarkaYonetimi my) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, my.getMarkaAdi());
			ps.setString(2, my.getKullaniciAdi());
			ps.setDate(3, my.getSonDuzenlenenTarih());
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public void markaGuncelle(MarkaYonetimi my) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1, my.getMarkaAdi());
			ps.setString(2, my.getKullaniciAdi());
			ps.setDate(3, my.getSonDuzenlenenTarih());
			ps.setInt(4, my.getID());
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public void markaSil(String markaAdi) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setString(1, markaAdi);
			System.out.println(ps);
			ps.execute();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public ArrayList<MarkaYonetimi> markaListele(){
		ArrayList<MarkaYonetimi> markalar = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String markaAdi = rs.getString("markaAdi");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				markalar.add(new MarkaYonetimi(ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih));
			}
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return markalar;
	}
	
	
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
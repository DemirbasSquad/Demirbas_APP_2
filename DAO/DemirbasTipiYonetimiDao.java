package demirbasUygulama.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import demirbasUygulama.Property.DemirbasTipiYonetimi;

public class DemirbasTipiYonetimiDao {
	
	private String jdbcUrl = "jdbc:mysql://10.10.10.241:3306/staj2022?useSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPassword = "Staj2022staj";
	
	
	private static final String INSERT = "INSERT INTO DemirbasTipiYonetimi" + " (demirbasTipiAdi, kullaniciAdi, sonDuzenlenenTarih) VALUES " +
			"(?, ?, ?);";
	private static final String UPDATE = "UPDATE DemirbasTipiYonetimi set demirbasTipiAdi=?, kullaniciAdi=?, sonDuzenlenenTarih=? where ID=?;";
	private static final String DELETE = "DELETE from DemirbasTipiYonetimi where ID = ?;";
	private static final String SELECT = "SELECT * from DemirbasTipiYonetimi";
	
	
	public DemirbasTipiYonetimiDao() {}
	
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
	
	
	public void tipEkle(DemirbasTipiYonetimi dty) {
		System.out.println(INSERT);
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, dty.getDemirbasTipiAdi());
			ps.setString(2, dty.getKullaniciAdi());
			ps.setDate(3, dty.getSonDuzenlenenTarih());
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public void tipSil(String tip) {
		System.out.println(DELETE);
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE);
			ps.setString(1, tip);
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public void tipGuncelle(DemirbasTipiYonetimi tip) {
		System.out.println(UPDATE);
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE);
			ps.setString(1, tip.getDemirbasTipiAdi());
			ps.setString(2, tip.getKullaniciAdi());
			ps.setDate(3, tip.getSonDuzenlenenTarih());
			ps.setInt(4, tip.getID());
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	
	public ArrayList<DemirbasTipiYonetimi> listele(){
		ArrayList<DemirbasTipiYonetimi> tipler = new ArrayList<>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT);
			System.out.println(ps);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String demirbasTipiAdi = rs.getString("demirbasTipiAdi");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				tipler.add(new DemirbasTipiYonetimi(ID, demirbasTipiAdi, kullaniciAdi, sonDuzenlenenTarih));
			}
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		return tipler;
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
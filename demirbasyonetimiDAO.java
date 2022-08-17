package demirbasUygulama.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demirbasUygulama.property.DemirbasYonetimi;

public class demirbasyonetimiDAO {
	private String jdbcUrl = "jdbc:mysql://10.10.10.241:3306/staj2022?useSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPassword = "Staj2022staj";

	private static final String INSERT_USERS_SQL = "INSERT INTO DemirbasYonetimi"
			+ " (ID, demirbasAdi, markaID, model, demirbasTipiID, bagliOlduguDemirbas, imhaKaydi, etiket, acilDurumEtiketi, satinAlan, lokasyon, aciklama, ozellik, sonDuzenlenenTarih , alisTarih, fatura, BGetiketi , seriNo) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ?);";

	//private static final String SELECT_USERS_BY_ID = "SELECT ID,demirbasAdi, markaID, model, demirbasTipiID, bagliOlduguDemirbas, imhaKaydi, etiket, acilDurumEtiketi, satinAlan, lokasyon, aciklama, ozellik, kullaniciAdi, sonDuzenlenenTarih from demirbasyonetimi where ID = ?";
	private static final String SELECT_ALL_USERS = "select * from DemirbasYonetimi";
	private static final String DELETE_USERS_SQL = "DELETE from DemirbasYonetimi where ID = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE DemirbasYonetimi set demirbasAdi=?, markaID=?, model=? , demirbasTipiID=? , bagliOlduguDemirbas=? , imhaKaydi = ?, etiket=?, acilDurumEtiketi=?, satinAlan=?, lokasyon=?, aciklama=?, ozellik=?, kullaniciAdi=? ,fatura=? , BGetiketi=?, seriNo=? where ID=?;";

	public demirbasyonetimiDAO() {
	}

	protected Connection getConnection() {
		Connection myCon = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myCon = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		} catch (SQLException sqlExc) {
			sqlExc.printStackTrace();
		} catch (ClassNotFoundException cnfExc) {
			cnfExc.printStackTrace();
		}
		return myCon;
	}

	public void insertUser(DemirbasYonetimi demirbasyonetimi) throws SQLException {
		System.out.println(INSERT_USERS_SQL);

		try {
			Connection myCon = getConnection();
			PreparedStatement pStmt = myCon.prepareStatement(INSERT_USERS_SQL);

			pStmt.setString(1, demirbasyonetimi.getID());
			pStmt.setString(2, demirbasyonetimi.getDemirbasAdi());
			pStmt.setString(3, demirbasyonetimi.getMarkaID());
			pStmt.setString(4, demirbasyonetimi.getModel());
			pStmt.setString(5, demirbasyonetimi.getDemirbasTipiID());
			pStmt.setString(6, demirbasyonetimi.getBagliOlduguDemirbas());
			pStmt.setString(7, demirbasyonetimi.getImhaKaydi());
			pStmt.setString(8, demirbasyonetimi.getEtiket());
			pStmt.setString(9, demirbasyonetimi.getAcilDurumEtiketi());
			pStmt.setString(10, demirbasyonetimi.getSatinAlan());
			pStmt.setString(11, demirbasyonetimi.getLokasyon());
			pStmt.setString(12, demirbasyonetimi.getAciklama());
			pStmt.setString(13, demirbasyonetimi.getOzellik());
			pStmt.setDate(14, demirbasyonetimi.getSonDuzenlenenTarih());
			pStmt.setDate(15, demirbasyonetimi.getAlisTarih());
			pStmt.setString(16, demirbasyonetimi.getFatura());
			pStmt.setString(17, demirbasyonetimi.getBGetiketi());
			pStmt.setString(18, demirbasyonetimi.getSeriNo());

			System.out.println(pStmt);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	public List<DemirbasYonetimi> selectAllUsers() {
		List<DemirbasYonetimi> demirbasyonetimi = new ArrayList<>();

		try {
			Connection myCon = getConnection();
			PreparedStatement pStmt = myCon.prepareStatement(SELECT_ALL_USERS);

			System.out.println(pStmt);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String ID = rs.getString("ID");
				String demirbasAdi = rs.getString("demirbasAdi");
				String markaID = rs.getString("markaID");
				String model = rs.getString("model");
				String demirbasTipiID = rs.getString("demirbasTipiID");
				String bagliOlduguDemirbas = rs.getString("bagliOlduguDemirbas");
				String imhaKaydi = rs.getString("imhaKaydi");
				String etiket = rs.getString("etiket");
				String acilDurumEtiketi = rs.getString("acilDurumEtiketi");
				String satinAlan = rs.getString("satinAlan");
				String lokasyon = rs.getString("lokasyon");
				String aciklama = rs.getString("aciklama");
				String ozellik = rs.getString("ozellik");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				Date alisTarih = rs.getDate("alisTarih");
				String fatura = rs.getString("fatura");
				String BGetiketi = rs.getString("BGetiketi");
				String seriNo = rs.getString("seriNo");

				demirbasyonetimi.add(new DemirbasYonetimi(ID, demirbasAdi, markaID, model, demirbasTipiID,
						bagliOlduguDemirbas, imhaKaydi, etiket, acilDurumEtiketi, satinAlan, lokasyon, aciklama,
						ozellik, kullaniciAdi, sonDuzenlenenTarih, alisTarih, fatura, BGetiketi, seriNo));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return demirbasyonetimi;
	}

	public void deleteUser(String ID) throws SQLException {

		try (Connection myCon = getConnection(); PreparedStatement pStmt = myCon.prepareStatement(DELETE_USERS_SQL);) {
			pStmt.setString(1, ID);

		}

	}

	public void updateUser(DemirbasYonetimi demirbasyonetimi) throws SQLException {
		
		
		System.out.println(UPDATE_USERS_SQL);
		
		try (Connection myCon = getConnection(); 
			PreparedStatement pStmt = myCon.prepareStatement(UPDATE_USERS_SQL);) {
			
			pStmt.setString(1, demirbasyonetimi.getDemirbasAdi());
			pStmt.setString(2, demirbasyonetimi.getMarkaID());
			pStmt.setString(3, demirbasyonetimi.getModel());
			pStmt.setString(4, demirbasyonetimi.getDemirbasTipiID());
			pStmt.setString(5, demirbasyonetimi.getBagliOlduguDemirbas());
			pStmt.setString(6, demirbasyonetimi.getImhaKaydi());
			pStmt.setString(7, demirbasyonetimi.getEtiket());
			pStmt.setString(8, demirbasyonetimi.getAcilDurumEtiketi());
			pStmt.setString(9, demirbasyonetimi.getSatinAlan());
			pStmt.setString(10, demirbasyonetimi.getLokasyon());
			pStmt.setString(11, demirbasyonetimi.getAciklama());
			pStmt.setString(12, demirbasyonetimi.getOzellik());
			pStmt.setString(13, demirbasyonetimi.getKullaniciAdi());
			pStmt.setDate(13, demirbasyonetimi.getSonDuzenlenenTarih());
			pStmt.setString(14, demirbasyonetimi.getFatura());
			pStmt.setString(15, demirbasyonetimi.getBGetiketi());
			pStmt.setString(16, demirbasyonetimi.getSeriNo());
			pStmt.setString(17, demirbasyonetimi.getID());

			System.out.println(pStmt);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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

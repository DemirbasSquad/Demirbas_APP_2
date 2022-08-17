package net.DemirbasUygulaması.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import net.DemirbasUygulaması.model.DemirbastipiYönetimi;




public class DemirbastipiDao {
	private String jdbcURL = "jdbc:mysql://10.10.10.241:3306/staj2022?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Staj2022staj";

	private static final String INSERT_Demirbastipiy_SQL = "INSERT INTO demirbastipiyonetimi" + "  (ID, demirbasTipiYonetimiAdi, kullaniciAdi, sonDuzenlenenTarih) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select ID,demirbasTipiYonetimiAdi,kullaniciAdi,sonDuzenlenenTarih from demirbastipiyonetimi where ID =?";
	private static final String SELECT_ALL_Demirbastipiy = "select * from demirbastipiyonetimi";
	private static final String DELETE_Demirbastipiy_SQL = "delete from demirbastipiyonetimi where ID = ?;";
	private static final String UPDATE_Demirbastipiy_SQL = "update demirbastipiyonetimi set demirbasTipiYonetimiAdi = ?,kullaniciAdi= ?, sonDuzenlenenTarih =? where ID = ?;";
	
	public DemirbastipiDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertDemirbastipi(DemirbastipiYönetimi Demirbastipi) throws SQLException {
		System.out.println(INSERT_Demirbastipiy_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Demirbastipiy_SQL)) {
			preparedStatement.setInt(1, Demirbastipi.getID());
			preparedStatement.setString(2, Demirbastipi.getdemirbasTipiYonetimiAdi());
			preparedStatement.setString(3, Demirbastipi.getkullaniciAdi());
			preparedStatement.setDate(4, Demirbastipi.getsonDuzenlenenTarih());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public DemirbastipiYönetimi selectDemirbastipi(int ID) {
		DemirbastipiYönetimi Demirbastipi = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, ID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String demirbasTipiYonetimiAdi = rs.getString("demirbasTipiYonetimiAdi");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				Demirbastipi = new DemirbastipiYönetimi(ID, demirbasTipiYonetimiAdi, kullaniciAdi, sonDuzenlenenTarih);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Demirbastipi;
	}

	public List<DemirbastipiYönetimi> selectAllDemirbastipiy() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DemirbastipiYönetimi> demirbastipiyonetimi = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Demirbastipiy);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String demirbasTipiYonetimiAdi = rs.getString("demirbasTipiYonetimiAdi");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				demirbastipiyonetimi.add(new DemirbastipiYönetimi(ID, demirbasTipiYonetimiAdi, kullaniciAdi, sonDuzenlenenTarih));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return demirbastipiyonetimi;
	}

	public boolean deleteDemirbastipi(int ID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_Demirbastipiy_SQL);) {
			statement.setInt(1, ID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateDemirbastipi(DemirbastipiYönetimi Demirbastipi) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_Demirbastipiy_SQL);) {
			System.out.println("updated Demirbastipi:"+statement);
			statement.setString(1, Demirbastipi.getdemirbasTipiYonetimiAdi());
			statement.setString(2, Demirbastipi.getkullaniciAdi());
			statement.setDate(3, Demirbastipi.getsonDuzenlenenTarih());
			statement.setInt(4, Demirbastipi.getID());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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
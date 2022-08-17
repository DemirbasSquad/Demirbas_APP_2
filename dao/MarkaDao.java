package net.DemirbasUygulaması.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.DemirbasUygulaması.model.MarkaYönetimi;



public class MarkaDao {
	private String jdbcURL = "jdbc:mysql://10.10.10.241:3306/staj2022?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Staj2022staj";

	private static final String INSERT_markay_SQL = "INSERT INTO markayonetimi" + "  (ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select ID,markaAdi,kullaniciAdi,sonDuzenlenenTarih from markayonetimi where ID =?";
	private static final String SELECT_ALL_markay = "select * from markayonetimi";
	private static final String DELETE_markay_SQL = "delete from markayonetimi where ID = ?;";
	private static final String UPDATE_markay_SQL = "update markayonetimi set markaAdi = ?,kullaniciAdi= ?, sonDuzenlenenTarih =? where ID = ?;";
	
	public MarkaDao() {
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

	public void insertMarka(MarkaYönetimi Marka) throws SQLException {
		System.out.println(INSERT_markay_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_markay_SQL)) {
			preparedStatement.setString(1, Marka.getID());
			preparedStatement.setString(2, Marka.getmarkaAdi());
			preparedStatement.setString(3, Marka.getkullaniciAdi());
			preparedStatement.setDate(4, Marka.getSonDuzenlenenTarih());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public MarkaYönetimi selectMarka(String ID) {
		MarkaYönetimi Marka = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, ID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String markaAdi = rs.getString("markaAdi");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				Marka = new MarkaYönetimi(ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Marka;
	}

	public List<MarkaYönetimi> selectAllmarkay() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<MarkaYönetimi> markayonetimi = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_markay);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ID = rs.getString("ID");
				String markaAdi = rs.getString("markaAdi");
				String kullaniciAdi = rs.getString("kullaniciAdi");
				Date sonDuzenlenenTarih = rs.getDate("sonDuzenlenenTarih");
				markayonetimi.add(new MarkaYönetimi(ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return markayonetimi;
	}

	public boolean deleteMarka(String ID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_markay_SQL);) {
			statement.setString(1, ID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateMarka(MarkaYönetimi Marka) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_markay_SQL);) {
			System.out.println("updated Marka:"+statement);
			statement.setString(1, Marka.getmarkaAdi());
			statement.setString(2, Marka.getkullaniciAdi());
			statement.setDate(3, Marka.getSonDuzenlenenTarih());
			statement.setString(4, Marka.getID());

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
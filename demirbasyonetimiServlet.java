package demirbasUygulama.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import demirbasUygulama.DAO.*;
import demirbasUygulama.property.*;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/Demirbas/*")
public class demirbasyonetimiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private demirbasyonetimiDAO demirbasyonetimiDAO;

	public void init() {
		demirbasyonetimiDAO = new demirbasyonetimiDAO();
	}

	public demirbasyonetimiServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/new":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			listUser(request, response);
		} catch (SQLException ex) {
			throw new ServletException();
		}

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<demirbasyonetimi> listUser = demirbasyonetimiDAO.selectAllUsers();

		String denemeJson = new Gson().toJson(listUser);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			insertUser(req, resp);
		} catch (Exception e) {
			throw new ServletException(e.getLocalizedMessage());
		}

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {

		UUID uuid = UUID.randomUUID();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

		String ID = uuid.toString();
		String demirbasAdi = request.getParameter("demirbasAdi");
		String markaID = request.getParameter("markaID");
		String model = request.getParameter("model");
		String demirbasTipiID = request.getParameter("demirbasTipiID");
		String bagliOlduguDemirbas = request.getParameter("bagliOlduguDemirbas");
		String imhaKaydi = request.getParameter("imhaKaydi");
		String etiket = request.getParameter("etiket");
		String acilDurumEtiketi = request.getParameter("acilDurumEtiketi");
		String satinAlan = request.getParameter("satinAlan");
		String lokasyon = request.getParameter("lokasyon");
		String aciklama = request.getParameter("aciklama");
		String ozellik = request.getParameter("ozellik");
		Date sonDuzenlenenTarih = new java.sql.Date(System.currentTimeMillis());
		Date alisTarih = new java.sql.Date(sdf.parse(request.getParameter("alisTarih")).getTime());
		String fatura = request.getParameter("fatura");
		String BGetiketi = request.getParameter("BGetiketi");
		String seriNo = request.getParameter("seriNo");

		demirbasyonetimi newUser = new demirbasyonetimi(ID, demirbasAdi, markaID, model, demirbasTipiID,
				bagliOlduguDemirbas, imhaKaydi, etiket, acilDurumEtiketi, satinAlan, lokasyon, aciklama, ozellik,
				sonDuzenlenenTarih, alisTarih, fatura, BGetiketi, seriNo);
		demirbasyonetimiDAO.insertUser(newUser);

		String denemeJson = new Gson().toJson(newUser);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {

		

		String ID = request.getParameter("ID");
		String demirbasAdi = request.getParameter("demirbasAdi");
		String markaID = request.getParameter("markaID");
		String model = request.getParameter("model");
		String demirbasTipiID = request.getParameter("demirbasTipiID");
		String bagliOlduguDemirbas = request.getParameter("bagliOlduguDemirbas");
		String imhaKaydi = request.getParameter("imhaKaydi");
		String etiket = request.getParameter("etiket");
		String acilDurumEtiketi = request.getParameter("acilDurumEtiketi");
		String satinAlan = request.getParameter("satinAlan");
		String lokasyon = request.getParameter("lokasyon");
		String aciklama = request.getParameter("aciklama");
		String ozellik = request.getParameter("ozellik");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = new java.sql.Date(System.currentTimeMillis());
		String fatura = request.getParameter("fatura");
		String BGetiketi = request.getParameter("BGetiketi");
		String seriNo = request.getParameter("seriNo");

		demirbasyonetimi userUpdate = new demirbasyonetimi(ID, demirbasAdi, markaID, model, demirbasTipiID,
				bagliOlduguDemirbas, imhaKaydi, etiket, acilDurumEtiketi, satinAlan, lokasyon, aciklama, ozellik,kullaniciAdi,
				sonDuzenlenenTarih, fatura, BGetiketi, seriNo);

		demirbasyonetimiDAO.updateUser(userUpdate);

		String denemeJson = new Gson().toJson(userUpdate);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String ID = request.getParameter("ID");
		demirbasyonetimiDAO.deleteUser(ID);

	}

}
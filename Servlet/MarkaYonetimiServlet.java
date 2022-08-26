package demirbasUygulama.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import demirbasUygulama.DAO.MarkaYonetimiDao;
import demirbasUygulama.Property.MarkaYonetimi;

/**
 * Servlet implementation class MarkaYonetimiServlet
 */
@WebServlet("/MarkaYonetimiServlet/*")
public class MarkaYonetimiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MarkaYonetimiDao markaDAO;
	
	public void init() {
		markaDAO = new MarkaYonetimiDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkaYonetimiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listele(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/yeni": 
				markaEkle(request, response);
				break;
			case "/sil":
				markaSil(request, response);
				break;
			case "/guncelle":
				markaGuncelle(request, response);
				break;
			}	
		}
		catch (Exception e) {
			throw new ServletException();
		}
	}
	
	
	
	
	private void markaEkle(HttpServletRequest request, HttpServletResponse response) {
		String markaAdi = request.getParameter("markaAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = new java.sql.Date (System.currentTimeMillis());
		MarkaYonetimi marka = new MarkaYonetimi(markaAdi, kullaniciAdi, sonDuzenlenenTarih);
		markaDAO.markaEkle(marka);
	}

	private void markaSil(HttpServletRequest request, HttpServletResponse response) {
		String markaAdi = request.getParameter("markaAdi");
		markaDAO.markaSil(markaAdi);
	}

	private void markaGuncelle(HttpServletRequest request, HttpServletResponse response) {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String markaAdi = request.getParameter("markaAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = new java.sql.Date (System.currentTimeMillis());
		MarkaYonetimi marka = new MarkaYonetimi(ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih);
		markaDAO.markaGuncelle(marka);
	}

	private void listele(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<MarkaYonetimi> markalar = markaDAO.markaListele();
		String denemeJson = new Gson().toJson(markalar);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();
	}
}
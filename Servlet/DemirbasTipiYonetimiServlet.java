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

import demirbasUygulama.DAO.DemirbasTipiYonetimiDao;
import demirbasUygulama.Property.DemirbasTipiYonetimi;
/**
 * Servlet implementation class DemirbasTipiYonetimiServlet
 */
@WebServlet("/DemirbasTipiYonetimiServlet/*")
public class DemirbasTipiYonetimiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DemirbasTipiYonetimiDao dtyDAO;
    
	public void init() {
		dtyDAO = new DemirbasTipiYonetimiDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemirbasTipiYonetimiServlet() {
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
				tipEkle(request, response);
				break;
			case "/sil":
				tipSil(request, response);
				break;
			case "/guncelle":
				tipGuncelle(request, response);
				break;
			}	
		}
		catch (Exception e) {
			throw new ServletException();
		}
	}
	
	
	private void tipGuncelle(HttpServletRequest request, HttpServletResponse response) {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String demirbasTipiAdi = request.getParameter("demirbasTipiAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = new java.sql.Date (System.currentTimeMillis());
		DemirbasTipiYonetimi dty = new DemirbasTipiYonetimi(ID, demirbasTipiAdi, kullaniciAdi, sonDuzenlenenTarih);
		dtyDAO.tipGuncelle(dty);
	}

	private void tipSil(HttpServletRequest request, HttpServletResponse response) {
		String ID = request.getParameter("ID");
		dtyDAO.tipSil(ID);
	}

	private void tipEkle(HttpServletRequest request, HttpServletResponse response) {
		
		String demirbasTipiAdi = request.getParameter("demirbasTipiAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = new java.sql.Date (System.currentTimeMillis());
		
		DemirbasTipiYonetimi dty = new DemirbasTipiYonetimi(demirbasTipiAdi, kullaniciAdi, sonDuzenlenenTarih);
		dtyDAO.tipEkle(dty);
	}

	private void listele(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<DemirbasTipiYonetimi> kullanicilar = dtyDAO.listele();
		String denemeJson = new Gson().toJson(kullanicilar);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();
	}
}
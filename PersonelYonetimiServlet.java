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
@WebServlet("/Kullanici/*")
public class PersonelYonetimiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonelYonetimiDAO PersonelYonetimiDAO;
    
    public void init() {
    	PersonelYonetimiDAO = new PersonelYonetimiDAO();
    }
    
    public PersonelYonetimiServlet() {
        super();        
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		try {
			switch (action) {
			case "/new": 
				insertUser(request, response);
				break;
			case "/delete":
				durum(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			}	
		}
		catch(SQLException | ParseException ex) {
			throw new ServletException();
		}
		
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		try {

				listUser(request, response);
		}
		catch(SQLException ex) {
			throw new ServletException();
		}
		
	}
	
	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		
		List <PersonelYonetimi> listUser = PersonelYonetimiDAO.selectAllUsers();
		
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
		}
		catch(Exception e) {
			throw new ServletException(e.getLocalizedMessage());
		}
		
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException{
		
		UUID uuid = UUID.randomUUID();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		String ID = uuid.toString();
		String personelAdi = request.getParameter("personelAdi");
		String personelSoyadi = request.getParameter("personelSoyadi");
		String personelSicilNumarasi = request.getParameter("personelSicilNumarasi");
		String proje = request.getParameter("proje");
		Date sonDuzenlenenTarih = new java.sql.Date (System.currentTimeMillis());
		Date girisTarihi = new java.sql.Date(sdf.parse(request.getParameter("girisTarihi")).getTime());
		String durum = request.getParameter("durum");
		
		PersonelYonetimi newUser = new PersonelYonetimi(ID, personelAdi, personelSoyadi , personelSicilNumarasi , proje , sonDuzenlenenTarih, girisTarihi, durum);
		PersonelYonetimiDAO.insertUser(newUser);
		
		
		String denemeJson = new Gson().toJson(newUser);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();
		
		
		
	}
	
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ServletException{
		
		String ID = request.getParameter("ID");
		String personelAdi = request.getParameter("personelAdi");
		String personelSoyadi = request.getParameter("personelSoyadi");
		String personelSicilNumarasi = request.getParameter("personelSicilNumarasi");
		String proje = request.getParameter("proje");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = new java.sql.Date (System.currentTimeMillis());
		//String durum = request.getParameter("durum");
		
		PersonelYonetimi userUpdate = new PersonelYonetimi(ID, personelAdi, personelSoyadi , personelSicilNumarasi , proje, kullaniciAdi , sonDuzenlenenTarih);
		PersonelYonetimiDAO.updateUser(userUpdate);
		
		listUser(request, response);
		//select update sonrası kullanıcı bilgisi
		
		
		String denemeJson = new Gson().toJson(userUpdate);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(denemeJson);
		out.flush();
	}
	
	
	private void durum(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		//arraylist
		String durum = request.getParameter("durum");
		PersonelYonetimiDAO.durum(durum);
	
		
		
	}

}
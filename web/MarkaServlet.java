package net.DemirbasUygulaması.web;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.DemirbasUygulaması.dao.MarkaDao;
import net.DemirbasUygulaması.model.MarkaYönetimi;



@WebServlet("/")
public class MarkaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MarkaDao MarkaDAO;
	
	public void init() {
		MarkaDAO = new MarkaDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertMarka(request, response);
				break;
			case "/delete":
				deleteMarka(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateMarka(request, response);
				break;
			
			default:
				listMarka(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listMarka(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<MarkaYönetimi> listMarka = MarkaDAO.selectAllmarkay();
		request.setAttribute("listMarka", listMarka);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnaSayfa.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnaSayfa.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String ID = request.getParameter("ID");
		MarkaYönetimi existingMarka = MarkaDAO.selectMarka(ID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnaSayfa.jsp");
		request.setAttribute("Marka", existingMarka);
		dispatcher.forward(request, response);

	}

	private void insertMarka(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String ID = request.getParameter("ID");
		String markaAdi = request.getParameter("markaAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = Date.valueOf(String.valueOf(request.getParameter("sonDuzenlenenTarih")));
		MarkaYönetimi newMarka = new MarkaYönetimi(ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih);
		MarkaDAO.insertMarka(newMarka);
		response.sendRedirect("list");
	}

	private void updateMarka(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String ID = request.getParameter("ID");
		String markaAdi = request.getParameter("markaAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = Date.valueOf(String.valueOf(request.getParameter("sonDuzenlenenTarih")));

		MarkaYönetimi book = new MarkaYönetimi(ID, markaAdi, kullaniciAdi, sonDuzenlenenTarih);
		MarkaDAO.updateMarka(book);
		response.sendRedirect("list");
	}

	private void deleteMarka(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String ID = request.getParameter("ID");
		MarkaDAO.deleteMarka(ID);
		response.sendRedirect("list");

	}


}
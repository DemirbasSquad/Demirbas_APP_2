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



import net.DemirbasUygulaması.dao.DemirbastipiDao;
import net.DemirbasUygulaması.model.DemirbastipiYönetimi;


@WebServlet("/")
public class DemirbastipiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DemirbastipiDao DemirbastipiDao;
	
	public void init() {
		DemirbastipiDao = new DemirbastipiDao();
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
				insertDemirbastipi(request, response);
				break;
			case "/delete":
				deleteDemirbastipi(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateDemirbastipi(request, response);
				break;
			
			default:
				listDemirbastipi(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDemirbastipi(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<DemirbastipiYönetimi> listDemirbastipi = DemirbastipiDao.selectAllDemirbastipiy();
		request.setAttribute("listDemirbastipi", listDemirbastipi);
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
		int ID = Integer.parseInt(request.getParameter("ID"));
		DemirbastipiYönetimi existingDemirbastipi = DemirbastipiDao.selectDemirbastipi(ID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnaSayfa.jsp");
		request.setAttribute("Demirbastipi", existingDemirbastipi);
		dispatcher.forward(request, response);

	}

	private void insertDemirbastipi(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String demirbasTipiYonetimiAdi = request.getParameter("demirbasTipiYonetimiAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = Date.valueOf(String.valueOf(request.getParameter("sonDuzenlenenTarih")));
		DemirbastipiYönetimi newDemirbastipi = new DemirbastipiYönetimi(ID, demirbasTipiYonetimiAdi, kullaniciAdi, sonDuzenlenenTarih);
		DemirbastipiDao.insertDemirbastipi(newDemirbastipi);
		response.sendRedirect("list");
	}

	private void updateDemirbastipi(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String demirbasTipiYonetimiAdi = request.getParameter("demirbasTipiYonetimiAdi");
		String kullaniciAdi = request.getParameter("kullaniciAdi");
		Date sonDuzenlenenTarih = Date.valueOf(String.valueOf(request.getParameter("sonDuzenlenenTarih")));

		DemirbastipiYönetimi book = new DemirbastipiYönetimi(ID, demirbasTipiYonetimiAdi, kullaniciAdi, sonDuzenlenenTarih);
		DemirbastipiDao.updateDemirbastipi(book);
		response.sendRedirect("list");
	}

	private void deleteDemirbastipi(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		DemirbastipiDao.deleteDemirbastipi(ID);
		response.sendRedirect("list");

	}


}
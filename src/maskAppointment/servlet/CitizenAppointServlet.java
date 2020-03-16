package maskAppointment.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maskAppointment.dao.CitizenDAO;
import maskAppointment.dao.CitizenDaoImpl;
import maskAppointment.pojo.Citizen;

/**
 * Servlet implementation class CitizenAppointServlet
 */
@WebServlet("/citizenAppointServlet")
public class CitizenAppointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitizenAppointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		/**
		 * 封装获得的数据
		 */
		String name = request.getParameter("name");
		String idNumber = request.getParameter("idNumber");
		String phone = request.getParameter("phone");
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		System.out.println(idNumber);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(orderNum);
		Citizen citizen = new Citizen();
		citizen.setPhone(phone);
		citizen.setIdNumber(idNumber);
		citizen.setOrderNum(orderNum);
		citizen.setName(name);
		CitizenDAO citizenDAO = new CitizenDaoImpl();
		citizenDAO.appointment(citizen);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

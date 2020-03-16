package maskAppointment.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maskAppointment.pojo.SystemTime;
import maskAppointment.dao.SystemTimeDAO;
import maskAppointment.dao.SystemTimeDAOImpl;

/**
 * Servlet implementation class SystemTimeServlet
 * 该方法用于保存前端的一次记录（设置开始时间，结束时间，轮次编号采用自增，需要参数：开始时间，结束时间）
 */
@WebServlet("/SystemTimeServlet")
public class SystemTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//将设置的时间数据存入数据库中的SystemTime;
		SystemTime systemtime = new SystemTime();
		systemtime.setOpentime(Timestamp.valueOf(request.getParameter("opentime")));
		systemtime.setClosetime(Timestamp.valueOf(request.getParameter("closetime")));
		SystemTimeDAO systemTimeDAO= new SystemTimeDAOImpl();
		systemTimeDAO.add(systemtime);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
}

package maskAppointment.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maskAppointment.dao.BallotRecordDAO;
import maskAppointment.dao.BallotRecordDAOImpl;
import maskAppointment.dao.SystemTimeDAO;
import maskAppointment.dao.SystemTimeDAOImpl;
import maskAppointment.pojo.BallotRecord;

/**
 * Servlet implementation class ShowList
 */
@WebServlet("/ShowList")
public class ShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 获取当前的最新轮次
		int temp = 0; // 保存当前的轮次
		SystemTimeDAO systemTimeDAO = new SystemTimeDAOImpl();
		temp = systemTimeDAO.getTotal();// 这是当前的轮次
		try {
		BallotRecordDAO ballotRecordDAO = new BallotRecordDAOImpl();
		List<BallotRecord> ballotRecords = ballotRecordDAO.getList();
		for (BallotRecord i : ballotRecords) {
			if (temp==i.getBallotRound()) {// 如果中签轮次是最新的，设置数据
				request.setAttribute("ballotRecords", ballotRecords);
			}
		}}
		catch (Exception e) {
			// TODO: handle exception
		}


		// 设置的数据传入前端界面
		request.getRequestDispatcher("ballot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

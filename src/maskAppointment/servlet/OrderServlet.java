package maskAppointment.servlet;


import maskAppointment.dao.CitizenDAOImpl;
import maskAppointment.dao.MaskDAOImpl;
import maskAppointment.dao.OrderInformationDAOImpl;
import maskAppointment.dao.SystemTimeDAOImpl;
import maskAppointment.pojo.Citizen;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

import maskAppointment.pojo.OrderInformation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String idNum=request.getParameter("idNumber");
		String name=request.getParameter("name");
		String phoneNum=request.getParameter("phone");
		int mask=Integer.parseInt(request.getParameter("orderMask"));
		int round=0;
		
		Citizen c=new Citizen(idNum,name,phoneNum,mask,round);

		CitizenDAOImpl cDaoI=new CitizenDAOImpl();

		if(cDaoI.hasOne(idNum)==null){
			cDaoI.insert(c);
		}

		if(this.isInformationFormal(idNum, name, mask,request)) {
			OrderInformationDAOImpl oip=new OrderInformationDAOImpl();
			oip.insert(new OrderInformation(idNum,round));
			OrderInformation rs=oip.select(idNum,round);
			if(rs!=null)
				request.setAttribute("OrderNumber",String.valueOf(rs.getOrderId()));
		}else {
			request.setAttribute("OrderNumber", null);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean isInformationFormal(String idNum,String name,int mask,HttpServletRequest request) {
		
		MaskDAOImpl mi=new MaskDAOImpl();
		CitizenDAOImpl ci=new CitizenDAOImpl();
		SystemTimeDAOImpl si=new SystemTimeDAOImpl();
		OrderInformationDAOImpl oi=new OrderInformationDAOImpl();
		SystemTimeDAOImpl sysi=new SystemTimeDAOImpl();
		int round=si.getTotal();
		Timestamp openDate=sysi.getOpentime();
		Timestamp closeDate=sysi.getClosetime();
		Timestamp nowTime=new Timestamp(System.currentTimeMillis());
		
		if(nowTime.before(openDate)||closeDate.before(nowTime)||(int)request.getAttribute("start")==0)
			return false;
		if(ci.hasOne(idNum)!=null)
			return false;
		else {
			if(oi.select(idNum, round)!=null)
				return false;
		}
		if(mask>mi.getMask().getMaxCount())
			return false;
		return true;
	}
}

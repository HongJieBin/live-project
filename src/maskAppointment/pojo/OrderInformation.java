package maskAppointment.pojo;


public class OrderInformation {
//	orderId varchar(40) not null primary key comment "ԤԼ���",
//    idNumber varchar(20) not null comment "�������֤��",
//    orderRound int(4) not null comment "ԤԼ����",
//    foreign key(idNumber) references citizen(idNumber)
    
    private String orderId;
    private String idNumber;
    private int orderRound;
    
    
	public OrderInformation(String orderId, String idNumber, int orderRound) {
		super();
		this.orderId = orderId;
		this.idNumber = idNumber;
		this.orderRound = orderRound;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getOrderRound() {
		return orderRound;
	}
	public void setOrderRound(int orderRound) {
		this.orderRound = orderRound;
	}
    
    
}

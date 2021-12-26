import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;


public class Order {

private static int count=0;
private int order_code;
private Appliance model;
private String customer_name;
private String customer_phone;
private LocalDate order_date;
private LocalDate arrival_date;
private double order_cost;
private int order_pieces;
private String order_status;
private static HashMap<Integer, Order> Orders = new HashMap<Integer, Order>();

public Order(Appliance model,int order_code, String customer_name, String customer_phone,LocalDate order_date, LocalDate arrival_date,
		double order_cost,int order_pieces, String order_status) {
	count++;
	Orders.put(count,this);
	this.order_code=order_code;
	this.model = model;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.order_date = order_date;
	this.arrival_date = arrival_date;
	this.order_cost = order_cost;
	this.order_pieces=order_pieces;
	this.order_status = order_status;
}

//Constructor without order_code
public Order(Appliance model, String customer_name, String customer_phone,LocalDate order_date, LocalDate arrival_date,
		double order_cost,int order_pieces, String order_status) {
	count++;
	Orders.put(count,this);
	this.order_code=count;
	this.model = model;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.order_date =order_date;
	this.arrival_date = arrival_date;
	this.order_cost = order_cost;
	this.order_pieces=order_pieces;
	this.order_status = order_status;
}

public static HashMap<Integer, Order> getOrders() {
	return Orders;
}

public int getOrder_code() {
	return order_code;
}

public Appliance getModel() {
	return model;
}

public String getCustomer_name() {
	return customer_name;
}

public String getCustomer_phone() {
	return customer_phone;
}

public LocalDate getOrder_date() {
	return order_date;
}

public LocalDate getArrival_date() {
	return arrival_date;
}

public double getOrder_cost() {
	return order_cost;
}

public int getOrder_pieces() {
	return order_pieces;
}

public String getOrder_status() {
	return order_status;
}

@Override
public String toString() {
	return "�������� ����������� \n������� ����������=" + order_code + "\n������� ��������=" + model + "\n������������� ������=" + customer_name
			+ "\n�������� ������=" + customer_phone + "\n���������� ����������=" + order_date + "\n���������� ������ ����������=" + arrival_date
			+ "\n������=" + order_cost+"�" +"\n�������� �����������="+order_pieces+"\n��������� �����������=" + order_status ;
}

public static void Overview_Orders() {
	Scanner scanner= new Scanner(System.in);
	System.out.println("-----------------------------------------------------------");
	System.out.print("�������� �������� ��� ������ �����������: (������� 0 ��� �����) ");
	int input=scanner.nextInt();
	boolean x=false;
	for(int i=0;i<=Orders.size();i++) {
		if (input==0) {
			x=true;
			break;
		}
		if (Orders.get(i)!=null) {
			if(Orders.get(i).order_code==(input)) {
				x=true;
				System.out.println("-----------------------------------------------------------");
				System.out.println(Orders.get(i));
				boolean y=false;
				if(Orders.get(i).order_status.equals("EXPECTED")) {
				do {
					System.out.println("-----------------------------------------------------------");
					System.out.print("������� 1 ��� ����� ����������� & ������: (������� 0 ��� �����) ");
					int input1=scanner.nextInt();
					if (input1==1) {
						y=true;
							Orders.get(i).order_status="EXECUTED";
							Sale s= new Sale (Orders.get(i).model,Orders.get(i).customer_name,Orders.get(i).order_date, Orders.get(i).customer_phone,Orders.get(i).order_cost,Orders.get(i).order_pieces);
							System.out.println("-----------------------------------------------------------");
							System.out.println("� ��������� ��� ����������� �����������!");
							System.out.println("O ������� ������� �����: "+s.getSale_code());
						}
					else if (input1==0) {
						break;
					}
					else {
						System.out.println("-----------------------------------------------------------");
						System.out.println("����� ��������!");
					}
				}
				while(y==false);
				}
				else {
					System.out.println("-----------------------------------------------------------");
					System.out.println("� ���������� ���� ����������!");
				}
			}
		}
	}
	if (x==false) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("� ������� ����������� ��� �������� ��� ����� �������������!");
	}
}



}
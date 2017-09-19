package com.cabbookingsystem;

import java.util.Calendar;
import java.util.Date;

public class CabBookingSystemDemo {
	
	private static CabBookingService service = new CabBookingService();

	public static void main(String[] args) {

		Cab cab1 = new Cab("DL01HB001",100020);
		Cab cab2 = new Cab("DL01HB002",100040);
		Cab cab3 = new Cab("DL01HB003",100060);
		Cab cab4 = new Cab("DL01HB004",100080);
		
		service.addCab(cab1);
		service.addCab(cab2);
		service.addCab(cab3);
		service.addCab(cab4);
				
		Calendar cal1 = Calendar.getInstance();
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.HOUR, 1);
		
		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.HOUR, 1);
		
		Calendar cal4 = Calendar.getInstance();
		cal4.add(Calendar.HOUR, 3);
		
		CabRequest req1 = new CabRequest("BR001",100025,100036,cal1.getTime());
		CabRequest req2 = new CabRequest("BR002",100056,100042,cal2.getTime());
		CabRequest req3 = new CabRequest("BR003",100044,100056,cal3.getTime());
		CabRequest req4 = new CabRequest("BR004",100028,100036,cal4.getTime());
		
		service.submitRequest(req1);
		service.submitRequest(req2);
		service.submitRequest(req3);
		service.submitRequest(req4);

	}

}

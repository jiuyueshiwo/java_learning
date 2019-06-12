package com.xiaodai;

import java.time.*;

public class Food {
	private String foodname;
	private String barcode;
	private LocalDate startdate;
	private LocalDate enddate;
	private int shelflife; 
    public Food(String name, String code, LocalDate date, int period) {
    	foodname = name;
    	barcode = code;
    	startdate = date;
    	shelflife = period;
    	enddate =startdate.plusDays(shelflife);
    	//System.out.println(name+" "+barcode+" "+enddate.toString()+" "+shelflife+" "+startdate);
		
	}
    
    public LocalDate getEnddate() {
    	return enddate;
    }
}

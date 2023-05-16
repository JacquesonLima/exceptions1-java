package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date chekin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date chekin, Date checkout) {
		this.roomNumber = roomNumber;
		this.chekin = chekin;
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - chekin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date chekin, Date checkout) {
		this.chekin = chekin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChekin() {
		return chekin;
	}

	public Date getCheckout() {
		return checkout;
	}

	@Override
	public String toString() {
		return "Reservation :" 
				+ " Room " 
				+ getRoomNumber() 
				+ ", check-in: " 
				+ sdf.format(chekin) 
				+ ", check-out: " 
				+ sdf.format(checkout) 
				+ ", " 
				+ duration() 
				+ " nights";
	}
	
	

}

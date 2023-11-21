package org.java.lessons.gestore_eventi.pojo;

import java.time.LocalDate;

public class Evento {
	
	protected String titolo;
	protected LocalDate data;
	protected Integer totalPlaces;
	protected Integer reservedPlaces;
	
	 
	
	public Evento(String titolo, LocalDate data, Integer totalPlaces) throws Exception {
		
		
		setTitolo(titolo);
		setData(data);
		setTotalPlaces(totalPlaces);
		setReservedPlaces(0);
		
	}


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		
		LocalDate now = LocalDate.now();
		
		
		System.out.println("today : " + now);
		System.out.println("event date : " + data);
		
		if (now.isBefore(data)) {
			
			this.data = data;
		}
		
		else {
			
			throw new Exception("error:the inserted date is already passed");
			
		}
		
	}

	public Integer getTotalPlaces() {
		return totalPlaces;
	}
	
	protected void setTotalPlaces(Integer totalPlaces) throws Exception {
		
		if(totalPlaces > 0) {
			
			this.totalPlaces = totalPlaces;
			
		}
		
		else {
			throw new Exception("error: values minor than 0 aren't acceptable");
		}
	}

	public Integer getReservedPlaces() {
		return reservedPlaces;
	}

	protected void setReservedPlaces(Integer reservedPlaces) {
		this.reservedPlaces = reservedPlaces;
	}
	
	public void prenota() throws Exception {
		
		LocalDate now = LocalDate.now();
		
		if(getData().isAfter(now)) {
			
			if(hasAvailablePlaces()) {
				
				setReservedPlaces(getReservedPlaces()+1);
				
			}
			
			else {
				
				throw new Exception("error: cannot reserve more places " + getAvailablePlaces());
			}
		}
		
		else {
			throw new Exception("error: this event is already expired");
		}
			
	}
	
	public void disdici() throws Exception {
		
		LocalDate now = LocalDate.now();
		
		if(getData().isAfter(now)) {
			
			if(hasReservedPlaces()) {
				
				setReservedPlaces(getReservedPlaces()-1);
				
			}
			
			else {
				
				throw new Exception("error: cannot cancel places if reserved places is " + getReservedPlaces());
				
			}
			
		}
		
		else {
			
			throw new Exception("error: this event is already expired");
			
		}
		
		
	}
	
	public String getFormattedStrDate() {
		
		String strFormattedDate = getData().getDayOfMonth() + "/"
				+ getData().getMonthValue() +"/"
				+ getData().getYear();
		return strFormattedDate;
		
	}
	
	public int getAvailablePlaces() {
		
		int availablePlaces = getTotalPlaces() - getReservedPlaces();
		return availablePlaces;
	}
	
	public boolean hasAvailablePlaces() {
		
		if(getReservedPlaces() < getTotalPlaces()) return true;
		else return false;
	}
	
	public boolean hasReservedPlaces() {
		
		if(getReservedPlaces() > 0) return true;
		else return false;
	}
	
	@Override
	
	public String toString() {
		
		
		
		return getFormattedStrDate() + "-" + getTitolo();	
	}

}

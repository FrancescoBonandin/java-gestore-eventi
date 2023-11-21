package org.java.lessons.gestore_eventi.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
	
	protected LocalTime ora;
	protected BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, Integer totalPlaces, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, totalPlaces);
		
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}
	
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	
	public String getFormattedStrHour(){
		
		String strHour = getOra().getHour() + ":" + getOra().getMinute();
		return strHour;
	}
	
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getFormattedStrPrezzo() {
		
		String strPrice = String.format("%.02f", getPrezzo()) + "€";
		return strPrice;

	}
	
	@Override
	public String toString() {
		
		
		String str = getFormattedStrDate() + " " + getFormattedStrHour() + "-" + getTitolo() + "-"  + getFormattedStrPrezzo();
		return str;
	}
	

}

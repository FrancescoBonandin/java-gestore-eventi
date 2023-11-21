package org.java.lessons.gestore_eventi.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ProgrammaEvento {
	
	private String titolo;
	
	private List<Evento> eventi;
	
	public ProgrammaEvento(String titolo, int numEventi) {
		
		
		setTitolo(titolo);
		setEventiRandom(numEventi);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	private void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	private void setEventiRandom(int numEventi) {
		
		List <Evento> eventi = new ArrayList<>();
		
		Random rnd = new Random();
		for(int x=0; x<numEventi; x++) {
			
			boolean rndcoin = rnd.nextBoolean();
			
			 String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id lorem porta,"
			 				+ " consequat sapien in, faucibus velit. Ut orci ante.";
			 String[] loremArr = lorem.split(" ");
			 String titolo = loremArr[rnd.nextInt(loremArr.length)];
			 
			 LocalDate today = LocalDate.now().plusDays(1);
			 LocalDate date = today.plusDays(rnd.nextInt(30));
			 
			 Integer totalPlaces = rnd.nextInt(500);
			
			
			if(rndcoin) {
				
				try {
					
					Evento evento = new Evento(titolo, date, totalPlaces);
					eventi.add(evento);
				}
				
				catch(Exception e) {
					System.out.println(e);
					break;
				}
			}
			
			else {
				
				int hour = rnd.nextInt(24);
				int base5 = rnd.nextInt(12);
				int minutes = 5 * base5;
				
				String strHour = hour <10 ? "0"+hour : hour + "";
				String strMinutes = minutes <10 ? "0"+minutes : minutes + "";
				String strTime = strHour + ":" + strMinutes;
				LocalTime time = LocalTime.parse(strTime);
				
				BigDecimal price = new BigDecimal(rnd.nextFloat(200.99f));
				
				try {
					
					Concerto concerto = new Concerto(titolo, date, totalPlaces, time, price);
					eventi.add(concerto);
				}
				
				catch(Exception e) {
					System.out.println(e);
					break;
				}
				

			}
		}
		setEventi(eventi);
	}
	
	public void AddEvento(Evento evento) {
		
		getEventi().add(evento);
		
	}
	
	public List<Evento> getEventiOnDate(LocalDate date){
		
		List <Evento> eventiInData = new ArrayList<>(); 
		
		for(Evento ev : getEventi()) {
			
			if(ev.getData().equals(date)) {
				eventiInData.add(ev);
			}
		}
		
		return eventiInData;
		
	}
	
	public Map<LocalDate, List<Evento>> getEventiOnDate(){
		
		Set<LocalDate> dates = new HashSet<>();
		
		for(Evento ev : getEventi()) {
			dates.add(ev.getData());
		}
		
		Map<LocalDate, List<Evento>> dateEventMap = new HashMap<>();
		
		for(LocalDate date : dates) {
			
			dateEventMap.put(date, getEventiOnDate(date));
		}
	
		return dateEventMap;
		
	}
	
	public int getTotalEventi() {
		
		return getEventi().size();
	}
	
	public void clearEventi() {
		
		getEventi().clear();
		
	}
	
	public void getProgramma() {
		
		System.out.println(getTitolo());
		
		getEventi().sort(Comparator.comparing(event->event.getData()));
		
		for(Evento ev : getEventi()) {
			
			System.out.println(ev.getData() + "-" + ev.getTitolo());
		}
	}
	
}

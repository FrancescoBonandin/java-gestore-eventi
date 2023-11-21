package org.java.lessons.gestore_eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.java.lessons.gestore_eventi.pojo.Concerto;
import org.java.lessons.gestore_eventi.pojo.ProgrammaEvento;

public class Main2 {

	public static void main(String[] args) {
		
		Concerto concerto;
		System.out.println("------------MS3------------");
		try {
			LocalDate date = LocalDate.parse("2025-11-22");
			LocalTime time = LocalTime.parse("16:30");
			BigDecimal price = new BigDecimal(150.99999f);
			concerto = new Concerto("Linkin Park",date, 2000, time, price);
			
			System.out.println(concerto);
			
			System.out.println("------------BONUS------------");
			
			ProgrammaEvento rndmProgramma = new ProgrammaEvento ("titolo-1", 10);
			System.out.println(rndmProgramma.getEventi());
			rndmProgramma.AddEvento(concerto);
			System.out.println(rndmProgramma.getEventi()+"\n---------");
			
			System.out.println("eventi in data : " + rndmProgramma.getEventiOnDate()+"\n---------");
			
			System.out.println("n-eventi : " + rndmProgramma.getTotalEventi()+"\n---------");
			
			rndmProgramma.getProgramma();
			
			rndmProgramma.clearEventi();
			System.out.println("---------\n" + "n-eventi after clear : " + rndmProgramma.getTotalEventi()+"\n---------");

		}
		catch(Exception e) {
			System.out.println("impossibile creare l' evento per : " + e);
		}
		
	}
	

}

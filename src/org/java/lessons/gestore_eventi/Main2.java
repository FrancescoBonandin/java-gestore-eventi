package org.java.lessons.gestore_eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.java.lessons.gestore_eventi.pojo.Concerto;

public class Main2 {

	public static void main(String[] args) {

		System.out.println("------------MS3+BONUS------------");
		try {
			LocalDate date = LocalDate.parse("2023-11-22");
			LocalTime time = LocalTime.parse("16:30");
			BigDecimal price = new BigDecimal(150.99999f);
			Concerto concerto = new Concerto("Linkin Park",date, 2000, time, price);
			
			System.out.println(concerto);
		}
		catch(Exception e) {
			System.out.println("impossibile creare l' evento per : " + e);
		}
	}

}

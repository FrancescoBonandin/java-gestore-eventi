package org.java.lessons.gestore_eventi;

import java.time.LocalDate;
import java.util.Scanner;

import org.java.lessons.gestore_eventi.pojo.Evento;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		do {
			
			String title = "";
			int year = 0;
			int month = 0;
			int day =0;
			int totalPlaces = 0;
			Evento evento;
			
			System.out.println("dammi il titolo dell' evento");
			title = in.nextLine();
			
			while (true) {

				System.out.println("dimmi  il giorno dell'evento come numero");
				String strDay = in.nextLine();
				day = Integer.valueOf(strDay);
				
				if(day <= 31 && day > 0) break;

				else {
					
					System.out.println("giorno non valido");
					continue;
					
				}
				
			}
			
			while (true) {

				System.out.println("dimmi il mese dell'evento come numero");
				String strMonth = in.nextLine();
				month = Integer.valueOf(strMonth);
				
				if(month <= 12 && month > 0) break;

				else {
					
					System.out.println("mese non valido");
					continue;
					
				}
				
			}
			
			while (true) {

				System.out.println("dimmi l'anno dell'evento come numero");
				String strYear = in.nextLine();
				year = Integer.valueOf(strYear);
				
				if(year >= java.time.LocalDate.now().getYear()) break;

				else {
					
					System.out.println("anno non valido");
					continue;
					
				}
			}
			
			LocalDate date = LocalDate.parse(year + "-" + month + "-" + day);
		
			while(true) {
				
				System.out.println("dimmi i posti totali all'evento");
				String strTotalPlaces = in.nextLine();
				totalPlaces = Integer.valueOf(strTotalPlaces);
				
				if(totalPlaces > 0) break;
				
				else {
					System.err.println("valore non valido");
					continue;
				}
				
			}
			
			try {
				
				evento = new Evento(title, date, totalPlaces);
				System.out.println("hai creato " + evento);
				
					while(true) {
						
						System.out.println("vuoi: \n 1.prenotare \n 2.disdire una prenotazione \n 3.uscire");
						
						String strChoice = in.nextLine();
						int choice = Integer.valueOf(strChoice);
						
						if(choice == 1) {
							
							System.out.println("quante prenotazioni vuoi effettuare?" 
												+ "\n(" + evento.getTitolo() + "posti disponibile: " 
												+ evento.getAvailablePlaces() + ")");
							String strIndex = in.nextLine();
							int index = Integer.valueOf(strIndex);
							
							int x=0 ;
							try {
								
								for(; x < index; x++) {
								
									
									evento.prenota();
								}
								
								System.out.println("prenotazione/i eseguita/e con successo");
								System.out.println("posti prenotati: " + evento.getReservedPlaces() + "\nposti disponibili: " + evento.getAvailablePlaces());
								continue;
								
							}
							
							catch(Exception e ){
									
								System.out.println("impossibile prenotare l' evento per :" + e);
								
								for(; x >= 0; x--) {
									
									evento.disdici();
										
								}
								System.out.println("posti prenotati: " + evento.getReservedPlaces() + "\nposti disponibili: " + evento.getAvailablePlaces());

								continue;
							}
						}
						
						else if (choice == 2) {
							
							System.out.println("quante disdette vuoi effettuare?" 
									+ "\n(" + evento.getTitolo() + "posti prenotati: " 
									+ evento.getReservedPlaces() + ")");
							String strIndex = in.nextLine();
							int index = Integer.valueOf(strIndex);
							
							int x=0 ;
							try {
								for(; x < index; x++) {
								
									evento.disdici();
									
								}
								
								System.out.println("disdetta/e eseguita/e con successo");
								System.out.println("posti prenotati: " + evento.getReservedPlaces() + "\nposti disponibili: " + evento.getAvailablePlaces());

								continue;
							}
				
							catch(Exception e ){
										
								System.out.println("impossibile disdire l' evento per :" + e);
								
								for(; x >= 0; x--) {
									
									evento.prenota();
									
								}
								System.out.println("posti prenotati: " + evento.getReservedPlaces() + "\nposti disponibili: " + evento.getAvailablePlaces());

								continue;
							}
								
							
						}
						
						else if (choice == 3) {
							System.out.println("sei uscito");
							break;
						}
						
						else {
							System.out.println("comando non riconosciuto");
							continue;
						}
				}
				break;
			}
			catch(Exception e) {
				
				System.out.println("impossibile creare l' evento per : "+e);
				continue;
			}
			
			
		} while (true);
		
		System.out.println("fine");
		
	}

}

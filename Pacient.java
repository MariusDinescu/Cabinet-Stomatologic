package ExercitiulB;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Pacient extends User {

	public Pacient(String nume_utilizator, String password, String userType, String adaugari) {
		super(nume_utilizator, password, userType, adaugari);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pacient{" + "username='" + getUsername() + '\'' + ", password='" + getPassword() + '\'' + ", userType='"
				+ getUserType() + '\'' + ", adaugari='" + getAdaugari() + '\'' + '}';
	}
	
	public void DiagnosticCovidFebruarie(List<Pacient> pacienti) {
		
		int count = 0;
	    for (Pacient pacient : pacienti) {
	        String adaugari = pacient.getAdaugari();
	        if (adaugari != null && !adaugari.equals("NU_X_X")) {
	            String[] adaugariSplit = adaugari.split("_");
	            System.out.println(Arrays.toString(adaugariSplit));
	            if (adaugariSplit.length > 1 && adaugariSplit[1].substring(3).contains("02")) {
	                count++;
	            }
	        }
	    }

	    System.out.println("Numarul de pacienti cu adaugari in luna februarie este: " + count);
	}
	
	public void VerificareMedic(List<Pacient> pacienti) {
		
		int countIonel = 0;
		int countDani = 0;
		for(Pacient pacient:pacienti) {	
			String adaugari = pacient.getAdaugari();
			if(adaugari != null && !adaugari.equals("NU_X_X")) {
				String[] adaugariSplit = adaugari.split("_");
				if(adaugariSplit.length > 1 && adaugariSplit[2].equals("IonelBarbu")) {
					countIonel++;	
				}else if (adaugariSplit.length > 1 && adaugariSplit[2].equals("DaniBarbu")) {
					countDani++;
				} 
				
			}
		}
		
		System.out.println("Medicul IonelBarbu are " + countIonel + " pacienti");
		System.out.println("Medicul DaniBarbu are " + countDani + " pacienti");
		
	}
	
	public void procentCOVID(List<Pacient> pacienti) {
		
		int nr_total_de_pacienti = pacienti.size();
		
		int count_pacienti_covid = 0;
		
		for(Pacient pacient:pacienti) {
			String adaugari = pacient.getAdaugari();
			if(adaugari != null && !adaugari.equals("NU_X_X")) {
				count_pacienti_covid++;
			}
		}
		
	
		double procentCovid = (double) count_pacienti_covid / nr_total_de_pacienti * 100;
		
		System.out.println("Procentajul de pacienti care au avut covid este: " + procentCovid +"%");
	}

	



}

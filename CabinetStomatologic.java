package ExercitiulB;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class CabinetStomatologic implements AfisareMedici, AfisarePacienti, AfisareAdministratori {

	public static void main(String[] args) throws IOException {

		List<User> useri = new ArrayList<>();
		List<Medic> medici = new ArrayList<>();
		List<Pacient> pacienti = new ArrayList<>();
		List<Administrator> admini = new ArrayList<>();

		CabinetStomatologic cabinet = new CabinetStomatologic();

		try {
			Scanner scanner = new Scanner(
					new File("C:\\Users\\mariu\\eclipse-workspace\\Fisa_2\\src\\ExercitiulB\\cabinet"));
			while (scanner.hasNextLine()) {
				String linie = scanner.nextLine();

				String[] elemente = linie.split(" \\* ");

				String username = elemente[0];
				String password = elemente[1];
				String userType = elemente[2];
				String adaugari = "";

				if (elemente.length > 3) {
					adaugari = elemente[3];
				}

				User user = new User(username, password, userType, adaugari);
				useri.add(user);

				switch (userType) {
				case "pacient": {
					Pacient pacient = new Pacient(username, password, userType, adaugari);
					pacienti.add(pacient);
					break;
				}
				case "medic": {
					Medic medic = new Medic(username, password, userType, adaugari);
					medici.add(medic);
					break;
				}

				case "administrator": {
					Administrator admin = new Administrator(username, password, userType, adaugari);
					admini.add(admin);
					break;
				}

				default: {
//				    throw new IllegalArgumentException("Tip de utilizator necunoscut: " + userType);

					break;
				}

				}
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Medic ultimul_element = medici.get(medici.size() - 1);
		Medic primul_element = medici.get(0);
		Pacient primul_element_pacient = pacienti.get(0);
		Pacient ultimul_element_pacient = pacienti.get(pacienti.size() - 1);

		System.out.println("Lista cu Medici: ");
		cabinet.afisareMedici(medici);

		System.out.println("---------");
		cabinet.afisarePrimulsiUltimulElement(medici);
		cabinet.afisareLungimeMedici(medici);

		System.out.println("======");
		System.out.println("Lista cu Pacienti: ");
		cabinet.afisarePacienti(pacienti);
		System.out.println("---------");
		cabinet.afisareUltimulsiPrimulElement(pacienti);
		cabinet.afisarelungimePacienti(pacienti);

		System.out.println("======");
		System.out.println("Lista cu Administratori: ");
		cabinet.afisareAdministrator(admini);
		System.out.println("-----------");
		cabinet.afisarePrimulSiUltimulElementAdmin(admini);
		cabinet.afisareLungimeAdmin(admini);

		System.out.println("========");
		System.err.println("Lista utilizatorilor: ");

		for (User a : useri) {
			System.out.println(a);

		}
		System.out.println("===================");
		System.out.println("Afisare daca lista este unica sau nu: ");
		for (User a : useri) {
			System.out.println(a.getElementeUnice(useri));
			break;

		}
		List<User> utlizatori_valizi = new ArrayList<>();

		System.out.println("==========");
		System.out.println("Verificare utilizatori valizi: ");
		for (User a : useri) {
			a.suntUtilizatoriValizi(useri, utlizatori_valizi);
			break;
		}

		System.out.println("==========");
		System.out.println("Afisare lista utilizatori valizi: ");

		for (User a : utlizatori_valizi) {
			System.out.println(a);
		}

		System.out.println("=========");
		cabinet.afisarePacienti(pacienti);
		for (Pacient a : pacienti) {
			a.DiagnosticCovidFebruarie(pacienti);
			break;

		}

		System.out.println("========");
		System.out.println("Verificare daca toti pacienti au acelasi medic sau nu: ");
		for (Pacient a : pacienti) {
			a.VerificareMedic(pacienti);
			break;

		}

		System.out.println("==========");
		System.out.println("Sortare lista administratori dupa nume de utilizator: ");

		Collections.sort(admini, new Comparator<Administrator>() {

			@Override
			public int compare(Administrator o1, Administrator o2) {
				
				return o1.getUsername().compareTo(o2.getUsername());
			}

		});

		cabinet.afisareAdministrator(admini);

		System.out.println("========");
		System.out.println("Introducere pacient in lista: ");

//		cabinet.AdaugarePacient(pacienti); 
//		System.out.println("====");
//		cabinet.afisarePacienti(pacienti);  //  adaugare date de la tastatura pentru pacient
		
		
		System.out.println("========");
		cabinet.afisareMedici(medici);
		System.out.println("========");
		for(Medic medic:medici) {
			medic.numarareCardiologi(medici, 3);
			break;
		}
		
		System.out.println("========");
		cabinet.afisarePacienti(pacienti);
		System.out.println("=======");
		for(Pacient pacient:pacienti) {
			pacient.procentCOVID(pacienti);
			break;
		}
		
		System.out.println("=======");
		List<User> primi_5_useri = utlizatori_valizi.subList(0, Math.min(utlizatori_valizi.size(), 5));
		Set<User> set_primi_5_useri = new HashSet<>(primi_5_useri);
		
		for(User user:set_primi_5_useri) {
			System.out.println(user);
			
		}

	}

	@Override
	public void afisareMedici(List<Medic> medici) {

		for (Medic a : medici) {
			System.out.println(a);
		}

	}

	@Override
	public void afisarePrimulsiUltimulElement(List<Medic> medici) {

		Medic PrimulElement = medici.get(0);
		Medic UltimulElement = medici.get(medici.size() - 1);

		System.out.println("Primul element din lista  de medici este: " + PrimulElement);
		System.out.println("Ultimul element din lista de medici este: " + UltimulElement);

	}

	@Override
	public void afisareLungimeMedici(List<Medic> medici) {

		int lungimeLista = medici.size();
		System.out.println("Lungimea listei este: " + lungimeLista);

	}

	@Override
	public void afisarePacienti(List<Pacient> pacienti) {

		for (Pacient a : pacienti) {
			System.out.println(a);
		}

	}

	@Override
	public void afisareUltimulsiPrimulElement(List<Pacient> pacienti) {
		Pacient PrimulElement = pacienti.get(0);
		Pacient UltimulElement = pacienti.get(pacienti.size() - 1);

		System.out.println("Primul element din lista  de pacienti este: " + PrimulElement);
		System.out.println("Ultimul element din lista de pacienti este: " + UltimulElement);

	}

	@Override
	public void afisarelungimePacienti(List<Pacient> pacienti) {

		int lungimeLista = pacienti.size();
		System.out.println("Lungimea listei este: " + lungimeLista);

	}

	@Override
	public void afisareAdministrator(List<Administrator> admini) {

		for (Administrator a : admini) {
			System.out.println(a);
		}

	}

	@Override
	public void afisarePrimulSiUltimulElementAdmin(List<Administrator> admini) {
		Administrator PrimulElement = admini.get(0);
		Administrator UltimulElement = admini.get(admini.size() - 1);

		System.out.println("Primul element din lista  de admini este: " + PrimulElement);
		System.out.println("Ultimul element din lista de admini este: " + UltimulElement);

	}

	@Override
	public void afisareLungimeAdmin(List<Administrator> admini) {

		int lungime = admini.size();

		System.out.println("Lungimea listei de admini este de: " + lungime);

	}

	public static void AdaugarePacient(List<Pacient> pacienti) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduceti username-ul pacientului: ");
		String username = sc.nextLine();
		System.out.println("Introduceti parola pacientului: ");
		String password = sc.nextLine();
		String userType = "pacient";
		System.out.println("Introduceti adaugari pacientului: ");
		String adaugari = sc.nextLine();

		Pacient pacientNou = new Pacient(username, password, userType, adaugari);
		System.out.println(pacientNou.toString());

		boolean pacientExista = false;
		java.util.Iterator<Pacient> iterator = pacienti.iterator();
		while (iterator.hasNext()) {
			Pacient pacient = iterator.next();
			for (Pacient pacienti1 : pacienti) {
				if (pacienti1.UtilizatorValid(pacientNou)) {
					if (pacienti1.getUsername().equals(pacientNou.getUsername())
							&& pacienti1.getPassword().equals(pacientNou.getPassword())
							&& pacienti1.getUserType().equals(pacientNou.getUserType())
							&& pacienti1.getAdaugari().equals(pacientNou.getAdaugari())) {
						pacientExista = true;
						break;
					
					}
				}

			}

		}

		    if(pacientExista == true) {
		    	System.out.println(pacientNou + " exista deja in lista sau nu este valid! ");
		    }else if(pacientExista == false) {
		    	pacienti.add(pacientNou);
		    	System.out.println(pacientNou + " a fost adaugat cu succes in lista!");
		    }

		sc.close();
	}

}

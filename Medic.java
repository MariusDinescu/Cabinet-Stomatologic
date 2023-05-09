package ExercitiulB;

import java.util.List;

public class Medic extends User {
	
	



	 public Medic(String nume_utilizator, String password, String userType, String adaugari) {
		super(nume_utilizator, password, userType , adaugari);
		// TODO Auto-generated constructor stub
	}

	@Override
	    public String toString() {
	        return "Medic{" +
	                "username='" + getUsername() + '\'' +
	                ", password='" + getPassword() + '\'' +
	                ", userType='" + getUserType() + '\'' +
	                ", adaugari='" + getAdaugari() + '\'' +
	                '}';
	    }
	
	public void numarareCardiologi(List<Medic> medici , int k) {
		
		int count = 0;
		
		for(Medic medic:medici) {
			String adaugari = medic.getAdaugari();
			if(adaugari != null) {
				if(adaugari.equals("cardiolog")) {
					count++;
				}
			}
		}
		
		System.out.println("Exista " + count + " medici cardiologi!");
		
		if(k > count) {
			System.out.println("Corect!");
		}else {
			System.out.println("Incorect!");
		}
	}

		

	
	 
	
	
	

}

package ExercitiulB;

public class Administrator extends User {

	
	
	

	public Administrator(String nume_utilizator, String password, String userType, String adaugari) {
		super(nume_utilizator, password, userType, adaugari);
		// TODO Auto-generated constructor stub
	}


	// Metoda specifica clasei Administrator
    public void adaugaMedic() {
        System.out.println("Adminul " + getUsername() + " a adaugat un nou medic in sistem.");
    }
	
  
    
	@Override
    public String toString() {
        return "Administrator{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", userType='" + getUserType() + '\'' +
                ", adaugari='" + getAdaugari() + '\'' +
                '}';
    }

}

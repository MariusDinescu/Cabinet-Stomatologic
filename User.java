package ExercitiulB;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private String username;
	private String password;
	private String userType;
	private String adaugari;
	
	
	
	public User(String nume_utilizator, String password, String userType,String adaugari) {
		super();
		this.username = nume_utilizator;
		this.password = password;
		this.userType = userType;
		this.adaugari = adaugari;
	}



	public int getLungime(List<User> user) {
		return user.size();
	}
	



	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userType=" + userType + ", adaugari="
				+ adaugari + "]";
	}







	public String getUsername() {
		return username;
	}



	public void setNume_utilizator(String nume_utilizator) {
		this.username = nume_utilizator;
	}



	public String getAdaugari() {
		return adaugari;
	}







	public void setAdaugari(String adaugari) {
		this.adaugari = adaugari;
	}







	public void setUsername(String username) {
		this.username = username;
	}







	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public boolean getElementeUnice(List<User> useri) {
		
	
		Set<User> useri1 = new HashSet<>(useri);
		
		return useri1.size() == useri.size();
			
		
	}
	
	public boolean UtilizatorValid(User user) {
	
		String username = user.getUsername();
		
		//Verificam daca utilizatorul este valid
		
		 if (username.length() < 3) {
		        return false;
		    }
		 
		 //verificare parola
		String password = user.getPassword();
		boolean contineLiteraMare = false;
		
		if(password.matches("^[a-zA-Z0-9]+$")) { // verifica daca contine  parola este formată numai din litere și cifre
			for(char c:password.toCharArray()) {
				if(Character.isUpperCase(c)) {
					contineLiteraMare = true;
					break;
				}
			}
		}
		
		if(!contineLiteraMare) {
			return false;
		}
		
		if(!user.getUserType().contains("administrator") && !user.getUserType().contains("medic") && !user.getUserType().contains("pacient")) {
			return false;
		}
				
		return true;
	}
	
	public void suntUtilizatoriValizi(List<User> useri, List<User> utilizatori_valizi) {
	    for (User user : useri) {
	        if (!user.UtilizatorValid(user)) {
//	            return false;
	        	System.out.println("Utilizatorul " +  user.toString() +  " nu este valid!");
	        }else {
	        	System.out.println("Utilizatorul este valid!");
	        	utilizatori_valizi.add(user);
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

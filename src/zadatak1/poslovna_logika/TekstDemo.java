package zadatak1.poslovna_logika;
import java.io.*;
public class TekstDemo {
	public String ucitajTekst(String nazivFajla) throws IOException {
		String s = "";
		try(FileReader f = new FileReader(nazivFajla);
				BufferedReader b = new BufferedReader(f)){
			boolean kraj = false;
			while(!kraj) {
				String pom = b.readLine();
				if(pom == null) kraj = true;
				else
					s = s + pom + "\n";
			}
		}
		return s;
	}
	
	public void upisiTekst(String nazivFajla, String tekst) throws IOException {
		try(FileWriter f = new FileWriter(nazivFajla);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b)){
			p.println(tekst);
		}
	}
}

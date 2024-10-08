package unieibar;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BatuketaJaurtiMainRuntime {

	public static void main(String[] args) {
		Process p = null;
        Runtime r = Runtime.getRuntime();

		System.out.println("BatuketaJaurtiMainR: Batuketa prozesua SORTU dut.");
		try {

            p = r.exec("java unieibar.Batuketa 23 6");
			System.out.println("BatuketaJaurtiMainR: Batuketa prozesua JAURTI dut.");

            // BERBIDERATZEA STDOUT
            BufferedReader br = 
            new BufferedReader(new InputStreamReader(p.getInputStream()));
          
            String linea="";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            // BERBIDERATZEA STDERR
            BufferedReader bre = 
            new BufferedReader(new InputStreamReader(p.getErrorStream()));
          
            linea="";
            while ((linea = bre.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();    
            bre.close();

            // PROZESUARI ZAIN (itzulerako baliorik jaso gabe)
			//p.waitFor(); //EZ DA BEHARREZKOA IRAKURTZEN EGON BAIKARA HURAK ATERA AHALA
			System.out.println("BatuketaJaurtiMainR: Batuketa prozesua BUKATU da.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("BatuketaJaurtiMainR: Banoa lotara.");
	}

}

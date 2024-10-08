package unieibar;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BatuketaJaurtiMainRuntimeFitx {

	public static void main(String[] args) {
		Process p = null;
        Runtime r = Runtime.getRuntime();

		System.out.println("BatuketaJaurtiMainR: Batuketa prozesua SORTU dut.");
		try {
            FileOutputStream fos = new FileOutputStream("irteera.txt"); 
            PrintWriter pw = new PrintWriter(fos);

            p = r.exec("java unieibar.Batuketa 23 6");
			System.out.println("BatuketaJaurtiMainR: Batuketa prozesua JAURTI dut.");

            // BERBIDERATZEA STDOUT
            InputStream is= p.getInputStream();  
            BufferedReader br = new BufferedReader (new InputStreamReader (is));

            pw.println(br.readLine()); //fitxategiari eranstea  
            pw.close(); //fitxategia ixtea

            FileOutputStream fose = new FileOutputStream("erroreak.txt"); 
            PrintWriter pwe = new PrintWriter(fose);

            // BERBIDERATZEA STDERR
            InputStream ise = p.getErrorStream();  
            br = new BufferedReader (new InputStreamReader (ise));

            String lerroa=null;
            while((lerroa=br.readLine())!=null){
                pwe.println(lerroa);
            }
            br.close(); //bufferra ixtea 
            pwe.close(); //fitxategia ixtea

            // PROZESUARI ZAIN (itzulerako baliorik jaos gabe)
			p.waitFor();
			System.out.println("BatuketaJaurtiMainR: Batuketa prozesua BUKATU da.");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("BatuketaJaurtiMainR: Banoa lotara.");
	}

}

package unieibar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FitxategiGuztienBatura {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("FITXATEGI GUZTIEN BATURA HASTERA DOA!!!");
		System.out.println("");
		String [] fitxategiZerrenda = {"informatika.txt","mekanika.txt","automozioa.txt","elektronika.txt", "administrazioa.txt"};
		ProcessBuilder pb;
		ArrayList<Process> prozesuZerrenda = new ArrayList<Process>();
		Process tmp_prozesua = null;
		InputStream tmp_is = null;
		InputStreamReader tmp_isr = null;
		BufferedReader tmp_br = null;
		
		ArrayList<String> fitxategiBakoitzekoBaturak = new ArrayList<String>();
		String tmp_fbb = null;
		
		long tmp_fitxategiBakarrekoBatura = 0;
		long fitxategiGuztienBatura = 0;
		
		// Prozesu SEME BAKARRA bagenu:
//		pb = new ProcessBuilder("java.exe", 
//				"unieibar.FitxategikoLerroGuztienBatura",
//				"informatika.txt"); 
//		Process prozesua = pb.start();
//		InputStream is = prozesua.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//		String lineHIJO;
//		if((lineHIJO=br.readLine()) != null)
//		{
//			System.out.println(lineHIJO);
//		}
//		Thread.sleep(5000);
//		prozesua.destroy();  
				
		// Prozesu 'seme' bat abiaraziko dugu fitxategi bakoitzeko
		for (int fz=0; fz<fitxategiZerrenda.length; fz++)
		{
			String fitxategiarenIzena = fitxategiZerrenda[fz];
			pb = new ProcessBuilder("java.exe", 
					"unieibar.FitxategikoLerroGuztienBatura",
					fitxategiarenIzena); 
			tmp_prozesua = pb.start();
			prozesuZerrenda.add(tmp_prozesua);
			System.out.println("'" + fitxategiarenIzena + "' fitxategia irakurten hasi da prozesu bat...");
		}
		
		// Prozesu 'seme'-en irteera fluxuak irakurriko ditugu eta String zerrenda baten gorde
		for (int i=0; i<prozesuZerrenda.size();i++)
		{
			tmp_prozesua = prozesuZerrenda.get(i);
			tmp_is = tmp_prozesua.getInputStream(); //irteera jaso
			tmp_isr = new InputStreamReader(tmp_is);
			tmp_br = new BufferedReader(tmp_isr);	
			tmp_fbb=tmp_br.readLine();
			if(tmp_fbb != null)
			{
				fitxategiBakoitzekoBaturak.add(tmp_fbb);  //string eran gorde fitxategietako baturak
			}
			
			tmp_br.close();
			tmp_isr.close();
			tmp_is.close();
		}
		
		// Prozesuak bukaraziko ditugu (badaezpada)
		for (int i=0; i<prozesuZerrenda.size();i++)
		{
			 prozesuZerrenda.get(i).destroy();
		}
		
		// Emaitzak bistaratuko ditugu
		System.out.println("");
		System.out.println("MINTEGI BAKOITZEKO AURREKONTUEN BATURAK:");
		for (int i=0; i<fitxategiBakoitzekoBaturak.size(); i++)
		{		
			System.out.println(String.format("%20s", fitxategiZerrenda[i]) + ": " + fitxategiBakoitzekoBaturak.get(i));
			try
			{
				// String erako informazioa 'long' erara bihurtu behar dugu eta batura egin bukaeran erakusteko
				tmp_fitxategiBakarrekoBatura = Long.parseLong(fitxategiBakoitzekoBaturak.get(i));
				fitxategiGuztienBatura += tmp_fitxategiBakarrekoBatura;
			}
			catch (NumberFormatException ex)
			{
				// Ez dugu ezer egiten
			}
		}
		System.out.println("");
		System.out.println(String.format("%20s", "GUZTIRA") + ": " + fitxategiGuztienBatura);
	}

}

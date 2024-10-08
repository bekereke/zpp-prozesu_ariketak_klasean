package unieibar;
import java.io.*;

public class FitxategikoLehenLerroaIrakurri {

	// Lehen parametroan fitxategiaren izena jasoko dugu
	public static void main(String[] args) {
		String lehenLerroa = "0";
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		if (args.length >=1)
		{
			try
			{
				f = new File(args[0]);
				fr = new FileReader(f);
				br = new BufferedReader(fr);
		
				lehenLerroa = br.readLine();
			    if (lehenLerroa == null)
			    {
			    	lehenLerroa = "0";
			    }
			    br.close();
			    fr.close();
			}
			catch (IOException ioe)
			{
				// ez dugu ezer egingo
			}
		}
	    System.out.println(lehenLerroa);
	}

}

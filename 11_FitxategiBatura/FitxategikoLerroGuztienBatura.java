package unieibar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FitxategikoLerroGuztienBatura {

	// Lehen parametroan fitxategiaren izena jasoko dugu
	public static void main(String[] args) {
		long batura = 0;
		long lerrokoZenbakia = 0;
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
		
				while((lehenLerroa = br.readLine()) != null)
				{
					try
					{
						lerrokoZenbakia = Long.parseLong(lehenLerroa);
						batura += lerrokoZenbakia;
					}
					catch (Exception ex)
					{
						// ez dugu ezer egingo ezin baldin badugu lerrotik zenbakirik atera
						// aurrera jarraitzen dugu
					}
				}
			    br.close();
			    fr.close();
			}
			catch (IOException ioe)
			{
				// ez dugu ezer egingo
			}
		}
	    System.out.println(batura);
	    System.out.flush();
	    
	}


}

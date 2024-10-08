package unieibar;

import java.io.IOException;

public class BatuketaJaurtiOker2 {

	public static void main(String[] args) {
		Process p = null;
		Runtime r = Runtime.getRuntime();
		
		System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua SORTU dut.");
		try {
			p = r.exec("java unieibar.Batuketa 76 2");
			System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua JAURTI dut.");
			p.waitFor();
			System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua BUKATU da.");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("BatuketaJaurtiMain: Banoa lotara.");
	}

}

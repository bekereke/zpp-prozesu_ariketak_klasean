package unieibar;

import java.io.IOException;

public class BatuketaJaurtiOker {

	public static void main(String[] args) {
		ProcessBuilder pb;
		pb = new ProcessBuilder("java.exe", 
					"unieibar/Batuketa",
					"76",
					"2");
		System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua SORTU dut.");
		try {
			Process p = pb.start();
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

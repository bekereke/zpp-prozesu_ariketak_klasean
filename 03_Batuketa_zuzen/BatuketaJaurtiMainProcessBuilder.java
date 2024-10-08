package unieibar;

import java.io.IOException;

public class BatuketaJaurtiMainProcessBuilder {

	public static void main(String[] args) {
		ProcessBuilder pb;

		pb = new ProcessBuilder("java.exe", "unieibar.Batuketa","23", "6");
		
		pb.inheritIO();  // gehitzearekin nahikoa! Semearen S/I berbideraturik

		System.out.println("BatuketaJaurtiMainPB: Batuketa prozesua SORTU dut.");
		try {
			Process p = pb.start();
			System.out.println("BatuketaJaurtiMainPB: Batuketa prozesua JAURTI dut.");
			p.waitFor();
			System.out.println("BatuketaJaurtiMainPB: Batuketa prozesua BUKATU da.");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("BatuketaJaurtiMainPB: Banoa lotara.");
	}
}

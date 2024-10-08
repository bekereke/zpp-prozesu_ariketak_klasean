package unieibar;

import java.io.File;

public class Jaurtitzailea {
    public void BatukariaJaurti(
        Integer n1,
        Integer n2, 
        String fitxEmaitza, 
        String fitxErrore){
                
        ProcessBuilder pb;
        try {   
                pb = new ProcessBuilder("java.exe", 
                                        "unieibar.Batukaria",
                                        Integer.toString(n1),
    	                		Integer.toString(n2));
                pb.redirectOutput(new File(fitxEmaitza));
                pb.redirectError(new File(fitxErrore));
                pb.start();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    public static void main(String[] args){
            Jaurtitzailea j = new Jaurtitzailea();
            j.BatukariaJaurti(8, 15, "emaitz1.txt", "akats1.txt");
            j.BatukariaJaurti(99,10, "emaitz2.txt", "akats2.txt");
            System.out.println("Bukatuta.");
    }
}
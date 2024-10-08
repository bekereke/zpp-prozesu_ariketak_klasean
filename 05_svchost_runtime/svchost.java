import java.io.*;

public class svchost {
    public static void main(String[] args) {
        String[] agindua={"CMD /C TASKLIST /SVC | find \"svchost.exe\""};
        Runtime r = Runtime.getRuntime();
        Process p = null;
        
        try {
            //programaren irteera berbideratzeko fitxategia sortzea
            FileOutputStream fos = new FileOutputStream("SVCHOST.TXT"); 
            PrintWriter pw = new PrintWriter(fos);

            p = r.exec(agindua[0]); 
            InputStream is= p.getInputStream();    
            BufferedReader br = new BufferedReader (new InputStreamReader (is));

            String lerroa; 

            while((lerroa = br.readLine()) !=null) //semearen irteera irakurtzea
            {
                //Prozesua eta PID emaitzetik ezabatzea: soilik zerbitzu izenak agertzea
                pw.println(lerroa.substring(35)); //fitxategiari eranstea  
            }
            br.close(); //bufferra ixtea
            pw.close(); //fitxategia ixtea
        }   
        catch (Exception e) {
            e.printStackTrace();
        }
            // COMPROBACION DE ERROR - O bien - 1 mal 
        int exitVal; 
        try { 
            exitVal = p.waitFor(); 
            System.out.println("Itzulera balioa: "+ exitVal); 
        }
        catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        // AKATSA ERE BERBIDERATU BEHAR DA GURASOTIK IRAKURTZEKO
        //Bestela, soilik 1 irteera balioa eman, baina arrazoitzerik gabe!
        try {
            InputStream es = p.getErrorStream();
            BufferedReader brea = new BufferedReader(new InputStreamReader(es));
            String lerroa;
            while ((lerroa=brea.readLine())!=null){
                System.out.println("ERROR >"+lerroa);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    
    }
}
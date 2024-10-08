import java.io.*;
import java.util.*;

public class LetraLarriak {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String agindua ="python .\\LetraLarriakBihurtu.py";
        Process p = null;

        try{
            p=r.exec(agindua);

            //jaso aitaren sarrera teklatutik System.in
            Scanner sc = new Scanner(System.in);
            System.out.println("Idatzi esaldia letra xehez, mesedez. (AITA)");
            String lerroa = null;
            lerroa=sc.nextLine();
            
            //idazketa - semearen sarrera gisa
            OutputStream os = p.getOutputStream();
            os.write((lerroa+"\n").getBytes());  
            os.flush(); //hustu bufferra

            //irakurketa - semearen emaitza jasotzea
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
            lerroa=null;
            while((lerroa=br.readLine())!=null){
                System.out.println(lerroa);
            }
            br.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        //semearen akatsen egiaztapena: 0 zuzen - 1 oker
        int exitBal; 
        try{
            exitBal=p.waitFor();
            System.out.println("Itzulera balioa: "+exitBal);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        } 
    }
}

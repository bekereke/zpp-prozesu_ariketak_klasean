package unieibar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SareIP
{

    /*
    Realiza un programa en Java que ejecute el comando ipconfig a través
    de la consola del sistema operativo y muestre su resultado por pantalla.
    */
    public static void main(String args[])
    {

        String s = null;

        // Determinar en qué SO estamos
        String so = System.getProperty("os.name");
        String comando;

        if (so.equals("Linux")) // Comando para Linux
        {
            comando = "ifconfig";
        }
        else                    // Comando para Windows
        {
            comando = "cmd /c ipconfig";
        }

        Process process = null;
        try
        {
            process = Runtime.getRuntime().exec(comando);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //STDOUT
        if (process!=null){
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            try
            {
                while ((linea = br.readLine()) != null)
                {
                    System.out.println(linea);
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
    
        }   
    }
}
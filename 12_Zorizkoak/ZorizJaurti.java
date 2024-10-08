package unieibar;
import java.io.*;

public class ZorizJaurti {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Crear el proceso hijo para generar números aleatorios
        ProcessBuilder pb = new ProcessBuilder("java", "unieibar.Zoriz");
        Process p = pb.start();

        // Obtener los flujos de entrada y salida del proceso hijo
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(p.getOutputStream());

        // Leer líneas de la entrada estándar y enviarlas al hijo
        String line;
        while ((line = stdIn.readLine()) != null) {
            output.println(line);
            output.flush();

            // Leer y mostrar el número aleatorio generado por el hijo
            String result = input.readLine();
            System.out.println("Gurasoan jasotako zorizko zenbakia: " + result);

            if (line.equals("buka")) {
                break;
            }
        }

        // Esperar a que el proceso hijo termine
        p.waitFor();
    }
}

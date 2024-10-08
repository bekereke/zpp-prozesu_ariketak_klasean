package unieibar;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ZorizThreadPiped {

    static class ZorizThread extends Thread {
        private PipedOutputStream irteera;

        public ZorizThread(PipedOutputStream outputStream) {
            this.irteera = outputStream;
        }

        @Override
        public void run() {
            Random ausaz = new Random();
            while (true) {
                try {
                    // Espera por la señal de entrada
                    Thread.sleep(1000); // Simulamos espera
                    int zorizkoZenb = ausaz.nextInt(11); // Número aleatorio entre 0 y 10
                    irteera.write(zorizkoZenb);
                    irteera.flush();
                } catch (IOException | InterruptedException e) {
                    System.err.println("Haria moztu da: "+e.getMessage());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Crear los pipes
            PipedOutputStream irteera = new PipedOutputStream();
            PipedInputStream sarrera = new PipedInputStream(irteera); // blokeatu egiten da datuak egon artean
            Scanner teklatua = new Scanner(System.in);

            // Iniciar el hilo generador
            ZorizThread zorizkoa = new ZorizThread(irteera);
            zorizkoa.start();

            // Proceso principal
            System.out.println("Idatzi zerbait eta zorizko zenbakia jaso 'buka' idatzi bitarte.");
            String lerroa;

            while (!(lerroa = teklatua.nextLine()).equals("buka")) {
                // Leer el número aleatorio desde el pipe
                int zorizkoZenb = sarrera.read();
                System.out.println("Jasotako zenbakia: " + zorizkoZenb);
            }

            // Cerrar recursos
            zorizkoa.interrupt(); // Interrumpimos el hilo
            sarrera.close();
            irteera.close();
            teklatua.close();

        } catch (IOException e) {
            System.err.println("Komunikazio akatsa pipean: " + e.getMessage());
        }
    }
}

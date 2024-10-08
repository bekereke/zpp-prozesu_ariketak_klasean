package unieibar;

public class Batukaria {
	
	public static void main(String[] args) {
		Sumador s=new Sumador();
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int emaitza=s.TartekoakBatu(a, b);
        System.out.println("Bitartekoen batukaria: " + a + " eta " + b + " => " + emaitza);
        System.out.flush();
	}
	
	int TartekoakBatu(int a, int b) {
		int bueltan = 0;
		for (int i=a;i<=b;i++){
                        bueltan=bueltan+i;
		}
		return bueltan;
	}

}

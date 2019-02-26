
public class Main {
	
	public static void main(String[] args) {
		Ponto2D p1 = new Ponto2D(1.0, 2.0);
		Ponto2D p2 = new Ponto2D(3.0, 3.0);
		Ponto2D p3 = new Ponto2D(5.0, 4.0);
		Ponto2D p4 = new Ponto2D(7.0, 5.0);
		SegmentoDeReta s1 = new SegmentoDeReta(p1, p2);
		SegmentoDeReta s2 = new SegmentoDeReta(p3, p4);
		
		System.out.println(s1.colineares(s2));
		
		System.out.println(s1.adjacentes(s2));
	}//fim de main
	
}//fim de classe

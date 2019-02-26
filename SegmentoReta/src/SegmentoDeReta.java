
// https://www.todamateria.com.br/segmento-de-reta/
// https://www.matematica.pt/geogebra/9-ano-declive-reta-2.php

public class SegmentoDeReta {

	// ATRIBUTOS

	//sao 
	private Ponto2D a, b;  //colocando privado os atributos
	// 2 pontos
	
	// ACESSORES

	// ---- Nota: matematicamente, num segmento de reta nao faz sentido  
	// ---- falar de origem e destino. Por isso mantem-se a designacao a e b.
	
	public Ponto2D getA() {
		return a.clone(); //tem a clomnagem entao manda uma referencia falsa
		
		// retorna um ponto
	}

	public Ponto2D getB() {
		return b.clone();  // retorna o outro ponto
	}

	// CONSTRUTORES
	
	// ----> com parâmetros
	public SegmentoDeReta(Ponto2D a, Ponto2D b) {
		super();
		//colocando regra para não receber se o segmento 
		if((a.getX() != b.getX())||(a.getY() != b.getY())) {
			this.a = new Ponto2D();
			this.b = new Ponto2D();
			this.a.setX(a.getX()); this.a.setY(a.getY());
			this.b.setX(b.getX()); this.b.setY(b.getY());
		}//fim do if
	}//fim do construtor
	
	// ----> default
	public SegmentoDeReta() {
		this(new Ponto2D(), new Ponto2D());
	}
	
	// ----> cópia
	public SegmentoDeReta(SegmentoDeReta p) {//está fazendo um clone() mas fica com a referencia do original
		this(p.getA(), p.getB());
	}
	

	// COMPORTAMENTOS
	
	public double comprimento() {
		//retorna o compriento conforme a formula
		return Math.sqrt(Math.pow((a.getX() - b.getX()),2) + //raiz quadrada de (Ax - Bx)^2 mais
				         Math.pow((a.getY() - b.getY()),2));//raiz quadrada de (Ay - By)^2
		
	}
	
	public double declive() {
		/* https://brainly.com.br/tarefa/220376 */
		return (a.getY() - b.getY()) / (a.getX() - b.getX());		
	}

	
	public boolean consecutivos(SegmentoDeReta s) {
		//Segmentos Consecutivos: quando possuem um ponto em comum
		//quando possuem um ponto em comum
		//se alguns deles são iguais
		return a.equals(s.getA()) || a.equals(s.getB()) ||
			   b.equals(s.getA()) || b.equals(s.getB());
	}
	
	public boolean VerificaColineares(SegmentoDeReta s) {
		    double determinante1 = 
		    		(a.getX() * b.getY() * 1) + 
		    		(a.getY() * 1 * s.getA().getX()) + 
		    		(1 * b.getX() * s.getA().getY()) - 
		    			(s.getA().getX() * b.getY() * 1) - 
		    			(s.getA().getY() * 1 * a.getX()) - 
		    			(1 * b.getX() * a.getY()); 
			
			 double determinante2 = 
					(b.getX() * s.getA().getY() * 1) + 
					(b.getY() * 1 * s.getB().getX()) + 
					(1 * s.getA().getX() * s.getB().getY()) - 
						(s.getB().getX() * s.getA().getY() * 1) -
					 	(s.getB().getY() * 1 * b.getX()) - 
						(1 * s.getA().getX() * b.getY());
			 if((determinante1 == 0) && (determinante2 == 0))return true;
			 return false;
	}
	public boolean colineares(SegmentoDeReta s) {
		// nao implementado
		//quando os pontos pertencem à mesma reta. 
		//Ou seja, quando dois ou mais pontos distintos compartilham a mesma reta.
		if(VerificaColineares(s))return true;
		return false;
	}
	
	public boolean congruentes(SegmentoDeReta s) {
		// Segmentos Congruentes: quando dois segmentos apresentam a mesma medida
		return this.comprimento() == s.comprimento();
		//se o a é congruente com o b e o b é congunete com o C
	}

	public boolean adjacentes(SegmentoDeReta s) {
		// nao implementado
		//para ser adjacente eles necessitam ser consecutivos e colineares 
		if(consecutivos(s) && colineares(s))return true;
		
		return false;
	}
	
	
	public Ponto2D pontoMedio() {
		/* https://pt.wikipedia.org/wiki/Ponto_m%C3%A9dio */
		return new Ponto2D((a.getX()+b.getX())/2,
						   (a.getY()+b.getY())/2).clone();
	}
	
	public boolean paralelos(SegmentoDeReta s) {
		return this.declive() == s.declive();
	}

	
	// MÉTODOS COMPLEMENTARES

	// ----> toString()

	@Override
	public String toString() {
		//retirar o "\n" no toString() do Ponto2D
		return "["+a.toString() + "," + b.toString()+"]";
	}
	// ----> clone()
	public SegmentoDeReta clone() {
		return new SegmentoDeReta(this);
	}
	
	// ----> equals()
	public boolean equals(SegmentoDeReta s) {
		if (s != null) 
			//se a que contem x e y é um Ponto2D
			//é igual a Segmento.A que contem x e y que é um Ponto2D 
			return a.equals(s.getA()) && b.equals(s.getB())  ||
				   a.equals(s.getB()) && b.equals(s.getA());
		//a contem (1,2)
		//b contem (2,1)
		//SegA contem(3,1)
		//SegB contem(3,4) 
		else return false;
	}
}

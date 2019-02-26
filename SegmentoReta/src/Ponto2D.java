
import static java.lang.Math.abs;

public class Ponto2D {

	// ATRIBUTOS

	private double x;
	private double y;

	// ACESSORES

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// CONSTRUTORES - 3 versões standard

	// ----> com parâmetros
	public Ponto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// ----> default
	public Ponto2D() {
		this(0.0,0.0);
	}
	
	// ----> cópia
	public Ponto2D(Ponto2D p) {
		this(p.getX(), p.getY());
	}
	

	// COMPORTAMENTOS


	   /** a1) incremento das coordenadas */
	   public void moverMais(double x, double y) {
	      this.x += x; this.y += y;
	   }
	   
	   /** a2) decremento das coordenadas */
	   public void moverMenos(double x, double y) {
	      this.x -= x; this.y -= y;
	   }
	   
	   /** b) soma */
	   public void soma(double x, double y) {
		      this.x += x; this.y += y;
		  }

	   /** c) soma os valores parâmetro e devolve um novo ponto */
	   public Ponto2D somaPonto(Ponto2D outroPonto) {
		   // Hipotese 1: mais detalhada
		   double coordX = x + outroPonto.getX();
		   double coordY = y + outroPonto.getY();
		   Ponto2D novoPonto = new Ponto2D(coordX, coordY);
		   return novoPonto.clone();
		   // Hipotese 2: mais sintética
		   // return new Ponto2D(x + outroPonto.getX(), y + outroPonto.getY()).clone();
	   }

	   /** d) determina se um ponto é simétrico */
	  // (dista do eixo dos XX o mesmo que do eixo dos YY)
	   public boolean simetrico() {
	     return abs(x) == abs(y);
	   }

	   /** e) verifica se ambas as coordenadas são positivas */
	   public boolean coordenadasPositivas() {
	     return x > 0 && y > 0;
	   } 

	   /** e) determionar o quadrante */
	   public int quadrante() {
		   if (x >= 0)
			   if (y >= 0)
				   return 1;
			   else
				   return 4;
		   else if (y >= 0)
			   return 2;
		   else
			   return 3; 
	   }
	   
	   // Métodos complementares usuais

	   /** g2) Converte o ponto para uma representação textual */

	   public String toString() {
		      StringBuilder s = new StringBuilder("Pt2D = ");
		      s.append(x + ", ");
		      s.append(y);
		      return s.toString();
		   }

	   /** Cria uma cópia do ponto recetor (recetor = this) */
	   public Ponto2D clone() {
		      return new Ponto2D(this); 
	   }
	   
	   /* verifica se os 2 pontos são iguais */
	   public boolean equals(Ponto2D p) {
	      if (p != null) return (x == p.getX() && y == p.getY());
	      else return false;
	   }

	   // outra versão de igual(Ponto2D p)
	   public boolean igual1(Ponto2D p) {
	     return (p == null) ? false : x == p.getX() &&
	                                  y == p.getY();
	   }

}

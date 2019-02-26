


public class Ponto2D{

	// ATRIBUTOS (Variaveis de instancia)
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
		// if(y <= 10)
		this.y = y;
	}

	// CONSTRUTORES

	// com parametros
	public Ponto2D(double x, double y) {
		this.x = x;// no meu x da minha classe, coloca o x que veio pelo contrutor
		this.y = y;// this, quer dizer este codigo
	}

	// default
	public Ponto2D() {// SEMPRE PUBLICO E TEM PARENTES PARA RECEBER PARAMETROS
		// this.setX(0.0);
		// this.setY(0.0);
		this(0.0, 0.0);// chamando um contrutor dentro da propria classe
	}

	// cópia
	// criar um ponto atraves de outro ponto
	public Ponto2D(Ponto2D p) {
		//x = p.getX();
		//setY(p.getY());
		this(p.getX(), p.getY());
	}

	// comportamentos (são os metodos)
	
	
	//medodo a
	public void mover(Ponto2D p, int opcao) {
		if(opcao == 1)
			somarCoordenadas(p.getX(), p.getY() );
		else
			subtrairCoordenadas(p.getX(), p.getY());
	}//fim do metodo
	
	// metodo do B
	public void somarCoordenadas(double valorX, double valorY) {
		setX(getX() + valorX);
		setY(getY() + valorY);
	}
	public void subtrairCoordenadas(double valorX, double valorY) {
		setX(getX() - valorX);
		setY(getY() - valorY);
	}
	
	//metodo C
	public Ponto2D somarDevolvendo(Ponto2D p) {
		p.setX(p.getX() + getX());
		p.setY(p.getY() + getY());
		return p;
	}
	
	//metodo d
	public boolean simetrico() {
		return Math.abs(getX()) == Math.abs(getY());
	}
	
	//metodo e
	public boolean positivo(Ponto2D p1) {
		if((p1.getX() > 0.0)&&(p1.getY() > 0))
			return true;
		return false;
	}//fim de metodo
	
	//metodo f
	public int quadrante(Ponto2D p) {
		if((p.getX() > 0)&&(p.getY() > 0))
			return 1;
		else if ((p.getX() < 0)&&(p.getY() < 0))
			return 3;
		else if((p.getX() < 0)&&(p.getY() > 0))
			return 2;
		else if((p.getX()>0)&&(p.getY() < 0))
			return 4;
		else
			return 0;
	}//

	//metodos g
		//g1
		public boolean equals(Ponto2D p1, Ponto2D p2) {
			if((p1.getX() == p2.getX()) && (p1.getY() == p2.getY())) {
				return true;
			}
			return false;
		}
		//g2
		@Override
		public String toString() {
			return String.format("%.2f, %.2f", getX(), getY());
		}//fim de metodo
		//g3
		public Ponto2D clone() {
			Ponto2D copia = new Ponto2D(getX(), getY());
			return copia;
		}//fim de metodo
		
}// fim da classe

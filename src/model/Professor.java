package model;

public class Professor {
	
	private int cpf;
	private String nome; 						//CRIAÇÃO DA CLASSE/OBJETO PROFESSOR, COM OS ATRIBUTOS, GETTERS E SETTERS
	private String area;
	private int pontos;

	public Professor() {
		super();
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	@Override
	public String toString() {
		return "Professor [cpf=" + cpf + ", nome=" + nome + ", area=" + area + ", pontos=" + pontos + "]";
	}

}

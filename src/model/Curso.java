package model;

public class Curso {

	private String cod;
	private String nome;                   //CRIAÇÃO DA CLASSE/OBJETO CURSO, COM OS ATRIBUTOS, GETTERS E SETTERS
	private String area;

	public Curso() {
		super();
	}
	
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
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
	
	@Override
	public String toString() {
		return "Curso [cod=" + cod + ", nome=" + nome + ", area=" + area + "]";
	}

}

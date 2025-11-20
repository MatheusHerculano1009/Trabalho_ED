package model;

public class Curso {

	private String cod;
	private String nome;
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
		return cod + ";" + nome + ";" + area;
	}

}

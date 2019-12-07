package entidades;

public class Departamento {
	private String nome;
	private int id;
	private String descricao;

	public Departamento(String nome, int id, String descricao) {
		super();
		this.nome = nome;
		this.id = id;
		this.descricao = descricao;
	}

	public Departamento() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	

}

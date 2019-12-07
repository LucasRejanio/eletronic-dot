package entidades;

//Classe de Atributos 
public class Funcionario {
	private String nome;
	private String cpf;
	private String email;
	private String cargo;
	private String telefone;
	private int pis;
	private int departamento;

	public Funcionario(String nome, String cpf, String email, String cargo, String telefone, int pis) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
		this.telefone = telefone;
		this.pis = pis;

	}

	public Funcionario() {
	} 

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setPis(int pis) {
		this.pis = pis;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getCargo() {
		return cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getPis() {
		return pis;
	}

	public int getDepartamento() {
		return departamento;
	}

}

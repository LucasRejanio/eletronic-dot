package entidades;

public class Ponto{
    private int tipo;
    private String usuario;
    private String tipo_ponto;
    private String data_hora;
    private String cpf;

    public Ponto() {
	}

	public Ponto(int tipo, String cpf) {
		super();
		this.tipo = tipo;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	public String getTipo_ponto() {
		return tipo_ponto;
	}

	public void setTipo_ponto(String tipo_ponto) {
		this.tipo_ponto = tipo_ponto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
    

    
}
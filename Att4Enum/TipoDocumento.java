package Att4Enum;

public enum TipoDocumento {
	RG, CPF, CNPJ;

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
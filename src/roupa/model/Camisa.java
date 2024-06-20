package roupa.model;

public class Camisa extends Roupa{
	
	private String tamanhoCamisa;
	
	public Camisa(String modelo, int codigo, char genero, int tipo, String tamanhoCamisa) {
		// puxando os dados de conta
		super(modelo, codigo, genero, tipo);
		// criando um novo atributo
		this.tamanhoCamisa = tamanhoCamisa;
	}

	public String getTamanhoCamisa() {
		return tamanhoCamisa;
	}

	public void setTamanhoCamisa(String tamanhoCamisa) {
		this.tamanhoCamisa = tamanhoCamisa;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tamanho da Camisa: " + tamanhoCamisa);
	}
}

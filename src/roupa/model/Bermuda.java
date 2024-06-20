package roupa.model;

public class Bermuda extends Roupa{
	
	private int tamanhoBermuda;
	
	public Bermuda(String modelo, int codigo, char genero, int tipo, int tamanhoBermuda) {
		// puxando os dados de conta
		super(modelo, codigo, genero, tipo);
		// criando um novo atributo
		this.setTamanhoBermuda(tamanhoBermuda);
	}

	public int getTamanhoBermuda() {
		return tamanhoBermuda;
	}

	public void setTamanhoBermuda(int tamanhoBermuda) {
		this.tamanhoBermuda = tamanhoBermuda;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tamanho da Bermuda: " + tamanhoBermuda);
	}
}

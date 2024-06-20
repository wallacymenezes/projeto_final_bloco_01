package roupa.controller;

import java.util.ArrayList;

import roupa.model.Roupa;
import roupa.repository.RoupaRepository;

public class RoupaController implements RoupaRepository{
	//collection - ArrayList - um array que comporta objetos
	private ArrayList<Roupa> listaRoupas = new ArrayList<Roupa>();
	int codigo = 0;
	
	@Override
	public void procurarPorNumero(int codigo) {
		var roupa = buscaNaCollection(codigo);

		if (roupa != null) {
			roupa.visualizar();
		} else {
			System.out.println("\nO pedido número: " + codigo + " não foi encontrado!");
		}
	}
	
	@Override
	public void listarTodas() {
		for (var roupa : listaRoupas) {
			roupa.visualizar();
		}
	}
	
	@Override
	public void cadastrar(Roupa roupa) {
		listaRoupas.add(roupa);
		System.out.println("\nO pedido número: " + roupa.getCodigo() + " foi criado com sucesso!");
	}
	
	@Override
	public void atualizar(Roupa roupa) {
		var buscaRoupa = buscaNaCollection(roupa.getCodigo());

		if (buscaRoupa != null) {
			listaRoupas.set(listaRoupas.indexOf(buscaRoupa), roupa);
			System.out.println("\nO pedido numero: " + roupa.getCodigo() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO pedido numero: " + roupa.getCodigo() + " não foi encontrado!");
		}
	}
	
	@Override
	public void deletar(int codigo) {
		var roupa = buscaNaCollection(codigo);

		if (roupa != null) {
			if (listaRoupas.remove(roupa) == true)
				System.out.println("\nO pedido numero: " + codigo + " foi deletado com sucesso!");
		} else {
			System.out.println("\nO pedido numero: " + codigo + " não foi encontrado!");
		}
	}
	
	public int gerarCodigo() {
		return ++codigo;
	}
	
	// para buscarmos e retornarmos o objeto com o codigo informado
	public Roupa buscaNaCollection(int codigo) {
		for (var roupa : listaRoupas) {
			if (roupa.getCodigo() == codigo) {
				return roupa;
			}
		}

		return null;
	}
}

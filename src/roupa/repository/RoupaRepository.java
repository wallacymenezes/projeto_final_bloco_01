package roupa.repository;

import roupa.model.Roupa;

public interface RoupaRepository {
	// CRUD da Conta
	public void procurarPorNumero(int codigo);

	public void listarTodas();

	public void cadastrar(Roupa roupa);

	public void atualizar(Roupa roupa);

	public void deletar(int codigo);
}

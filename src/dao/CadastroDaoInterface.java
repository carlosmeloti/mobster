package dao;

import java.util.List;

import model.Cadastro;

public interface CadastroDaoInterface {

	Cadastro salvarCadastro(Cadastro cadastro); 
	void alterarCadastro(Cadastro cadastro); 
	void excluirCadastro(Cadastro cadastro);
	List<Cadastro> getCadastros();
	
}

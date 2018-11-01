package service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.CadastroDaoInterface;
import model.Cadastro;



public class CadastroService implements CadastroServiceInterface {
	
	@Inject
	private CadastroDaoInterface cadastroDaoInterface;

	@Override
	@Transactional
	public Cadastro salvarCadastro(Cadastro cadastro) {
		
		return cadastroDaoInterface.salvarCadastro(cadastro);
	}

	@Override
	@Transactional
	public void alterarCadastro(Cadastro cadastro) {
		cadastroDaoInterface.alterarCadastro(cadastro);
		
	}

	@Override
	@Transactional
	public void excluirCadastro(Cadastro cadastro) {
		cadastroDaoInterface.excluirCadastro(cadastro);
		
	}

	@Override
	public List<Cadastro> getCadastros() {
		
		return cadastroDaoInterface.getCadastros();
	}
}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cadastro;



public class CadastroDao implements CadastroDaoInterface{

	@PersistenceContext(unitName="Mobster")
	private EntityManager entityManager;

	@Override
	public Cadastro salvarCadastro(Cadastro cadastro) {
		entityManager.persist(cadastro);
		return cadastro;
	}

	@Override
	public void alterarCadastro(Cadastro cadastro) {
		Cadastro cadastroMerge = entityManager.merge(cadastro);
		entityManager.persist(cadastroMerge);
		
	}

	@Override
	public void excluirCadastro(Cadastro cadastro) {
		Cadastro cadastroMerge = entityManager.merge(cadastro);
		entityManager.remove(cadastroMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cadastro> getCadastros() {
		Query query = entityManager.createQuery("from Cadastro");
		return query.getResultList();
	}

	
}

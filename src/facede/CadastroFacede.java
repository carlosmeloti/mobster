package facede;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.Cadastro;
import service.CadastroService;

@Path("/cadastros")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class CadastroFacede {
	
	@Inject
	private CadastroService cadastroService;
	
	@GET
	public List<Cadastro> getCadastros(){
		return cadastroService.getCadastros();
	}
	
	@POST
	public Cadastro salvarCadastro(Cadastro cadastro) {
		return cadastroService.salvarCadastro(cadastro);
	}
	
	@PUT
	public Cadastro alterarCadastro(Cadastro cadastro) {
		cadastroService.alterarCadastro(cadastro);
		return cadastro;
	}
	
	@DELETE
	@Path("/{idCadastro}")
	public void excluir(@PathParam("idCadastro") Integer idCadastro) {
		Cadastro cadastro = new Cadastro();
		cadastro.setId(idCadastro);
		cadastroService.excluirCadastro(cadastro);
		
	}
	
}

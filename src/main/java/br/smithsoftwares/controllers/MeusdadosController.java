package br.smithsoftwares.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.smithsoftwares.dao.MeusdadosDAO;
import br.smithsoftwares.to.MeusdadosTO;
import br.smithsoftwares.util.Response;

@Path("/meusdados")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class MeusdadosController {
	
	private MeusdadosDAO dao = new MeusdadosDAO();
	
	// curl -X POST -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/meusdados -d '{"dcmail":"jpcanuto789@gmail.com", "dcsenha":"1234"}'

	@POST
	public Response post(MeusdadosTO l) {
		try {
			dao.create(l);
			return Response.Ok("Dado criado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao criar os Dados: " + l.getDcmail());
		
		}
		
	}
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/meusdados
	@GET
	public Response get() {
		try {
			List<MeusdadosTO> l = dao.read();
			return Response.Ok(l);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao recuperar Informações.");
		}
		
	}
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/locality/1
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Integer id) {
		MeusdadosTO l;
		try {
			l = dao.readById(id);
			return Response.Ok(l);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao recuperar Informações.");
		}
		
	}
	
	
	// curl -X PUT -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/meusdados/1 -d '{"dcmail":"jpamaral@gmail.com", "dcsenha":"12345"  }'
	@PUT
	@Path("{id}")
	public Response put(@PathParam("id") Integer id, MeusdadosTO l) {
		try {
			dao.update(id, l);
			return Response.Ok("Cadastro atualizado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao atualizar Cadastro.");
		}
	}
	
	// curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/meusdados/1
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		try {
			dao.delete(id);
			return Response.Ok("Cadastro deletado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao deletar Cadastro.");
		}
	}
	
}

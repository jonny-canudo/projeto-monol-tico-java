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

import br.smithsoftwares.dao.TesteDAO;
import br.smithsoftwares.to.TesteTO;
import br.smithsoftwares.util.Response;

@Path("/teste")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class TesteController {
	
	private TesteDAO dao = new TesteDAO();
	
	// curl -X POST -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/locality -d '{"dclocality":"Acre"}'
	@POST
	public Response post(TesteTO l) {
		try {
			dao.create(l);
			return Response.Ok("Teste criado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao criar Teste: " + l.getDcemail());
		}
		
	}
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/locality
	@GET
	public Response get() {
		try {
			List<TesteTO> l = dao.read();
			return Response.Ok(l);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao recuperar Dados.");
		}
		
	}
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/locality/1
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Integer id) {
		TesteTO l;
		try {
			l = dao.readById(id);
			return Response.Ok(l);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao recuperar Dados.");
		}
		
	}
	
	
	// curl -X PUT -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/locality/12 -d '{"dclocality":"Sao Paulo12"}'
	@PUT
	@Path("{id}")
	public Response put(@PathParam("id") Integer id, TesteTO l) {
		try {
			dao.update(id, l);
			return Response.Ok("Dados atualizado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao atualizar Dados.");
		}
	}
	
	// curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/locality/5
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		try {
			dao.delete(id);
			return Response.Ok("Informações deletadas com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao deletar Informações.");
		}
	}
	
}

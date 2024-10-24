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

import br.smithsoftwares.dao.UserDAO;
import br.smithsoftwares.to.UserTO;
import br.smithsoftwares.util.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UserController {
	
	private UserDAO dao = new UserDAO();
	
	// curl -X POST -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/user -d '{"dcname":"Cesar", "dcmail":"cesar@gmail.com", "dcpass":"1234"}'
	@POST
	public Response post(UserTO u) {
		try {
			dao.create(u);
			return Response.Ok("Usuario criado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao criar usuario: " + u.getDcname());
		}
		
	}
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/user
	@GET
	public Response get() {
		try {
			List<UserTO> u = dao.read();
			return Response.Ok(u);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao recuperar Usuarios.");
		}
		
	}
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/user/1
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Integer id) {
		UserTO u;
		try {
			u = dao.readById(id);
			return Response.Ok(u);
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao recuperar Usuario.");
		}
		
	}
	
	// curl -X PUT -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/user/10 -d '{"dcname":"Karen10","dcmail":"cesar@gmai.com","dcpass":"1234"}'
	@PUT
	@Path("{id}")
	public Response put(@PathParam("id") Integer id, UserTO u) {
		try {
			dao.update(id, u);
			return Response.Ok("Usuario atualizado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao atualizar Usuario.");
		}
	}
	
	// curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/user/5
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		try {
			dao.delete(id);
			return Response.Ok("Usuario deletado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao deletar Usuario.");
		}
	}
	
}

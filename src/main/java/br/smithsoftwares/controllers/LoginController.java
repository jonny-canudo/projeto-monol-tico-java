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

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import br.smithsoftwares.dao.LoginDAO;
import br.smithsoftwares.to.LoginTO;
import br.smithsoftwares.util.GsonMessageBodyHandler;
import br.smithsoftwares.util.Response;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class LoginController {
	
	private LoginDAO dao = new LoginDAO();
	
	// curl -X GET -H "Content-Type: application/json" http://localhost:8080/backend-java/controllers/login -d '{"mail":"cesar.smith@gmail.com","pass":"1234"}'
	@GET
	public Response get(LoginTO l) throws JSONException {
		try {
			
			Integer resp = dao.login(l.getMail(), l.getPass());
			
			
			if (resp != 0) {
				return Response.Ok(resp);
			} else {
				return Response.Error(-4, "Email ou Senha inexistentes.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.Error(-1, "Erro ao logar.");
		}
	}
	
}

package br.smithsoftwares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.smithsoftwares.to.UserTO;
import br.smithsoftwares.util.DataSourceDAO;

public class LoginDAO extends DataSourceDAO {
	
	public Integer login(String mail, String pass) throws SQLException {
		Integer resp = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select couser from tbluser where dcmail = ? and dcpass = ?");
			stmt.setString(1, mail);
			stmt.setString(2, pass);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resp = rs.getInt("couser");
			}
			rs.close();
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return resp;
	}
	
}

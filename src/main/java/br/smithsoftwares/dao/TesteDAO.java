package br.smithsoftwares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.smithsoftwares.to.TesteTO;
import br.smithsoftwares.util.DataSourceDAO;

public class TesteDAO extends DataSourceDAO {
	
	public void create(TesteTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("insert into tblteste (dcemail, dcsenha) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDcemail());
			stmt.setString(2, l.getDcsenha());
			stmt.executeUpdate();
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<TesteTO> read() throws SQLException {
		List<TesteTO> teste = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tblteste");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TesteTO l = new TesteTO();
				l.setCoteste(rs.getInt("coteste"));
				l.setDcemail(rs.getString("dcemail"));
				l.setDcsenha(rs.getString("dcsenha"));
				teste.add(l);
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
		return teste;
	}
	
	public TesteTO readById(Integer id) throws SQLException {
		TesteTO teste = new TesteTO();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tblteste where coteste = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				teste.setCoteste(rs.getInt("coteste"));
				teste.setDcemail(rs.getString("dcemail"));
				teste.setDcsenha(rs.getString("dcsenha"));
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
		return teste;
	}
	
	public void update(Integer id, TesteTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("update tblteste set dcemail = ?, dcsenha = ? where coteste = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDcemail());
			stmt.setString(2, l.getDcsenha());
			stmt.setInt(3, id);
			
			stmt.executeUpdate();
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void delete(Integer id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("delete from tblteste where coteste = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
}

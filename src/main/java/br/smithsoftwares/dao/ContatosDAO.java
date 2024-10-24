package br.smithsoftwares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.smithsoftwares.to.ContatosTO;
import br.smithsoftwares.util.DataSourceDAO;

public class ContatosDAO extends DataSourceDAO {
	
	public void create(ContatosTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("insert into tblcontatos (dcnomes, dcemail, dcendereco, nutelefone, dtnascimento ) VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDcnomes());
			stmt.setString(2, l.getDcemail());
			stmt.setString(3, l.getDcendereco());
			stmt.setString(4, l.getNutelefone());
			stmt.setString(5, l.getDtnascimento());
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
	
	public List<ContatosTO> read() throws SQLException {
		List<ContatosTO> contatos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tblcontatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ContatosTO l = new ContatosTO();
				l.setCocontatos  (rs.getInt   ("cocontatos"));
				l.setDcnomes     (rs.getString("dcnomes"));
				l.setDcemail     (rs.getString("dcemail"));
				l.setDcendereco  (rs.getString("dcendereco"));
				l.setNutelefone  (rs.getString("nutelefone"));
				l.setDtnascimento(rs.getString("dtnascimento"));
				contatos.add(l);
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
		return contatos;
	}
	
	public ContatosTO readById(Integer id) throws SQLException {
		ContatosTO contatos = new ContatosTO();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tblcontatos where cocontatos = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contatos.setCocontatos  (rs.getInt   ("cocontatos"));
				contatos.setDcnomes     (rs.getString("dcnomes"));
				contatos.setDcemail     (rs.getString("dcemail"));
				contatos.setDcendereco  (rs.getString("dcendereco"));
				contatos.setNutelefone  (rs.getString("nutelefone"));
				contatos.setDtnascimento(rs.getString("dtnascimento"));
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
		return contatos;
	}
	
	public void update(Integer id, ContatosTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("update tblcontatos set dcnomes = ?, dcemail = ?, dcendereco = ?, nutelefone = ?, dtanivesario = ? where cocontatos = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDcnomes());
			stmt.setString(2, l.getDcemail());
			stmt.setString(3, l.getDcendereco());
			stmt.setString(4, l.getNutelefone());
			stmt.setString(5, l.getDtnascimento());
			stmt.setInt   (6, id);
			
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
			
			stmt = conn.prepareStatement("delete from tblcontatos where cocontatos = ?", Statement.RETURN_GENERATED_KEYS);
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

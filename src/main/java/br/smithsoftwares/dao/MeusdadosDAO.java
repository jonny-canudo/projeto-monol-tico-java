package br.smithsoftwares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.smithsoftwares.to.MeusdadosTO;
import br.smithsoftwares.util.DataSourceDAO;

public class MeusdadosDAO extends DataSourceDAO {
	
	public void create(MeusdadosTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("insert into tblmeusdados (dcmail, dcsenha) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDcmail());
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
	
	public List<MeusdadosTO> read() throws SQLException {
		List<MeusdadosTO> meusdados = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tblmeusdados");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				MeusdadosTO l = new MeusdadosTO();
				l.setCodados(rs.getInt("codados"));
				l.setDcmail(rs.getString("dcmail"));
				l.setDcsenha(rs.getString("dcsenha"));
				meusdados.add(l);
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
		return meusdados;
	}
	
	public MeusdadosTO readById(Integer id) throws SQLException {
		MeusdadosTO meusdados = new MeusdadosTO();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tblmeusdados where codados = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				meusdados.setCodados(rs.getInt("codados"));
				meusdados.setDcmail(rs.getString("dcmail"));
				meusdados.setDcsenha(rs.getString("dcsenha"));
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
		return meusdados;
	}
	
	public void update(Integer id, MeusdadosTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("update tblmeusdados set dcmail = ?, dcsenha = ? where codados = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDcmail());
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
			
			stmt = conn.prepareStatement("delete from tblmeusdados where codados = ?", Statement.RETURN_GENERATED_KEYS);
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

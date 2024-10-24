package br.smithsoftwares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.smithsoftwares.to.LocalityTO;
import br.smithsoftwares.util.DataSourceDAO;

public class LocalityDAO extends DataSourceDAO {
	
	public void create(LocalityTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("insert into tbllocality (dclocality) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDclocality());
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
	
	public List<LocalityTO> read() throws SQLException {
		List<LocalityTO> localitys = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tbllocality");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LocalityTO l = new LocalityTO();
				l.setColocality(rs.getInt("colocality"));
				l.setDclocality(rs.getString("dclocality"));
				localitys.add(l);
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
		return localitys;
	}
	
	public LocalityTO readById(Integer id) throws SQLException {
		LocalityTO locality = new LocalityTO();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tbllocality where colocality = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				locality.setColocality(rs.getInt("colocality"));
				locality.setDclocality(rs.getString("dclocality"));
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
		return locality;
	}
	
	public void update(Integer id, LocalityTO l) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("update tbllocality set dclocality = ? where colocality = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getDclocality());
			stmt.setInt(2, id);
			
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
			
			stmt = conn.prepareStatement("delete from tbllocality where colocality = ?", Statement.RETURN_GENERATED_KEYS);
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

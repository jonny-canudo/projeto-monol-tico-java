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

public class UserDAO extends DataSourceDAO {
	
	public void create(UserTO u) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("insert into tbluser (dcname, dcmail, dcpass, dtcreated) VALUES(?, ?, ?, now())", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getDcname());
			stmt.setString(2, u.getDcmail());
			stmt.setString(3, u.getDcpass());
			
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
	
	public List<UserTO> read() throws SQLException {
		List<UserTO> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tbluser");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserTO u = new UserTO();
				u.setCouser(rs.getInt("couser"));
				u.setDcname(rs.getString("dcname"));
				u.setDcmail(rs.getString("dcmail"));
				u.setDcpass(rs.getString("dcpass"));
				u.setDtcreated(rs.getString("dtcreated"));
				users.add(u);
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
		return users;
	}
	
	public UserTO readById(Integer id) throws SQLException {
		UserTO user = new UserTO();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("select * from tbluser where couser = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setCouser(rs.getInt("couser"));
				user.setDcname(rs.getString("dcname"));
				user.setDcmail(rs.getString("dcmail"));
				user.setDcpass(rs.getString("dcpass"));
				user.setDtcreated(rs.getString("dtcreated"));
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
		return user;
	}
	
	public void update(Integer id, UserTO u) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement("update tbluser set dcname = ?, dcmail = ?, dcpass = ? where couser = ?", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getDcname());
			stmt.setString(2, u.getDcmail());
			stmt.setString(3, u.getDcpass());
			stmt.setInt(4, id);
			
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
			
			stmt = conn.prepareStatement("delete from tbluser where couser = ?", Statement.RETURN_GENERATED_KEYS);
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

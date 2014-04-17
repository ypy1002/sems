package sems3.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sems3.vo.UsersVo;
import util.DBConnectionPool;

//	UsersVo의 setter / getter 사용

public class MysqlUsersDao implements UsersDao {

	DBConnectionPool dbConnectionPool;
	
	public void setDBConnectionPool(DBConnectionPool dbConnectionPool){
		this.dbConnectionPool = dbConnectionPool;
	}
	
	public void insert(UsersVo users) throws Throwable {
		
		PreparedStatement stmt = null;
		Connection con = null;
		
		try {
			
			con = dbConnectionPool.getConnection();
			
			stmt = con.prepareStatement("insert SE_USERS(EMAIL, PWD, NAME, TEL, FAX, POSTNO, ADDR, PHOT_PATH) values(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, users.getEmail());
			stmt.setString(2, users.getPassword());
			stmt.setString(3, users.getName());
			stmt.setString(4, users.getTel());
			stmt.setString(5, users.getFax());
			stmt.setString(6, users.getPostNo());
			stmt.setString(7, users.getAddr());
			stmt.setString(8, users.getPhoto());
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public List<UsersVo> list(int pageNo, int pageSize) 
			throws Throwable {
		
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		try {
			con = dbConnectionPool.getConnection();
			
			stmt = con.prepareStatement(
					"select UNO, EMAIL, PWD, NAME, TEL from SE_USERS order by UNO desc limit ?, ?");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			ArrayList<UsersVo> list = new ArrayList<UsersVo>();
			
			while(rs.next()) {
				list.add(new UsersVo().setUno(rs.getInt("UNO")).setEmail(rs.getString("EMAIL")).setPassword(rs.getString("PWD")).setName(rs.getString("NAME")).setTel(rs.getString("TEL")));
			}
			return list;
		} catch (Throwable e) {
			throw e;
		} finally {
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public UsersVo detail(int no) throws Throwable {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			con = dbConnectionPool.getConnection();
			
			stmt = con.prepareStatement(
					"select UNO, EMAIL, PWD, NAME, TEL, FAX, POSTNO, ADDR, PHOT_PATH from SE_USERS"
							+ " where UNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new UsersVo().setUno(rs.getInt("UNO")).setEmail(rs.getString("EMAIL")).setPassword(rs.getString("PWD"))
						.setName(rs.getString("NAME")).setTel(rs.getString("TEL")).setFax(rs.getString("FAX"))
						.setPostNo(rs.getString("POSTNO")).setAddr(rs.getString("ADDR")).setPhoto(rs.getString("PHOT_PATH"));
			} else {
				throw new Exception("해당 유저를 찾을 수 없습니다.");
			}
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public void update(UsersVo users) throws Throwable {
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = dbConnectionPool.getConnection();
			
			stmt = con.prepareStatement(
					"update SE_USERS set EMAIL=?, PWD=?, NAME=?, TEL=?, FAX=?, POSTNO=?, ADDR=?, PHOT_PATH=? where UNO=?");
			stmt.setString(1, users.getEmail());
			stmt.setString(2, users.getPassword());
			stmt.setString(3, users.getName());
			stmt.setString(4, users.getTel());
			stmt.setString(5, users.getFax());
			stmt.setString(6, users.getPostNo());
			stmt.setString(7, users.getAddr());
			stmt.setString(8, users.getPhoto());
			stmt.setInt(9, users.getUno());
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public void delete(int no) throws Throwable {
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = dbConnectionPool.getConnection();
			
			stmt = con.prepareStatement(
					"delete from SE_USERS where UNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
}


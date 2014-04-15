package sems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//	SubjectVo의 setter / getter 사용

public class MysqlSubjectDao {

	DBConnectionPool dbConnectionPool = new DBConnectionPool();

	public void insert(SubjectVo subject) throws Throwable {
		PreparedStatement stmt = null;
		Connection con = null;
		dbConnectionPool = new DBConnectionPool();
		
		try {
			con = dbConnectionPool.getConnection();

					stmt = con.prepareStatement("insert SE_SUBJS(TITLE, DEST) values(?, ?)");
					stmt.setString(1, subject.getTitle());
					stmt.setString(2, subject.getDescription());
					stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally {
			try {
				stmt.close();
			} catch (Throwable e2) {
			}
			dbConnectionPool.returnConnection(con);
		}
	}

	public List<SubjectVo> list(int pageNo, int pageSize) throws Throwable {

		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = dbConnectionPool.getConnection();

			stmt = con.prepareStatement("select SNO, TITLE from SE_SUBJS"
					+ " order by SNO desc" + " limit ?, ?");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();

			ArrayList<SubjectVo> list = new ArrayList<SubjectVo>();

			while (rs.next()) {
				list.add(new SubjectVo().setSno(rs.getInt("SNO")).setTitle(
						rs.getString("TITLE")));
			}
			return list;
		} catch (Throwable e) {
			throw e;
		} finally {
			try {
				rs.close();
			} catch (Throwable e2) {
			}
			try {
				stmt.close();
			} catch (Throwable e2) {
			}
			dbConnectionPool.returnConnection(con);
		}
	}

	public List<SubjectVo> detail(int no) throws Throwable {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = dbConnectionPool.getConnection();

			stmt = con.prepareStatement("select SNO, TITLE, DEST from SE_SUBJS"
					+ " where SNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			ArrayList<SubjectVo> list = new ArrayList<SubjectVo>();
			if (rs.next()) {
				list.add(new SubjectVo().setSno(rs.getInt("SNO"))
						.setTitle(rs.getString("TITLE"))
						.setDescription(rs.getString("DEST")));
				return list;
			} else {
				throw new Exception("해당 과목을 찾을 수 없습니다.");
			}
		} catch (Throwable e) {
			throw e;
		} finally {
			try {
				rs.close();
			} catch (Throwable e2) {
			}
			try {
				stmt.close();
			} catch (Throwable e2) {
			}
			dbConnectionPool.returnConnection(con);
		}
	}

	public void update(SubjectVo subject) throws Throwable {
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("update SE_SUBJS set" + " TITLE=?"
					+ ", DEST=?" + " where SNO=?");
			stmt.setString(1, subject.getTitle());
			stmt.setString(2, subject.getDescription());
			stmt.setInt(3, subject.getSno());
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally {
			try {
				stmt.close();
			} catch (Throwable e2) {
			}
			dbConnectionPool.returnConnection(con);
		}
	}

	public void delete(int no) throws Throwable {
		PreparedStatement stmt = null;
		Connection con = null;
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("delete from SE_SUBJS where SNO=?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally {
			try {
				stmt.close();
			} catch (Throwable e2) {
			}
			dbConnectionPool.returnConnection(con);
		}
	}
}

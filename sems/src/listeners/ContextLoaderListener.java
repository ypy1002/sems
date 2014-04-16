package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import sems.dao.MysqlSubjectDao;
import sems2.dao.MysqlCourseDao;
import sems3.dao.MysqlUsersDao;
import util.DBConnectionPool;

public class ContextLoaderListener implements ServletContextListener {

	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		dbConnectionPool.closeAll();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		System.out.println("contextinitialized...");
		ServletContext sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
  	dbConnectionPool.setDriver(sc.getInitParameter("driver"));
  	dbConnectionPool.setUrl(sc.getInitParameter("url"));
  	dbConnectionPool.setUsername(sc.getInitParameter("username"));
  	dbConnectionPool.setPassword(sc.getInitParameter("password"));
  	
		MysqlSubjectDao dao = new MysqlSubjectDao();
		dao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", dao);
		
		MysqlCourseDao dao2 = new MysqlCourseDao();
		dao2.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("courseDao", dao2);
		
		MysqlUsersDao dao3 = new MysqlUsersDao();
		dao3.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("usersDao", dao3);
	}
}
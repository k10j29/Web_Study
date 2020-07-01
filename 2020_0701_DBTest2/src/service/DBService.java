package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService { // public DBService() 생성자로 한번만 준다.

	// basic data source 객체의 기능을 사용할수 있는 interface (설명서)
	DataSource ds = null; // javax.sql

//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static DBService single = null; // static 변수는 딱 하나만 만들어짐

	public static DBService getInstance() { // static 변수는 딱 하나만 만들어짐

		if (single == null)
			single = new DBService(); // 처음 호출시 수행
		return single; // 그리고 끝냄
	}

	// JNDI (이름을 이용해서 자원을 추출하는) 를 이용한 정보 획득
	public DBService() {

		try {
			// 1.// java JNDI 구해오는 객체 생성 (try / catch)
			InitialContext ic = new InitialContext();

			// 2.// Context.xml 검색 Resource 위치 검색 (casting 필요)
			Context ctx = (Context) ic.lookup("java:comp/env");

			// 3.// Context.xml 내의 Resource 검색 (casting 필요)
			ds = (DataSource) ctx.lookup("jdbc/oracle_test");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public Connection getConnection() throws Exception {

		return ds.getConnection();
	}

}

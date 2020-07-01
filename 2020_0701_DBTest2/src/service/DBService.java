package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService { // public DBService() �����ڷ� �ѹ��� �ش�.

	// basic data source ��ü�� ����� ����Ҽ� �ִ� interface (������)
	DataSource ds = null; // javax.sql

//single-ton : ��ü 1���������ؼ� ���(����)����
	static DBService single = null; // static ������ �� �ϳ��� �������

	public static DBService getInstance() { // static ������ �� �ϳ��� �������

		if (single == null)
			single = new DBService(); // ó�� ȣ��� ����
		return single; // �׸��� ����
	}

	// JNDI (�̸��� �̿��ؼ� �ڿ��� �����ϴ�) �� �̿��� ���� ȹ��
	public DBService() {

		try {
			// 1.// java JNDI ���ؿ��� ��ü ���� (try / catch)
			InitialContext ic = new InitialContext();

			// 2.// Context.xml �˻� Resource ��ġ �˻� (casting �ʿ�)
			Context ctx = (Context) ic.lookup("java:comp/env");

			// 3.// Context.xml ���� Resource �˻� (casting �ʿ�)
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
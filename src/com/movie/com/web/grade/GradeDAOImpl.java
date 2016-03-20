package com.movie.com.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moive.web.global.Constants;

public class GradeDAOImpl implements GradeDAO {

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체

	@Override
	public void insert(GradeBean gradeBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GradeMemberBean> selectAll() {
		List<GradeMemberBean> list = new ArrayList<>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");

			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectAll 에러 발생");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public GradeMemberBean selectGradeByHak(int hak) {
		/*
		 * MemberBean member = new MemberBean(); GradeBean grade= new
		 * GradeBean();
		 */
		GradeMemberBean bean = new GradeMemberBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak =" + "'" + hak + "'");

			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
			}
		} catch (Exception e) {
			System.out.println("selectMember의 에러 발생");
			e.printStackTrace();
		}

		return bean;
	}

	@Override
	public List<GradeMemberBean> selectGradesByName(String name) {
		
		List<GradeMemberBean> list = new ArrayList<>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name =" + "'" + name + "'");

			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectMember의 에러 발생");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public  String update(GradeBean grade) {
		List<GradeMemberBean> list = new ArrayList<>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("update Grade set java = ?, sql = ?, jsp = ?, spring = ?"+
					"where hak = ?");

			rs.
		} catch (Exception e) {
			System.out.println("selectMember의 에러 발생");
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public List<GradeMemberBean> delete(int hak) {
		
		List<GradeMemberBean> list = new ArrayList<>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak =" + "'" + hak + "'");

			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				list.remove(bean);
			}
		} catch (Exception e) {
			System.out.println("selectMember의 에러 발생");
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public int count() {
		int count =0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM GradeMember");

			while (rs.next()) {
				count = rs.getInt("count");
			
			}
			/*stmt.executeQuery("SELECT * FROM GradeMember").last();
			count = rs.getRow();*/
		} catch (Exception e) {
			System.out.println("count GradeMember의 에러 발생");
			e.printStackTrace();
		}

		return count;
	}
	

}

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
	public GradeMemberBean selectAll() {
		GradeMemberBean bean = new GradeMemberBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember;");

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
			System.out.println("selectAll 에러 발생");
			e.printStackTrace();
		}

		return bean;
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
			String sample = "";

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
			
			System.out.println("◆◆◆◆ : " + sample);
		} catch (Exception e) {
			System.out.println("selectMember의 에러 발생");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String update(GradeBean grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int hak) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}

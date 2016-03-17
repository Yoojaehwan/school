package com.movie.com.web.memer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.moive.web.global.Constants;

public class MemberDAOImpl implements MemberDAO{
	
	private Connection conn; //오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; //쿼리 전송 객체2
	private ResultSet rs; //리턴값 회수 객체
	
	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean selectById(String id, String password) {
		return null;
	}

	@Override
	public MemberBean selectMember(String id) {
		MemberBean temp = new MemberBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id =" +"'"+id+"'");
			String sample = "";
			
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
			System.out.println("◆◆◆◆ : " + sample);
		} catch (Exception e) {
			System.out.println("selectMember의 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 :" +temp.getAddr());
		return temp;
	}
		

	@Override
	public MemberBean update(MemberBean member, String password, String Addr, int Birth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

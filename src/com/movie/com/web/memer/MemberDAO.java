package com.movie.com.web.memer;

public interface MemberDAO {
	public void insert(MemberBean member);
	public MemberBean selectById(String id, String password);
	public MemberBean selectMember(String id);
	public MemberBean update(MemberBean member,String password, String Addr, int Birth);
	public MemberBean delete(String id);

}

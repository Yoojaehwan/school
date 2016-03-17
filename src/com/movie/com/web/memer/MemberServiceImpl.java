package com.movie.com.web.memer;

import java.util.HashMap;

public class MemberServiceImpl implements MemberService {

	HashMap<String, MemberBean> map;
	MemberDAO dao = new MemberDAOImpl();

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	@Override
	public void join(MemberBean member) {
		// 회원가입
		map.put(member.getId(), member);
	}

	@Override
	public MemberBean login(String id, String password) {
		MemberBean doLog = new MemberBean();
		doLog = ((map.containsKey(id) == false || !map.get(id).getPassword().equals(password))) ? null : map.get(id);

		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서
		// 메세지를 전달해줘야 함

		return doLog;
	}

	@Override
	public MemberBean update(MemberBean member, String password, String Addr, int Birth) {
		member.setPassword(password);
		member.setAddr(Addr);
		member.setBirth(Birth);

		// 수정
		return member;
	}

	@Override
	public MemberBean remove(String id) {
		MemberBean doLog = new MemberBean();
		doLog = map.get(id);
		doLog = map.remove(id);
		// 내정보 보기

		return doLog;
		// 삭제

	}

	@Override
	public MemberBean detail(String id) {

		// 내정보 보기

		return dao.selectMember(id);
	}

}

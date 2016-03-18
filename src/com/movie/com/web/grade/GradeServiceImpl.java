package com.movie.com.web.grade;

import java.util.ArrayList;
import java.util.List;


public class GradeServiceImpl implements GradeService {
	/*
	 * private String name; private int hak, java, sql, jsp, spring;
	 */

	// 멤버 필드
	// 속성을 모아놓은곳 (Bean)
	private ArrayList<GradeBean> gradeList;
	GradeDAO dao = new GradeDAOImpl();
	// ArrayList<GradeBean> gradeList = new ArrayList<GradeBean>(); //인스턴스변수
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 인스턴스 변수 초기화
	}
	// 메서드 내부에 위치하면 참조변수(공유를 안하므로)
	// 멤버 메소드 에어리어
	// 기능을 모아놓은곳(Service)

	@Override
	public void input(GradeBean gradeBean) {
		// 성적표 등록 C
		gradeList.add(new GradeBean(2, "김구", 100, 100, 100, 100));
		gradeList.add(new GradeBean(3, "완유신", 90, 90, 90, 90));
		gradeList.add(new GradeBean(4, "강유신", 80, 80, 80, 80));
		gradeList.add(new GradeBean(5, "맘유신", 700, 70, 70, 70));
		gradeList.add(new GradeBean(6, "후유신", 60, 60, 60, 60));
		gradeList.add(new GradeBean(7, "김구", 50, 50, 50, 50));
		gradeList.add(gradeBean);
	}

	@Override
	public GradeMemberBean getList() {
		// 성적표 리스트 출력 R

		return dao.selectAll();

	}

	@Override
	public GradeMemberBean getGradeByHak(int hak) {
		// 성적표 조회(학번) R
	

		return dao.selectGradeByHak(hak);

	}

	@Override
	public List<GradeMemberBean> getGradesByName(String name) {
		// 성적표 조회(이름) R
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		for (int i = 0; i < gradeList.size(); i++) {
			if (name.equals(gradeList.get(i).getID())) {
				tempList.add(gradeList.get(i));

			}

		}

		return dao.selectGradesByName(name);
	}

	@Override
	public String update(GradeBean grade) {
		
		return null;
		// 성적표 수정 U

	}

	@Override
	public String delete(int hak) {

		return (gradeList.remove(this.getGradeByHak(hak))) ? "삭제성공" : "삭제실패";
		// 성적표 삭제 D

	}

	@Override
	public int getCount() {
		// R 카운트 조회

		return gradeList.size();

	}

	@Override
	public void getCountByName() {
		// R 이름조회시 카운트 조회

	}

}
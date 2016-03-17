package com.movie.com.web.grade;

import java.util.ArrayList;

public class GradeServiceImpl implements GradeService {
	/*
	 * private String name; private int hak, java, sql, jsp, spring;
	 */

	// 멤버 필드
	// 속성을 모아놓은곳 (Bean)
	private ArrayList<GradeBean> gradeList;

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
	public ArrayList<GradeBean> getList() {
		// 성적표 리스트 출력 R

		return gradeList;

	}

	@Override
	public GradeBean getGradeByHak(int hak) {
		// 성적표 조회(학번) R
		GradeBean tempGrade = new GradeBean();
		for (int i = 0; i < gradeList.size(); i++) {
			// System.out.println(gradeList.get(i).getHak());

			if (gradeList.get(i).getHak() == hak) {
				tempGrade = gradeList.get(i);

				break;
			}
		}

		return tempGrade;

	}

	@Override
	public ArrayList<GradeBean> getGradesByName(String name) {
		// 성적표 조회(이름) R
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		for (int i = 0; i < gradeList.size(); i++) {
			if (name.equals(gradeList.get(i).getName())) {
				tempList.add(gradeList.get(i));

			}

		}

		return tempList;
	}

	@Override
	public String update(GradeBean grade) {
		String result = "학번이 없습니다.";
		if (gradeList.contains(getGradeByHak(grade.getHak()))) {
			GradeBean searchedGrade = getGradeByHak(grade.getHak());
			searchedGrade.setJava(grade.getJava());
			searchedGrade.setSql(grade.getSql());
			searchedGrade.setJsp(grade.getJsp());
			searchedGrade.setSpring(grade.getSpring());
			result = "수정성공";

		}
		return result;
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
package com.movie.com.web.grade;

import java.util.ArrayList;
import java.util.Map;


public interface GradeDAO {
		// 성적표 등록  C
		public void insert(GradeBean gradeBean); //기능은 추상화하고 속성은 추상화하지 않는다.
		// 성적표 리스트 출력 R
		public GradeMemberBean selectAll();
		// 성적표 조회(학번) R
		public GradeMemberBean selectGradeByHak(int hak);
		// 성적표 조회(이름) R
		public GradeMemberBean selectGradesByName(String name);
		// 성적표 수정 U
		public String update(GradeBean grade);
		// 성적표 삭제 D
		public String delete(int hak);
		// R 카운트 조회
		public int count();
	
		
}

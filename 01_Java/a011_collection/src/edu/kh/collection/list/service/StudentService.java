package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {

	
//	private List<Student> studentList = new ArrayList<Student>();
	private List<Student> studentList = new LinkedList<Student>();
											// List구현 클래스마다 장/단점이 있어 골라서 사용
	
	
	
	public StudentService() {
		
		studentList.add(new Student("홍길동",3,5,1,"서울시 중구 남대문로",'M',75));
		studentList.add(new Student("옹심이",2,3,7,"부산시 창천구",'F',65));
		studentList.add(new Student("감자탕",1,2,6,"경기도 안산시",'M',70));
		studentList.add(new Student("수제비",2,2,5,"서울시 서대문구",'M',95));
		studentList.add(new Student("해장국",3,4,9,"서울시 강남구",'F',15));
		
	}
	
	
	
	/** studentList에 학생 추가
	 * @param std
	 * @return true
	 */
	public boolean addStudent(Student std) {
		return studentList.add(std);
	}
	
	
	/** 학생 전체 조회 서비스
	 * @return studentList
	 */
	public List<Student> selectAll() {
		return studentList;
	}


	/**
	 * 학생 정보 수정 서비스
	 * @param index
	 * @param std
	 * @return s:Student (수정되기 전 학생 정보)
	 */
	public Student updateStudent(int index, Student std) {
		
		// e2 set(int index, E e)
		// 1) index에 위치하는 요소를 e로 변경
		// 2) 기존에 있던 요소 e2를 반환
		
		return studentList.set(index, std); // 바뀌기 전 값 반환
	}



	/** 학생 정보 제거 서비스
	 * @param index
	 * @return s:Student (제거된 학생 정보)
	 */
	public Student removeStudent(int index) {

		// E remove(int index) : index번째 요소를 List에서 제거하여 반환
		
		// boolean remove(E e) : List에서 E와 일치하는 요소를 찾아서
		//						있으면 제거하고 true
		//						없으면 false 반환
		
		
		return studentList.remove(index); // 제거되기 전 값 반환
	}



	/** 학생 이름 검색 서비스
	 * @param name
	 * @return list:List<Student> 이름이 일치하는 학생 리스트
	 */
	public List<Student> selectName(String name) {
		
		// 1) 검색 결과를 저장할 List<Student>생성
		List<Student> list = new ArrayList<Student>();
		
		// 2) studentList의 모든 요소를 순차 접근하면서 이름이 일치하는 학생을 list에 추가
		for(Student s : studentList) {
			if(s.getName().equals(name))  list.add(s);
		}
		
		
		// 3) 검색 결과 반환
		return list;
	}



	/** 학생 주소 검색 서비스
	 * @param address
	 * @return list:List<Student> 검색어가 주소에 포함된 학생 리스트
	 */
	public List<Student> selectAddress(String input) {

		List<Student> list = new ArrayList<Student>();
		
		for(Student s : studentList) {
			
			// String.contains("문자열") : String에 "문자열"이 포함되어 있으면 true 반환
			if(s.getAddress().contains(input)) list.add(s);
			
		}
		
		return list;
	}



	/** 학년별 조회
	 * @param input
	 * @return list:List<Student> input과 학년이 일치하는 학생 리스트
	 */
	public List<Student> selectGrade(int input) {

		List<Student> list = new ArrayList<>();
		// 제네릭의 타입 추론
				// - 생성되는 컬렉션 객체의 제네릭을 별도 작성하지 않아도
				//   참조 변수의 제네릭을 통해 제한되는 타입을 유추(추론)
		
		for(Student s : studentList) {
			if(s.getGrade() == input) list.add(s);
		}
		return list;
	}



	/** 성별 조회
	 * @param input
	 * @return list:List<Student> inputGender와 성별이 같은 학생 리스트
	 */
	public List<Student> selectGender(char inputGender) {

		List<Student> list = new ArrayList<>();
		
		for(Student s : studentList) {
			if(s.getGender() == inputGender) list.add(s);
		}
		
		return list;
	}



	/**성적 순서 조회 서비스
	 * @return list:List<Student>
	 */
	public List<Student> sortScore() {

		// studentList 정렬 (score 내림 차순)
		// - Collections 클래스 : 컬렉션에 도움되는 유용한 기능을 모은 클래스
		
		// - Comparable<T> 인터페이스
		//   -> 객체의 기본 정렬 기준을 제공하는 인터페이스
		
		// <?> : 어떤게 작성될지 모름 == 아무거나 작성 가능
		// <?> void Collections.sort(List<?> list)
		Collections.sort(studentList);
		// studentList에 저장된 객체 Student의
		// 오버라이딩된 compareTo() 메서드를 이용해서 정렬
		// -> 현재 큰 숫자가 오른쪽으로 이동하도록 오버라이딩됨
		// -> 오름차순 정렬 
		
		// void Collections.reverse(List<?> list)
		// -> list순서를 반대로 뒤집음
		// -> 오름차순 -> 내림차순
		// Collections.reverse(studentList);
		
		return studentList;
	}
	
	
	
	
	
	
}

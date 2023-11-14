package com.smhrd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Board;

@Repository
public interface BoardRepository extends JpaRepository<Tbl_Board, Long> {

	// JpaRepository interface 상속 받아야한다.
	// JpaRepository< 테이블과 연동된 DTO, primary Key의 자료형 >
	
	// 1.
	// 기본적인 CRUD 기능이 이미 완성 되어있음 // 우리가 구현할 필요없음
	// --> 생산성 증가
	// findAll() --> Select * from Tbl_Board;
	// findById( Long idx ) --> Select * from Tbl_Board idx = #{idx};
	// save( Entity e ) --> insert / update
	//						1) select by id
	// 						2) select 결과 O --> update
	//									  X --> insert
	
	// 2. 만약에 다른 기능이 필요하다면 
	// select * from tbl_board where title = #{title} and writer = #{writer};
	// No Sql, 메서드만 만들 것 
	// 이름 규칙 잘 지켜서 --> 카멜기법으로 작성
	public List<Tbl_Board> findByTitleAndWriter( String title, String writer );
	
	// select * from tbl_board where idx = #{idx} and title = #{title}
	public Tbl_Board findByIdxAndTitle ( Long idx, String title );
	
	
	// 5 ~ 10 번 까지만 
	// from ( select ..., rownum as RN from tbl_board )
	// @Query("sql")
	// public... method()...
	// > 직접 지정할 수는 있는데, 복잡해지면 유지 보수가 좋지 않아, MyBatis와 같이 쓰는걸 추천
	
	
	
	
}

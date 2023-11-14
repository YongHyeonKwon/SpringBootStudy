package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Tbl_Board {

	// ORM(Object Relation Model)
	// DTO <--> Table
	// No SQL
	
	// int --> Integer
	// long --> Long
	@Id // Primary Key
	@GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
	@Column( insertable = false, updatable = false ) // 수정 X, 삽입 X
	private Long idx;
	
	@Column( nullable = false ) // not null 
	private String title;
	
	@Column( nullable = false )
	private String writer;
	
	// @Column을 이용해서 컬럼의 상세 설정을 진행
	@Column( length = 1000, nullable = false )
	private String content;
	
	private String img;
	
	// indate datetime default now()
	@Column( columnDefinition = "datetime default now()", updatable = false, insertable = false )
	private Date indate;
	
	// count int default 0
	@Column( columnDefinition = "int default 0", insertable = false )
	private Long count;
	
}

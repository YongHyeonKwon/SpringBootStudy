package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Tbl_Board;
import com.smhrd.repository.BoardRepository;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardRepository repo;
	
	@RequestMapping("/boardList")
	public List<Tbl_Board> boardList() {
		
		
		// 게시글 전체 데이터를 JSON 형식으로 응답
		List<Tbl_Board> list = repo.findAll();
	
		return list;
	}
	
	
}

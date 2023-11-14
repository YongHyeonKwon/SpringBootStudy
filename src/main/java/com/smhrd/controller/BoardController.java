package com.smhrd.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Tbl_Board;
import com.smhrd.repository.BoardRepository;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository repo;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list( Model model ) {
		
		// 2. 기능 실행 - 게시글 정보 가져오고, 객체바인딩
		// findAll(): 전체 목록 가져오기
		List<Tbl_Board> list = repo.findAll();
		
		model.addAttribute("list", list);
		
		return "boardList"; // JSP 파일의 이름 리턴
	}
	
	
	@RequestMapping("/goWrite")
	public String goWrite() {
		return "boardWrite";
	}	
		
	@RequestMapping("/write")
	public String write( MultipartFile file,  Tbl_Board board ) {
		// 1. 데이터 수집
		
		// 2. file 처리(이름 변경, 저장)
		
		// 1) 경로 잡기 
		final String PATH = System.getProperty("user.dir") +"\\src\\main\\resources\\static\\img\\";
		
		// 2) 저장할 파일 이름 결정 
		UUID uuid = UUID.randomUUID(); // 랜덤한 문자열을 만들기
		
		String fileName = uuid + "_" + file.getOriginalFilename();
		// A1B2-C3D4
		// cat.jpg
		// >> A1B2-C3D4_cat.jpg
		
		// 3) 파일 저장 
		try {
			// 3-1) 경로에 비어있는 파일 만들기 
			File f = new File( PATH + fileName );
			
			// 3-2) 만들어둔 파일에 옮겨 담기 
			file.transferTo(f);
			
			// 3-3) DTO에 파일 이름을 집어넣기 
			board.setImg( fileName );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		// DB에 수집한 정보 저장 
		repo.save( board );
		
		return "redirect:/list";	
		
	}
	
	
}

package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	// MyBatis 와 연결을 위해 -> Autowired : 자동으로 연결 -> interface
	@Autowired
	private  MenuMapper  menuMapper;
	
	// 메뉴 목록 조회 : /Menus/List
	@RequestMapping("/List")	
	public String list( Model model ) {		// import : 밑에꺼(Spring 꺼)
		// 1. 조회 해서
		// = mapper 가서 읽어오라(select 실행 = .xml 에서)
		// menuMapper.getMenuList();  ->  돌려받아야함 -> ArrayList(개수가 확정되지 않은 배열) -> ArrayList 의 부모 List
		// List : ArrayList를 던져주든, vector를 던져주든, linkedList를 던져주든 다 처리할 수 있다
		// ∴ 조회한 결과를 ArrayList 로 돌려준다
		List<MenuVo> menuList = menuMapper.getMenuList();
		
		// 2. 조회 결과를 Model 에 넘겨준다 -> jsp 가 쓰려는걸 담는 공간 : Model
		model.addAttribute( "menuList", menuList );		// ( "$에 들어갈 이름", 변수 )
		System.out.println( "MenuController list() menuList:" + menuList );
		
		return "menus/list";
	}
	
	// 메뉴 입력받는 화면 : /Menus/WriteForm
	// @RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")		// "/Menus" 만 따로 RequestMapping 할 수 있다(@Controller 밑)
	public String writeForm() {
		return "menus/write";		// /WEB-INF/views/  +  menus/write  +  .jsp
	}
	
	// 메뉴 저장 : /Menus/Write  ->  저장 후 list.jsp 이동
	// http://localhost:9090/Menus/Write ? menu_id=MENU02 & menu_name=JSP & menu_seq=2
	// @RequestMapping("/Menus/Write")
	@RequestMapping("/Write")
	// public String write( String menu_id, String menu_name, int menu_seq ) {}		// 인식안됨(error) : menu_id 찾을 수 없다
	public String write( MenuVo menuVo ) {
		// 넘어온 데이터를 db 에 저장하고
		// 저장 : mapper
		menuMapper.insertMenu( menuVo );		// menuMapper : db에 저장하는 담당 라이브러리와의 연결을 담당하는 인터페이스
												// insertMenu : F2 -> Create Method -> MenuMapper.java 에 생성
		
		return "menus/list";		// menus/list.jsp
	}
	
}

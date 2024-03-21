package com.board.menus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.menus.domain.MenuVo;

// 어노테이션(@Mapper) + 인터페이스(MenuMapper) -> 호출할놈 이름(insertMenu)

@Mapper
public interface MenuMapper {

	// void insertMenu(String menu_id, String menu_name, int menu_seq);		// @Mapper : menuMapper.xml 에서 insertMenu(= id) 를 찾아라
	// 위 : 에러
	
	// menuMapper.xml 에서 id="insertMenu" SQL 문을 찾아서 실행
	// menuMapper.xml 에서 namespace : MenuMapper  ->  3줄 : <mapper namespace="com.board.menus.mapper.MenuMapper">
	void insertMenu(MenuVo menuVo);

	List<MenuVo> getMenuList();
	
}

package com.board.menus.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor		// NoArgs  : 기본 생성자
@AllArgsConstructor		// AllArgs : 모든 인자 있는 생성자
public class MenuVo {
	// Fields
	@NonNull			// import : lombok NonNull
	private String menu_id;
	private String menu_name;
	private String menu_seq;
	
}

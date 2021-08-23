package com.javaland.stg.controller;

import com.javaland.stg.model.service.CharacterUpdateService;
import com.javaland.stg.model.dto.CharacterDTO;

public class CharacterUpdateController {

	private CharacterUpdateService characterUpdateService = new CharacterUpdateService();
	
	public CharacterDTO updatePlayer(String id, int code) {
		
		CharacterDTO character = characterUpdateService.characterUpdateService(id, code);
		
		return character;
	}
}

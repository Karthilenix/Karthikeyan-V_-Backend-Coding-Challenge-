package com.hexaware.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.player.dto.PlayerDTO;
import com.hexaware.player.entity.Player;
import com.hexaware.player.service.IPlayer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/player")
public class PlayerController {
	
	@Autowired
	IPlayer service;
	
	@PostMapping("/add")
	public Player addPlayer( @Valid @RequestBody   PlayerDTO dto) {
		return service.addPlayer(dto);
	}
	
	@GetMapping("/getById/{playerid}")
	public Player getPlayerById(@PathVariable int playerid) {
		return service.getPlayerById(playerid);
	}
	
	@GetMapping("/getAllPlayer")
	public List<Player> getAllPlayer(){
		return service.getAllPlayer();
	}
	
	@PutMapping("/update/{playerid}")
	public Player updatePlayerById(@Valid @RequestBody @PathVariable int playerid,PlayerDTO dto) {
		return service.updatePlayerById(playerid, dto);
				
	}
	
	@DeleteMapping("delete/{playerid}")
	public String  deletePlayer(@PathVariable int playerid) {
		service.deletePlayer(playerid);
		return "Player deleted";
	}
}

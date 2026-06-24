package com.hexaware.player.service.impl;

import com.hexaware.player.exception.GlobalExceptionHandler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.player.dto.PlayerDTO;
import com.hexaware.player.entity.Player;
import com.hexaware.player.exception.PlayerNotFoundException;
import com.hexaware.player.repository.PlayerRepository;
import com.hexaware.player.service.IPlayer;

@Service
public class PlayerService implements IPlayer {
	
	private final GlobalExceptionHandler globalExceptionHandler;
	@Autowired
	PlayerRepository repo;

	PlayerService(GlobalExceptionHandler globalExceptionHandler) {
		this.globalExceptionHandler = globalExceptionHandler;
	}
	
	@Override
	public Player addPlayer(PlayerDTO dto) {
		
		Player ply = new Player();
		
		ply.setPlayername(dto.getPlayername());
		ply.setJnumber(dto.getJnumber());
		ply.setRole(dto.getRole());
		ply.setTolmatches(dto.getTolmatches());
		ply.setTeamname(dto.getTeamname());
		ply.setCountryname(dto.getCountryname());
		return repo.save(ply);
	}

	@Override
	public Player getPlayerById(int playerid) {
		return repo.findById(playerid).orElseThrow(() ->new PlayerNotFoundException("Player Not Found"));
	}

	@Override
	public List<Player> getAllPlayer() {
		return repo.findAll();
	}

	@Override
	public Player updatePlayerById(int playerid, PlayerDTO dto) {
		Player ply = getPlayerById(playerid);
		
		ply.setPlayername(dto.getPlayername());
		ply.setJnumber(dto.getJnumber());
		ply.setRole(dto.getRole());
		ply.setTolmatches(dto.getTolmatches());
		ply.setTeamname(dto.getTeamname());
		ply.setCountryname(dto.getCountryname());
		return repo.save(ply);
	}

	@Override
	public void deletePlayer(int playerid) {
		repo.deleteById(playerid);	
	}
}

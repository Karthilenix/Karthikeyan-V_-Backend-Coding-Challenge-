package com.hexaware.player.service;

import java.util.List;

import com.hexaware.player.dto.PlayerDTO;
import com.hexaware.player.entity.Player;

public interface IPlayer {
	public Player addPlayer(PlayerDTO dto);
	
	public Player getPlayerById(int playerid);
	
	public List<Player> getAllPlayer();
	
	public Player updatePlayerById(int playerid,PlayerDTO dto);
	
	public void  deletePlayer(int playerid);
}

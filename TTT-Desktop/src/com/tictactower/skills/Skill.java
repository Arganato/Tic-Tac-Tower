package com.tictactower.skills;

import com.badlogic.gdx.Gdx;
import com.tictactower.Game;
import com.tictactower.gameboard.Mark;
import com.tictactower.gamelogic.Towers;
import com.tictactower.player.Player;
import com.tictactower.player.Player1;
import com.tictactower.ui.buttons.Buttons;


public class Skill {
	
	private SkillType flag;
	
	public Skill(){
		flag = SkillType.NO_SKILL;
	}
	
	public void cancelSkill(){
		flag = SkillType.NO_SKILL;
	}
	
	public void useSkill(SkillType skill){
		flag = skill;
	}
	
	public SkillType getFlag(){
		return flag;
	}
	
	public void executeSkillOnPosition(int x, int y){
		Player activePlayer = Game.getInstance().getActivePlayer();
		switch(Game.getInstance().getSkill().getFlag()){
		
			case NO_SKILL:
				
				if (Game.getInstance().getGameboard().getMark(x, y) == Mark.EMPTY && Game.getInstance().getActivePlayer().getNotUsedMark()) {
					if(!activePlayer.isSilenced()){
						activePlayer.setMark(x, y);
						activePlayer.setNotUsedMark(false);
						activePlayer.setCanUndo(true);
						Towers.findTowers(x, y, activePlayer);
					}else{ //if the player has been silenced
						activePlayer.setMark(x, y);
						if(Towers.findTowers(x, y, activePlayer)){ 
							//this means that a tower has been found, and the move is illegal
							Game.getInstance().getGameboard().clearMark(x, y);
							//print something saying the move is illegal...
						}else{
							//the move is accepted
							activePlayer.setNotUsedMark(false);
							activePlayer.setCanUndo(true);
							Buttons.getButtonEndTurn().setActive(true);					
						}
					}
				}
				break;
			
			case SHOOT:
				//Gdx.app.log("Input", "shoot");
				if(activePlayer instanceof Player1){
					if(Game.getInstance().getGameboard().getMark(x, y) == Mark.P2_ACTIVE){
						Game.getInstance().getGameboard().setMark(x, y, Mark.DESTROYED);
						activePlayer.subShootCount();
						activePlayer.incShootUsage();
						activePlayer.setCanUndo(true);
					}
				}else{
					if(Game.getInstance().getGameboard().getMark(x, y) == Mark.P1_ACTIVE){
						Game.getInstance().getGameboard().setMark(x, y, Mark.DESTROYED);
						activePlayer.subShootCount();
						activePlayer.incShootUsage();
						activePlayer.setCanUndo(true);
					}
				}
				break;
				
			case BUILD:
				//Gdx.app.log("Input", "build");
				if (Game.getInstance().getGameboard().getMark(x, y) == Mark.EMPTY) {
					if(!activePlayer.isSilenced()){
						activePlayer.setMark(x, y);
						activePlayer.subBuildCount();
						activePlayer.incBuildUsage();
						Towers.findTowers(x, y, activePlayer);
						activePlayer.setCanUndo(true);
					}else{ //if the player has been silenced
						activePlayer.setMark(x, y);
						if(!Towers.findTowers(x, y, activePlayer)){ 
							//this means that a tower has been found, and the move is illegal
							Game.getInstance().getGameboard().clearMark(x, y);
							Gdx.app.log("input","illegal move: you're silenced!");
							//print something saying the move is illegal...
						}else{
							//the move is accepted
							activePlayer.subBuildCount();
							activePlayer.incBuildUsage();
							activePlayer.setCanUndo(true);
						}
					}
				}
				break;
				
			case SILENCE:
				Gdx.app.log("Input", "emp");
				if(activePlayer instanceof Player1){
					Game.getInstance().getPlayer2().setSilenced(true);
				}else{
					Game.getInstance().getPlayer1().setSilenced(true);
				}
				activePlayer.setCanUndo(true);
				activePlayer.setHaveUsedSilence(true);
				activePlayer.subSilenceCount();
				activePlayer.incSilenceUsage();
				break;
			default:
				Gdx.app.log("Input", "No skill selected!?");
				break;
		}
		Game.getInstance().getSkill().cancelSkill();
	}
	
	
}

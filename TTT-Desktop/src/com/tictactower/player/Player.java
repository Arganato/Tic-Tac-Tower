package com.tictactower.player;

import com.badlogic.gdx.Gdx;
import com.tictactower.gameboard.Mark;

public abstract class Player {
	
	protected boolean notUsedMark;
	protected boolean haveUsedSilence;
	protected boolean canUndo;
	
	protected int score;
	protected int id;
	protected boolean silenced;

	protected int silenceCount = 0;
	protected int buildCount = 0;
	protected int shootCount = 0;
	protected int skillCap = 1;

	
	protected int silenceUsage = 0;
	protected int buildUsage = 0;
	protected int shootUsage = 0;

	
	public abstract int getPlayerId();
	
	protected int[] skillCounts = new int[4];
	
	public Player() {
		notUsedMark = false;
	}

	public abstract void setMark(int x, int y);
	
	public boolean getNotUsedMark() {
		return notUsedMark;
	}
	
	public void setNotUsedMark(boolean notUsedMark) {
		this.notUsedMark = notUsedMark;
	}
	
	public boolean isSilenced(){
		return silenced;
	}
	public void setSilenced(boolean silenced){
		this.silenced = silenced;
	}
		
	public int getSilenceCount() {
		return silenceCount;
	}
	
	public void subSilenceCount() {
		silenceCount--;
		if (silenceCount <= 0) {
			silenceCount = 0;
		}
	}

	public void addSilenceCount() {
		Gdx.app.log("Silence", "Increase");
		silenceCount++;
	}

	public int getBuildCount() {
		return buildCount;
	}

	public void addBuildCount() {
		Gdx.app.log("Build", "Increase");
		buildCount++;
	}
	
	public void subBuildCount() {
		buildCount--;
		if (buildCount <= 0) {
			buildCount = 0;
		}
	}

	public int getShootCount() {
		return shootCount;
	}

	public void addShootCount() {
		Gdx.app.log("Shoot", "Increase");
		shootCount++;
	}
	
	public void subShootCount() {
		shootCount--;
		if (shootCount <= 0) {
			shootCount = 0;
		}
	}

	public int getSkillCap() {
		return skillCap;
	}

	public void addSkillCap() {
		Gdx.app.log("Skill Cap", "Increase");
		skillCap++;
	}
	
	public void subSkillCap() {
		skillCap--;
	}
	
	public void incSilenceUsage(){
		silenceUsage++;
	}
	
	public int getSilenceUsage(){
		return silenceUsage;
	}
	
	public void incBuildUsage(){
		buildUsage++;
	}
	
	public int getBuildUsage(){
		return buildUsage; 
	}
	
	public void incShootUsage(){
		shootUsage++;
	}
	
	public int getShootUsage(){
		return shootUsage;
	}
	
	public void resetSkillUsage(){
		silenceUsage = 0;
		buildUsage = 0;
		shootUsage = 0;
	}
	
	public void resetPlayer() {

		silenceCount = 0;
		buildCount = 0;
		shootCount = 0;
		skillCap = 1;
		
		silenceUsage = 0;
		buildUsage = 0;
		shootUsage = 0;
		silenced = false;
	}
	
	public void saveSkillCounts() {
		skillCounts[0] = buildCount;
		skillCounts[1] = shootCount;
		skillCounts[2] = silenceCount;
		skillCounts[3] = skillCap;
	}
	
	public void resetSkillCounts() {
		buildCount = skillCounts[0];
		shootCount = skillCounts[1];
		silenceCount = skillCounts[2];
		skillCap = skillCounts[3];
	}
	
	public void setHaveUsedSilence(boolean haveUsedSilence) {
		this.haveUsedSilence = haveUsedSilence;
	}
	
	public boolean getHaveUsedSilence() {
		return haveUsedSilence;
	}
	
	public boolean getCanUndo() {
		return canUndo;
	}
	
	public void setCanUndo(boolean canUndo) {
		this.canUndo = canUndo;
	}
	
	public abstract Mark getActiveMark();
	
	
	
}

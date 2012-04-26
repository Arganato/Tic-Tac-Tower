package com.tictactower.player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.tictactower.gameboard.Mark;
import com.tictactower.skills.Skill;
import com.tictactower.skills.SkillType;
import com.tictactower.ui.buttons.Buttons;

public abstract class Player {
	
	protected boolean notUsedMark;
	
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
	
	protected ArrayList<Skill> skills;
	protected ArrayList<Vector2> newMarkList = new ArrayList<Vector2>();
	protected ArrayList<SkillType> usedSkillList = new ArrayList<SkillType>();
	
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
			Buttons.getButtonSilence().updateActive();
		}
	}

	public void addSilenceCount() {
		Gdx.app.log("Silence", "Increase");
		silenceCount++;
		Buttons.getButtonSilence().updateActive();
	}

	public int getBuildCount() {
		return buildCount;
	}

	public void addBuildCount() {
		Gdx.app.log("Build", "Increase");
		buildCount++;
		Buttons.getButtonNewTower().updateActive();
	}
	
	public void subBuildCount() {
		buildCount--;
		if (buildCount <= 0) {
			buildCount = 0;
			Buttons.getButtonNewTower().updateActive();
		}
	}

	public int getShootCount() {
		return shootCount;
	}

	public void addShootCount() {
		Gdx.app.log("Shoot", "Increase");
		shootCount++;
		Buttons.getButtonDestroyTower().updateActive();
	}
	
	public void subShootCount() {
		shootCount--;
		if (shootCount <= 0) {
			shootCount = 0;
			Buttons.getButtonDestroyTower().updateActive();
		}
	}

	public int getSkillCap() {
		return skillCap;
	}

	public void addSkillCap() {
		Gdx.app.log("Skill Cap", "Increase");
		skillCap++;
		Buttons.getButtonMultipleTowers().updateActive();
	}
	
	public void subSkillCap() {
		skillCap--;
	}
	
	public void IncSilenceUsage(){
		silenceUsage++;
	}
	
	public int GetSilenceUsage(){
		return silenceUsage;
	}
	
	public void IncBuildUsage(){
		buildUsage++;
	}
	
	public int GetBuildUsage(){
		return buildUsage; 
	}
	
	public void IncShootUsage(){
		shootUsage++;
	}
	
	public int GetShootUsage(){
		return shootUsage;
	}
	
	public void ResetSkillUsage(){
		silenceUsage = 0;
		buildUsage = 0;
		shootUsage = 0;
	}
	
	public void resetPlayer() {

		silenceCount = 0;
		buildCount = 0;
		shootCount = 0;
		skillCap = 0;
		
		silenceUsage = 0;
		buildUsage = 0;
		shootUsage = 0;
		silenced = false;
	}
	
	public ArrayList<Vector2> getNewMarkList() {
		return newMarkList;
	}
	
	public void addToNewMarkList(Vector2 newMark) {
		newMarkList.add(newMark);
	}
	
	public void resetNewMarkList() {
		newMarkList = new ArrayList<Vector2>();
	}

	public ArrayList<SkillType> getUsedSkillList() {
		return usedSkillList;
	}

	public void addToUsedSkillList(SkillType newSkill) {
		usedSkillList.add(newSkill);
	}
	
	public void resetUsedSkillList() {
		usedSkillList = new ArrayList<SkillType>();
	}
	
	public abstract Mark getActiveMark();
	
	
	
}

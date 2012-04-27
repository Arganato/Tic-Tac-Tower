package com.tictactower;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tictactower.gameboard.Gameboard;
import com.tictactower.graphics.Graphics;
import com.tictactower.input.Input;
import com.tictactower.player.Player;
import com.tictactower.player.Player1;
import com.tictactower.player.Player2;
import com.tictactower.skills.Skill;
import com.tictactower.skills.SkillType;
import com.tictactower.ui.buttons.Buttons;
import com.tictactower.ui.text.TextBoxes;

public class Game implements ApplicationListener {
	
	// Singleton holder
	private static class SingletonHolder { 
        public static final Game instance = new Game();
	}

	// Method to get the singleton
	public static Game getInstance() {
        return SingletonHolder.instance;
	}
	
	private Gameboard gameboard;
	private Player1 player1;
	private Player2 player2;
	private Graphics graphics;
	private Buttons buttons;
	private TextBoxes textBoxes;
	private Skill skill;
	
	private Player activePlayer;
	
	SpriteBatch spriteBatch;

	@Override
	public void create() {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		
		// Input trenger ingen peker siden kommunikasjonen bare er event-driven ut fra Input.
		new Input();
		
		gameboard = new Gameboard();
		player1 = new Player1();
		player2 = new Player2();
		graphics = new Graphics();
		buttons = new Buttons();
		textBoxes = new TextBoxes();
		skill = new Skill();
		
		activePlayer = player1;
		activePlayer.setNotUsedMark(true);
		gameboard.saveGameboard();
		
		spriteBatch = new SpriteBatch();
		
		
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		graphics.draw(spriteBatch);
		spriteBatch.end();
	}

	@Override
	public void resize(int arg0, int arg1) {
	}

	@Override
	public void resume() {
	}
	
	public void reset() {
		getGameboard().resetGameboard();
		getPlayer1().resetPlayer();
		getPlayer2().resetPlayer();
		activePlayer = player1;
		activePlayer.setNotUsedMark(true);
		Buttons.getButtonEndTurn().updateActive();
	}
	
	public Gameboard getGameboard() {
		return gameboard;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
	public Buttons getButtons() {
		return buttons;
	}
	
	public TextBoxes getTextBoxes() {
		return textBoxes;
	}
	
	public Skill getSkill(){
		return skill;
	}
	
	public Player getActivePlayer() {
		return activePlayer;
	}
	
	public void changeActivePlayer() {
		activePlayer.setNotUsedMark(false);
		activePlayer.resetSkillUsage();
		activePlayer.setSilenced(false);
		if (activePlayer instanceof Player1)
			activePlayer = player2;
		else
			activePlayer = player1;
		activePlayer.setNotUsedMark(true);
		skill.cancelSkill();
		gameboard.saveGameboard();
		activePlayer.saveSkillCounts();
		activePlayer.setCanUndo(false);
		activePlayer.setHaveUsedSilence(false);
	}
	
}

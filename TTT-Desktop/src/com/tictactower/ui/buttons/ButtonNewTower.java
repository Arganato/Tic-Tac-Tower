package com.tictactower.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;
import com.tictactower.player.Player;
import com.tictactower.skills.SkillType;

public class ButtonNewTower extends Button {
	
	private final static int WIDTH = (Gdx.graphics.getWidth() - Gameboard.X_OFFSET * 2 - 10) / 3;
	private final static int HEIGHT = 50;
	private final static int POSITION_X = Gameboard.X_OFFSET + WIDTH + 5;
	private final static int POSITION_Y = (int)Buttons.getButtonEndTurn().getPosition().y - (HEIGHT + 5);
	
	public ButtonNewTower(boolean active) {
		super(WIDTH, HEIGHT, POSITION_X, POSITION_Y);
		this.active = active;
	}

	@Override
	public void execute() {
		Game.getInstance().getSkill().useSkill(SkillType.BUILD);
		Gdx.app.log("ButtonNewTower", "NEW TOWAAAR!");
	}
	
	public void updateActive(){
		Player activePlayer = Game.getInstance().getActivePlayer();
		active = activePlayer.getBuildCount()>0 && activePlayer.getBuildUsage()<activePlayer.getSkillCap();
	}
}

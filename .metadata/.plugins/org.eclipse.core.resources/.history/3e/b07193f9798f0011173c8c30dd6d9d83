package com.tictactower.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.tictactower.gameboard.Gameboard;

public class ButtonQuit extends Button {
	
	private final static int WIDTH = Gameboard.GAMEBOARD_EDGE_LENGTH / 2 - 5;
	private final static int HEIGHT = 30;
	private final static int POSITION_X = Gameboard.X_OFFSET;
	private final static int POSITION_Y = Gdx.graphics.getHeight() - 35;
	
	public ButtonQuit(boolean active) {
		super(WIDTH, HEIGHT, POSITION_X, POSITION_Y);
		this.active = active;
	}

	@Override
	public void execute() {
		Gdx.app.exit();
	}

}

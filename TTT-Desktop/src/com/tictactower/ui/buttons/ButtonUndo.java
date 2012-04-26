package com.tictactower.ui.buttons;

import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;

public class ButtonUndo extends Button {
	
	private final static int WIDTH = Gameboard.GAMEBOARD_EDGE_LENGTH / 3;
	private final static int HEIGHT = 40;
	private final static int POSITION_X = Gameboard.X_OFFSET + Gameboard.GAMEBOARD_EDGE_LENGTH * 2 / 3;
	private final static int POSITION_Y = Gameboard.Y_OFFSET - HEIGHT - 5;
	
	public ButtonUndo(boolean active) {
		super(WIDTH, HEIGHT, POSITION_X, POSITION_Y);
		this.active = active;
	}

	@Override
	public void execute() {
	}

}

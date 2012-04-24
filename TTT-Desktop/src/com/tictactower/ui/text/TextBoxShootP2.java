package com.tictactower.ui.text;

import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;

public class TextBoxShootP2 extends TextBox {
	
	private final static int POSITION_X = 170;
	private final static int POSITION_Y = Gameboard.Y_OFFSET + Gameboard.GAMEBOARD_EDGE_LENGTH + 35;
	private final static String text = "Shoot: " + Integer.toString(Game.getInstance().getPlayer2().getShootCount());
	private final static float[] colorActive = {0, 0, 1, 1};
	private final static float[] colorDeactive = {0, 0, 0.8f, 1};
	
	public TextBoxShootP2() {
		super(POSITION_X, POSITION_Y, text, colorActive, colorDeactive);
	}
	

}

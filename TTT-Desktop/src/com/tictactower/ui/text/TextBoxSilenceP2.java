package com.tictactower.ui.text;

import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;

public class TextBoxSilenceP2 extends TextBox {
	
	private final static int POSITION_X = 235;
	private final static int POSITION_Y = Gameboard.Y_OFFSET + Gameboard.GAMEBOARD_EDGE_LENGTH + 35;
	private final static String text = "Silence: " + Integer.toString(Game.getInstance().getPlayer2().getSilenceCount());
	private final static float[] colorActive = {0, 0, 1, 1};
	private final static float[] colorDeactive = {0, 0, 0.8f, 1};
	
	public TextBoxSilenceP2() {
		super(POSITION_X, POSITION_Y, text, colorActive, colorDeactive);
	}
	

}

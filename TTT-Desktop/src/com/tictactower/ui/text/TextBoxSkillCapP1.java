package com.tictactower.ui.text;

import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;

public class TextBoxSkillCapP1 extends TextBox {
	
	private final static int POSITION_X = 80;
	private final static int POSITION_Y = Gameboard.Y_OFFSET + Gameboard.GAMEBOARD_EDGE_LENGTH + 20;
	private final static String text = "Skill cap: ";
	private final static float[] colorActive = {1, 0, 0, 1};
	private final static float[] colorDeactive = {0.8f, 0, 0, 1};
	
	public TextBoxSkillCapP1() {
		super(POSITION_X, POSITION_Y, colorActive, colorDeactive);
		super.text = text;
		value = fetchValue();
	}

	@Override
	public int fetchValue() {
		return Game.getInstance().getPlayer1().getSkillCap();
	}
	
}

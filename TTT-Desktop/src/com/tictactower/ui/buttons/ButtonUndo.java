package com.tictactower.ui.buttons;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;
import com.tictactower.gameboard.Mark;
import com.tictactower.skills.SkillType;

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
		ArrayList<SkillType> usedSkillList = Game.getInstance().getActivePlayer().getUsedSkillList();
		ArrayList<Vector2> newMarkList = Game.getInstance().getActivePlayer().getNewMarkList();
		while (!usedSkillList.isEmpty()) {
			switch (usedSkillList.get(usedSkillList.size()-1)) {
				case NO_SKILL:
					Game.getInstance().getGameboard().setMark((int)newMarkList.get(newMarkList.size()-1).x, 
							(int)newMarkList.get(newMarkList.size()-1).y, 
							Mark.EMPTY);
				case SHOOT:
					
					
			}
			usedSkillList.remove(usedSkillList.size()-1);
			newMarkList.remove(newMarkList.size()-1);
		}
		Game.getInstance().getActivePlayer().setNotUsedMark(true);
		Game.getInstance().getActivePlayer().resetUsedSkillList();
		Game.getInstance().getActivePlayer().resetNewMarkList();
	}

	@Override
	public void updateActive() {
		if (Game.getInstance().getActivePlayer().getUsedSkillList().isEmpty()) {
			active = false;
		}
		else active = true;
		
	}

}
package com.tictactower.ui.buttons;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;
import com.tictactower.gameboard.Mark;
import com.tictactower.player.Player;
import com.tictactower.player.Player1;
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
		Game.getInstance().getGameboard().undoGameboard();
		Game.getInstance().getActivePlayer().resetSkillCounts();
		
		Player activePlayer = Game.getInstance().getActivePlayer();
		activePlayer.resetSkillUsage();
		activePlayer.setNotUsedMark(true);
		activePlayer.setCanUndo(false);
		
		if (activePlayer.getHaveUsedSilence()) {
			if (activePlayer instanceof Player1) Game.getInstance().getPlayer2().setSilenced(false);
			else Game.getInstance().getPlayer1().setSilenced(false);		
		}
	}

	@Override
	public void updateActive() {
		if (Game.getInstance().getActivePlayer().getCanUndo()) active = true;
		else active = false;
		
	}

}

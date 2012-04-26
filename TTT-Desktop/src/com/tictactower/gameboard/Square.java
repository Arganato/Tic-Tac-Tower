package com.tictactower.gameboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Square implements Cloneable {

	private Vector2 position;
	private Mark mark;
	public final static int EDGE_LENGTH = (Gdx.graphics.getWidth() - 20) / Gameboard.COLUMNS_AND_ROWS;
	
	public Square(int x, int y, Mark mark) {
		position = new Vector2(Gameboard.X_OFFSET + EDGE_LENGTH * x, Gameboard.Y_OFFSET + EDGE_LENGTH * y);
		this.mark = mark;
	}
	
	public void clear() {
		mark = Mark.EMPTY;
	}
	
	public void setMark(Mark mark) {
		this.mark = mark;
	}
	
	public Mark getMark() {
		return mark;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	
}

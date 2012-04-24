package com.tictactower.ui.text;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

public abstract class TextBox{
	
	public static final BitmapFont font = new BitmapFont();
	
	private Vector2 position;
	protected String text;
	protected int value;
	private float[] colorActive;
	private float[] colorDeactive;
	
	public TextBox(int position_x, int position_y, float[] colorActive, float[] colorDeactive) {
		position = new Vector2(position_x, position_y);
		this.colorActive = colorActive;
		this.colorDeactive = colorDeactive;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public String getText() {
		return text;
	}
	
	public int getValue() {
		return value;
	}
	
	public float[] getColorActive() {
		return colorActive;
	}
	
	public float[] getColorDeactive() {
		return colorDeactive;
	}
	
	public void update() {
		value = fetchValue();
	}
	
	public abstract int fetchValue();
	
}
package com.tictactower.graphics;

import com.badlogic.gdx.graphics.Texture;

/*
 * All the textures are saved in this class. This is a part of using the MVC-pattern. 
 * This makes the View divided from the Model, and changing textures is easily done here.
 */

public class Textures {
	public final static Texture MARK_EMPTY = new Texture("singleGrid.bmp");
	public final static Texture MARK_P1_ACTIVE = new Texture("p1_active.png");
	public final static Texture MARK_P2_ACTIVE = new Texture("p2_active.png");
	public final static Texture MARK_P1_BUILT = new Texture("p1_built.png");
	public final static Texture MARK_P2_BUILT = new Texture("p2_built.png");
	public final static Texture DESTROYED = new Texture("destroyed.png");
	
	public final static Texture VICTORY_SCREEN_PLAYER1 = new Texture("victory_screen_p1.png");
	public final static Texture VICTORY_SCREEN_PLAYER2 = new Texture("victory_screen_p2.png");
	
	public final static Texture BUTTON_QUIT = new Texture("quit.png");
	public final static Texture BUTTON_RESET = new Texture("reset.png");
	
	public final static Texture BUTTON_END_TURN_ACTIVE = new Texture("endturn_active.png");
	public final static Texture BUTTON_END_TURN_DEACTIVE = new Texture("endturn_deactive.png");
	public final static Texture BUTTON_UNDO_ACTIVE = new Texture("undo_active.png");
	public final static Texture BUTTON_UNDO_DEACTIVE = new Texture("undo_deactive.png");
	
	public final static Texture BUTTON_SILENCE_ACTIVE = new Texture("silence_active.png");
	public final static Texture BUTTON_SILENCE_DEACTIVE = new Texture("silence_deactive.png");
	public final static Texture BUTTON_SHOOT_ACTIVE = new Texture("shoot_active.png");
	public final static Texture BUTTON_SHOOT_DEACTIVE = new Texture("shoot_deactive.png");
	public final static Texture BUTTON_BUILD_ACTIVE = new Texture("build_active.png");
	public final static Texture BUTTON_BUILD_DEACTIVE = new Texture("build_deactive.png");
}

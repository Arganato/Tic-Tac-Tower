package com.tictactower.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.tictactower.gameboard.Gameboard;
import com.tictactower.gameboard.Square;

public class Input implements InputProcessor {
	
	public Input() {
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		findWhatSquareWasClicked(x, y);
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	private void findWhatSquareWasClicked(int x, int y) {
		/*
		 *  Her finner man de relative posisjonene til trykket i forhold til spillbrettet.
		 *  Merk at det m� trikses litt med y-posisjonen siden origo p� input er �verst til venstre, 
		 *  mens origo n�r man tegner er nederst til venstre.
		 */
		x -= Gameboard.X_OFFSET;
		y -= Gdx.graphics.getHeight() - (Gameboard.Y_OFFSET + Gameboard.TOTAL_WIDTH - Square.HEIGHT);
		// S� deler man p� bredden/h�yden til ruten for � f� hvilken rad/kolonne trykket kom i.
		x /= Square.WIDTH;
		y /= Square.HEIGHT;
		Gdx.app.log("Y", Integer.toString(y));
		Gdx.app.log("X", Integer.toString(x));
	}
	
}

package com.tictactower.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.tictactower.Game;
import com.tictactower.gameboard.Gameboard;
import com.tictactower.gameboard.Mark;
import com.tictactower.gameboard.Square;
import com.tictactower.ui.Button;
import com.tictactower.ui.Buttons;

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
		// Gj�r om y slik at posisjon 0 er i bunn av skjermen, likt slik det er n�r man tegner teksturer/sprite.
		y = Gdx.graphics.getHeight() - y;
		
		if (wasGameboardClicked(x, y) && Game.getInstance().getActivePlayer().getNotUsedMark()) {
			updateGameboard(x, y);
		}
		else {		
			checkForButtonClicks(x, y);	
		}
		
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
	
	private boolean wasGameboardClicked(int x, int y) {
		if (x > Gameboard.X_OFFSET && x < Gameboard.X_OFFSET + Gameboard.GAMEBOARD_EDGE_LENGTH
				&& y > Gameboard.Y_OFFSET && y < Gameboard.Y_OFFSET + Gameboard.GAMEBOARD_EDGE_LENGTH)
			return true;
		else
			return false;
	}

	private void updateGameboard(int x, int y) {
		/*
		 *  Her finner man de relative posisjonene til trykket i forhold til spillbrettet.
		 *  Merk at det m� trikses litt med y-posisjonen siden origo p� input er �verst til venstre, 
		 *  mens origo n�r man tegner er nederst til venstre.
		 */
		x -= Gameboard.X_OFFSET;
		y -= Gameboard.Y_OFFSET;
		// S� deler man p� bredden/h�yden til ruten for � f� hvilken rad/kolonne trykket kom i.
		x /= Square.EDGE_LENGTH;
		y /= Square.EDGE_LENGTH;
		if (Game.getInstance().getGameboard().getMark(x, y) == Mark.EMPTY) {
			Game.getInstance().getActivePlayer().setMark(x, y, Game.getInstance().getActivePlayer());
			Game.getInstance().getActivePlayer().setNotUsedMark(false);
			Buttons.getButtonEndTurn().setActive(true);
		}
	}
	
	private void checkForButtonClicks(int x, int y) {
		/*
		 * Her itererer man gjennom liste med buttons. 
		 * Hvis klikket/touchen traff en button s� kj�rer mans den execute-metode.
		 */
		for (Button button : Buttons.getButtonList()) {
			if (x > button.getPosition().x && x < button.getPosition().x + button.getWidth()
					&& y > button.getPosition().y && y < button.getPosition().y + button.getHeight()) {
				if (button.isActive()) button.execute();
			}
		}
	}
	
}
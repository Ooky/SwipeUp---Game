package Tools;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import screens.PlayScreen;

public class PlayGestureListener implements MyGestureListener {

	private PlayScreen screen;
	private PositionModifier positionModifier;
	private boolean listening = true;

	public PlayGestureListener(PlayScreen screen) {
		super();
		this.screen = screen;
		positionModifier = new PositionModifier(screen.returnArray());
		positionModifier.setListener(screen);
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {

		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {

		return false;
	}

	@Override
	public boolean longPress(float x, float y) {

		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		if (listening) {
			if (Math.abs(velocityX) > Math.abs(velocityY)) {
				if (velocityX > 0) {
					onRight();
				} else {
					onLeft();
				}
			} else {
				if (velocityY > 0) {
					onDown();
				} else {
					onUp();
				}
			}
			if (positionModifier.getGameWon()) {
				screen.setGameWon();
			}
		}
		return false;

	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {

		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {

		return false;
	}

	@Override
	public boolean zoom(float originalDistance, float currentDistance) {

		return false;
	}

	@Override
	public void pinchStop() {
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	//Swipe directions
	public void onUp() {
		positionModifier.movePlayerUp();
	}

	public void onRight() {
		positionModifier.movePlayerRight();
	}

	public void onLeft() {
		positionModifier.movePlayerLeft();
	}

	public void onDown() {
		positionModifier.movePlayerDown();
	}

	public void setListening(boolean listen) {
		listening = listen;
	}
}

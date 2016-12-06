package Tools;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public interface MyGestureListener extends GestureDetector.GestureListener {
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button);
	@Override
	public boolean tap(float x, float y, int count, int button);

	@Override
	public boolean longPress(float x, float y);

	@Override
	public boolean fling(float velocityX, float velocityY, int button);

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY);

	@Override
	public boolean panStop(float x, float y, int pointer, int button);

	@Override
	public boolean zoom(float originalDistance, float currentDistance);

	@Override
	public void pinchStop();

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2);

	//Swipe directions
	public void onUp();

	public void onRight();

	public void onLeft();

	public void onDown();

	public void setListening(boolean listen);
}

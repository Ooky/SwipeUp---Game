package Tools;

import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

public class PositionModifier implements SwipeListener{

	int[][] returnArray;
	int playerY;
	int playerX;
	int xPos = 0;
	int yPos = 0;
	boolean gameWon = false;
	private PositionModifierListener listener;
	private int[] oldPosition = new int[2];
	private int[] newPosition = new int[2];
	private boolean listening = false;
	
	public PositionModifier(int[][] arr) {
		//Creates a new Swipe detector
//		MyGestureListener gestureListener = new MyGestureListener();
		//Adds a Listener to the detector
//		Main.gestureListener.addSwipeListener(this);
		//sets the detector as inputprocessor so he detects inputs
//		Gdx.input.setInputProcessor(new GestureDetector(gestureListener));
		
		returnArray = arr;
		//Get player Position;
		int y = 0;
		for (int[] iter : returnArray) {
			int x = 0;
			for (int xpos : iter) {
				if (xpos == 3) {
					playerY = x;
					playerX = y;
				}
				x++;
			}
			y++;
		}
	}

	public void movePlayerUp() {
		modifier(playerY, true, 1);
	}

	public void movePlayerDown() {
		modifier(playerY, true, -1);
	}

	public void movePlayerRight() {
		modifier(playerX, false, 1);
	}

	public void movePlayerLeft() {
		modifier(playerX, false, -1);
	}

	private void modifier(int startpos, boolean topDown, int iterateModifier) {
		boolean collided = false;
		oldPosition[0] = playerX;
		oldPosition[1] = playerY;

		returnArray[playerX][playerY] = 0;
		for (int i = startpos; (iterateModifier > 0) ? (i < (topDown ? 26 : 16)) : (i >= 0); i += iterateModifier) {
			if (!collided) {
				switch (topDown ? returnArray[playerX][i] : returnArray[i][playerY]) {
					case 4:
					case 1:
						collided = true;
						break;
					case 2:
						collided = true;
						gameWon = true;
						if (topDown) {
							playerY = i;
						} else {
							playerX = i;
						}
						break;
					default:
						if (topDown) {
							playerY = i;
						} else {
							playerX = i;
						}
						break;
				}
			}
		}
		newPosition[0] = playerX;
		newPosition[1] = playerY;
		listener.positionModifierChange(oldPosition, newPosition, topDown, iterateModifier, gameWon);
		listening = false;
	}

	public void setListener(PositionModifierListener pl) {
		listener = pl;
	}

	@Override
	/**
	 * changes the position of the player, when a swipe is detected
	 * @param direction is Enum, can be UP/DOWN/LEFT/RIGHT
	 */
	public void swipeDetected(direction direction) {
		if (listening) {
			switch(direction){
				case UP:
					movePlayerUp();
					break;
				case DOWN:
					movePlayerDown();
					break;
				case LEFT:
					movePlayerLeft();
					break;
				case RIGHT:
					movePlayerRight();
					break;
				default:
					break;
			}
		}	
	}
	
	public void setListening(boolean l){
		listening = l;
	}
	
	public void setToDefaultSettings(int[][] arr){
		xPos = 0;
		yPos = 0;
		gameWon = false;
		listening = false;
		returnArray = arr;
		//Get player Position;
		int y = 0;
		for (int[] iter : returnArray) {
			int x = 0;
			for (int xpos : iter) {
				if (xpos == 3) {
					playerY = x;
					playerX = y;
				}
				x++;
			}
			y++;
		}
	}
}

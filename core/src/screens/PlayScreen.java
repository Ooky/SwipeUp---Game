package screens;

import Tools.AssetHelper;
import Tools.LevelGenerator;
import Tools.MyGestureListener;
import Tools.PositionModifier;
import Tools.PositionModifierListener;
import Tools.SwipeListener;
import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import sprites.Player;
import com.badlogic.gdx.graphics.g2d.Sprite;
import sprites.Environment;

public class PlayScreen implements Screen, PositionModifierListener, SwipeListener {

	private Main main;
	private TextureRegion regions[] = new TextureRegion[4];
	private Sprite sprites[];
	private AssetHelper assetHelper;

	private Array<TextureRegion> frames;
	private Animation animation;
	//x,y
	private int[][] arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];
	private int screenSizeScaler = 1;
	private int bottomRest = 0;
	private int leftRest = 0;
	private boolean gameWon = false;
	private boolean positionChanged = false;
	private Player player;
	private int[] playerOld = new int[2];
	private int[] playerNew = new int[2];
	private boolean topDown = false;
	private int positiv = 1;
	private MyGestureListener gestureListener;
	private PositionModifier positionModifier;
	private boolean listening = true;
	
	public PlayScreen(Main main, int level) {
		this.main = main;
		assetHelper = main.getAssetHelper();
		screenSizeScaler = Gdx.graphics.getWidth() / 16;
		bottomRest = (Gdx.graphics.getHeight() - (screenSizeScaler * 26)) / 2;
		leftRest = (Gdx.graphics.getWidth() % 16) / 2;

		sprites = new Environment[1];
		regions[0] = assetHelper.getAllTextureRegions()[1][0];
		sprites[0] = new Environment(assetHelper);
		regions[2] = assetHelper.getAllTextureRegions()[1][2];
		regions[3] = assetHelper.getAllTextureRegions()[1][3];

		//generates level
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = LevelGenerator.generateLevel(level);
		gestureListener = new MyGestureListener();
		gestureListener.addSwipeListener(this);
		Gdx.input.setInputProcessor(new GestureDetector(gestureListener));

		player = new Player(main.getAssetHelper());
		playerOld[0] = 0;
		playerOld[1] = 0;
		playerNew[0] = 0;
		playerNew[1] = 0;
		
		positionModifier = new PositionModifier(arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady);
		positionModifier.setListener(this);
	}

	@Override
	public void positionModifierChange(int[] oldP, int[] newP, boolean topDown, int positiv) {
		listening = false;
		positionChanged = true;
		playerOld = oldP;
		playerNew = newP;
		this.topDown = topDown;
		this.positiv = positiv;
	}
	
	@Override
	public void swipeDetected(direction direction) {
		if (listening) {
			switch(direction){
				case UP:
					positionModifier.movePlayerUp();
					break;
				case DOWN:
					positionModifier.movePlayerDown();
					break;
				case LEFT:
					positionModifier.movePlayerLeft();
					break;
				case RIGHT:
					positionModifier.movePlayerRight();
					break;
				default:
					break;
			}
		}
	}

	private void update(float dt) {
		//player.update(dt);
		if (positionModifier.getGameWon() && !positionChanged) {
			main.setScreen(new WinScreen(main));
			this.dispose();
			}
//		if (gameWon && !positionChanged) {
//			main.setScreen(new WinScreen(main));
//			this.dispose();
//		}
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(200f / 255f, 255 / 255f, 120f / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int positionCounterX = leftRest;
		int positionCounterY = bottomRest;
		main.batch.begin();

		//Draw the Player Animation
		if (positionChanged) {
			if (topDown) {
				playerOld[1] += 1 * positiv;
				if ((positiv >= 0 && playerOld[1] > playerNew[1]) || (positiv <= 0 && playerOld[1] < playerNew[1])) {
					listening = true;
					positionChanged = false;
					arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[playerNew[0]][playerNew[1]] = 3;
				}
			} else {
				playerOld[0] += 1 * positiv;
				if ((positiv >= 0 && playerOld[0] > playerNew[0]) || (positiv <= 0 && playerOld[0] < playerNew[0])) {
					listening = true;
					positionChanged = false;
					arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[playerNew[0]][playerNew[1]] = 3;
				}
			}
			main.batch.draw(player.getFrame(delta), leftRest + playerOld[0] * screenSizeScaler, bottomRest + playerOld[1] * screenSizeScaler, screenSizeScaler, screenSizeScaler);
		}
		//Draw the map
		for (int[] arr : arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady) {
			for (int obj : arr) {
				switch (obj) {
					case 0:
						main.batch.draw(regions[0], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 1:
						//((Enviroment)sprites).getFrame() has to be changed later maybe create a new interface
						main.batch.draw(((Environment)sprites[0]).getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 2:
						main.batch.draw(regions[2], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 3:
						if (positionChanged) {
							main.batch.draw(regions[0], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						} else {
							main.batch.draw(player.getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						}
						break;
					default:
						main.batch.draw(regions[0], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
				}
				positionCounterY += screenSizeScaler;
			}
			positionCounterY = bottomRest;
			positionCounterX += screenSizeScaler;
		}
		main.batch.end();
	}

	public void setGameWon() {
		gameWon = true;
	}

	public int[][] returnArray() {
		return arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady;
	}

	@Override
	public void show() {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}
}

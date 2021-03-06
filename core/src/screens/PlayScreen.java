package screens;

import Tools.AssetHelper;
import Tools.LevelGenerator;
import Tools.PlayScreenListener;
import Tools.PositionModifier;
import Tools.PositionModifierListener;
import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import sprites.Player;
import java.util.ArrayList;
import sprites.Environment;
public class PlayScreen implements Screen, PositionModifierListener {

	private Main main;
	private TextureRegion regions[] = new TextureRegion[4];
	private ArrayList<Environment> sprites = new ArrayList<Environment>();
	private AssetHelper assetHelper;
	private boolean gameWon = false;
	
	private int[][] arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];
	private int screenSizeScaler = 1;
	private int bottomRest = 0;
	private int leftRest = 0;
	private boolean positionChanged = false;
	private Player player;	
	private int[] playerOld = new int[2];
	private int[] playerNew = new int[2];
	private boolean topDown = false;
	private int positiv = 1;
	private PositionModifier positionModifier;
	private ArrayList<PlayScreenListener> listeners = new ArrayList<PlayScreenListener>();
	private int currentLevelNumber;
	
	public PlayScreen(Main main, int level) {
		this.main = main;
		assetHelper = main.getAssetHelper();
		addListener(assetHelper);
		//TextureRegion[][] allTextures = assetHelper.getAllTextureRegions();
		screenSizeScaler = Gdx.graphics.getWidth() / 16;
		bottomRest = (Gdx.graphics.getHeight() - (screenSizeScaler * 26)) / 2;
		leftRest = (Gdx.graphics.getWidth() % 16) / 2;

		//Prepares all Sprites and texture regions
		//position 0
		sprites.add(new Environment(assetHelper,0,4,3,150));
		//position 1
		sprites.add(new Environment(assetHelper,0,4,2,150));
		//position 2
		sprites.add(new Environment(assetHelper,0,4,4,150));
		//position 3 Goal
		sprites.add(new Environment(assetHelper,0,4,1,1));	
		//position 4 Blitz
		sprites.add(new Environment(assetHelper,0,4,0,1));
		//regions[0] = allTextures[7][0];
		//regions[1] = allTextures[7][1];
		//regions[2] = allTextures[7][2];
		//regions[3] = allTextures[7][3];

		//generates level
		currentLevelNumber = level;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = LevelGenerator.generateLevel(currentLevelNumber);
		
		//create a new Player and manages his position. Single Responiblity is not strong in this ones
		player = new Player(assetHelper);
		playerOld[0] = 0;
		playerOld[1] = 0;
		playerNew[0] = 0;
		playerNew[1] = 0;
		
		positionModifier = new PositionModifier(arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady);
		positionModifier.setListener(this);
		main.gestureListener.addSwipeListener(positionModifier);
	}

	@Override
	public void positionModifierChange(int[] oldP, int[] newP, boolean topDown, int positiv, boolean gameWon) {
		this.gameWon = gameWon;
		if(oldP[0] != newP[0] || oldP[1] != newP[1]){
			positionChanged = true;
			playerOld = oldP;
			playerNew = newP;
			this.topDown = topDown;
			this.positiv = positiv;
		}
	}
	

	private void update(float dt) {
		if (gameWon && !positionChanged) {
			main.setScreen(new WinScreen(main, this, currentLevelNumber));
			for(PlayScreenListener listener : listeners){
				listener.levelChangeDetected();
			}
			main.gestureListener.removeSwipeListener(positionModifier);
			this.dispose();
		}
	}

	@Override
	public void render(float delta) {
		update(delta);
		//Gdx.gl.glClearColor(0f, 162f/255f, 232f/255f, 1);//0-1, Float.
		Gdx.gl.glClearColor(255f, 255f, 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int positionCounterX = leftRest;
		int positionCounterY = bottomRest;
		main.batch.begin();
		//new background  maybe change the scale later so it doesn't matter which device is used
		//main.batch.draw(assetHelper.getBackgroundAnimation(delta), 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		//Draw the map		
		for (int[] arr : arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady) {
			int backgroundCounter = 0;
			for (int obj : arr) {
				switch (obj) {
					case 0:
						//Background 
						//main.batch.draw(regions[backgroundCounter], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 1:
						//((Enviroment)sprites).getFrame() has to be changed later maybe create a new interface
						//main.batch.draw(sprites.get(0).getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						main.batch.draw(assetHelper.getAllTextureRegions()[0][1], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 2:
						main.batch.draw(sprites.get(3).getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						//main.batch.draw(assetHelper.getAllTextureRegions()[0][1], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 3:
						//main.batch.draw(player.getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						main.batch.draw(assetHelper.getAllTextureRegions()[0][0], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 4:
						//main.batch.draw(sprites.get(1).getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						main.batch.draw(assetHelper.getAllTextureRegions()[0][1], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					case 5:
						//main.batch.draw(sprites.get(2).getFrame(delta), positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						main.batch.draw(assetHelper.getAllTextureRegions()[0][1], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
					default:
						//main.batch.draw(regions[0], positionCounterX, positionCounterY, screenSizeScaler, screenSizeScaler);
						break;
				}
				backgroundCounter=(backgroundCounter>=3?0:backgroundCounter+1);
				positionCounterY += screenSizeScaler;
			}
			positionCounterY = bottomRest;
			positionCounterX += screenSizeScaler;
		}
		//Draw the Player Animation
		if (positionChanged) {			
			//movement y direction
			if (topDown) {
				playerOld[1] += 1 * positiv;
				if ((positiv >= 0 && playerOld[1] >= playerNew[1]) || (positiv <= 0 && playerOld[1] <= playerNew[1])) {
					positionModifier.setListening(true);
					positionChanged = false;
					arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[playerNew[0]][playerNew[1]] = 3;
				}
			} 
			//move x direction
			else {
				playerOld[0] += 1 * positiv;
				if ((positiv >= 0 && playerOld[0] >= playerNew[0]) || (positiv <= 0 && playerOld[0] <= playerNew[0])) {
					positionModifier.setListening(true);
					positionChanged = false;
					arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[playerNew[0]][playerNew[1]] = 3;
				}
			}
			//draws player while he is moving
			main.batch.draw(assetHelper.getAllTextureRegions()[0][0], leftRest + playerOld[0] * screenSizeScaler, bottomRest + playerOld[1] * screenSizeScaler, screenSizeScaler, screenSizeScaler);
		}
		if(!assetHelper.getStartAnimationIsFinished()){
			main.batch.draw(assetHelper.getStartNewPlayScreenAnimationFrame(delta), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}else{
			positionModifier.setListening(true);
		}
		main.batch.end();
	}
	
	//changes the played level and reset the attributs
	public void changeLevel(int level){
		currentLevelNumber = level;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = LevelGenerator.generateLevel(currentLevelNumber);
		playerOld[0] = 0;
		playerOld[1] = 0;
		playerNew[0] = 0;
		playerNew[1] = 0;
		gameWon = false;
		positionChanged = false;
		topDown = false;
		positiv = 1;
		positionModifier.setToDefaultSettings(arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady);
		Main.gestureListener.addSwipeListener(positionModifier);
		for(PlayScreenListener listener : listeners){
			listener.levelChangeDetected();
		}
	}
	
	public void addListener(PlayScreenListener listener){
		listeners.add(listener);
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

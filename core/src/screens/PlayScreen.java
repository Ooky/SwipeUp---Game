package screens;

import Tools.LevelGenerator;
import Tools.MyGestureListener;
import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class PlayScreen implements Screen{

	private Main main;
	private Texture testTextures = new Texture("test.png");
	private TextureRegion regions[] = new TextureRegion[4];
	//x,y
	private int[][] arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = new int[16][26];
	private int screenSizeScaler = 1;
	private int bottomRest = 0;
	private int leftRest = 0;
	private boolean gameWon = false;
	
	/***
	 * 
	 * @param main
	 * @param level tells the level generater which level to pick
	 */
	public PlayScreen(Main main, int level) {
		this.main = main;
		screenSizeScaler = Gdx.graphics.getWidth() / 16;
		bottomRest = (Gdx.graphics.getHeight() - (screenSizeScaler * 26)) / 2;
		leftRest = (Gdx.graphics.getWidth()%16)/2;
		
		regions[0] = new TextureRegion(testTextures, 0, 0, 64, 64);
		regions[1] = new TextureRegion(testTextures, 64, 0, 64, 64);
		regions[2] = new TextureRegion(testTextures, 128, 0, 64, 64);
		regions[3] = new TextureRegion(testTextures, 192, 0, 64, 64);
		
		//generates level
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady = LevelGenerator.generateLevel(level);
		
		Gdx.input.setInputProcessor(new GestureDetector(new MyGestureListener(this)));
	}

	private void update(float dt) {
		if(gameWon){
			main.setScreen(new WinScreen(main));
			this.dispose();
		}
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(200f / 255f, 255 / 255f, 120f / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int positionCounterX = leftRest;
		int positionCounterY = bottomRest;
		main.batch.begin();
		for (int[] arr : arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady) {
			for (int obj : arr) {
				switch (obj) {
					case 0:
						main.batch.draw(regions[0], positionCounterX, positionCounterY,screenSizeScaler,screenSizeScaler);
						break;
					case 1:
						main.batch.draw(regions[1], positionCounterX, positionCounterY,screenSizeScaler,screenSizeScaler);
						break;
					case 2:
						main.batch.draw(regions[2], positionCounterX, positionCounterY,screenSizeScaler,screenSizeScaler);
						break;
					case 3:
						main.batch.draw(regions[3], positionCounterX, positionCounterY,screenSizeScaler,screenSizeScaler);
						break;
					default:
						main.batch.draw(regions[0], positionCounterX, positionCounterY,screenSizeScaler,screenSizeScaler);
						break;
				}
				positionCounterY += screenSizeScaler;
			}
			positionCounterY = bottomRest;
			positionCounterX += screenSizeScaler;
		}

		main.batch.end();
	}
	
	public void setGameWon(){
		gameWon = true;
	}
	
	public int[][] returnArray(){
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
		testTextures.dispose();
	}
}

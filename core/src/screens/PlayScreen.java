package screens;

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

	public PlayScreen(Main main) {
		this.main = main;
		screenSizeScaler = Gdx.graphics.getWidth() / 16;
		bottomRest = (Gdx.graphics.getHeight() - (screenSizeScaler * 26)) / 2;
		leftRest = (Gdx.graphics.getWidth()%16)/2;
		
		regions[0] = new TextureRegion(testTextures, 0, 0, 64, 64);
		regions[1] = new TextureRegion(testTextures, 64, 0, 64, 64);
		regions[2] = new TextureRegion(testTextures, 128, 0, 64, 64);
		regions[3] = new TextureRegion(testTextures, 192, 0, 64, 64);
		//Scale/*
		/*regions[3].setRegionWidth(screenSizeScaler);
		regions[3].setRegionHeight(screenSizeScaler);
		regions[0].setRegionWidth(screenSizeScaler);
		regions[0].setRegionHeight(screenSizeScaler);
		regions[1].setRegionWidth(screenSizeScaler);
		regions[1].setRegionHeight(screenSizeScaler);
		regions[2].setRegionWidth(screenSizeScaler);
		regions[2].setRegionHeight(screenSizeScaler);*/		
		//SETUP

		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][5] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][5] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][22] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[14][20] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][6] = 3;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[0][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[2][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[3][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[4][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[8][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[9][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][0] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[3][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[4][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[5][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[6][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[8][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[9][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][24] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][24] = 1;
				arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[10][15] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[11][15] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[12][15] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[13][15] = 1;
					arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][25] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][1] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][2] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][3] = 1;
						arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[15][1] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][1] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][2] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[1][3] = 1;
		arrayToTestOnlyWillBeReplacedWhenTheEditorIsReady[7][7] = 2;
		Gdx.input.setInputProcessor(new GestureDetector(new MyGestureListener(this)));
	}

	private void update(float dt) {
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
	}
}

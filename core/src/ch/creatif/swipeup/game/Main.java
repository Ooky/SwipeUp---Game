package ch.creatif.swipeup.game;

import Tools.AssetHelper;
import Tools.MyGestureListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import screens.StartGame;

public class Main extends Game {

	public SpriteBatch batch;
	public AssetHelper assetHelper;
	public static final MyGestureListener gestureListener = new MyGestureListener();
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		assetHelper = new AssetHelper();
		setScreen(new StartGame(this));
		Gdx.input.setInputProcessor(new GestureDetector(gestureListener));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public AssetHelper getAssetHelper(){
		return assetHelper;
	}
}

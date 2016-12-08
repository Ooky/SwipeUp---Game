package ch.creatif.swipeup.game;

import Tools.AssetHelper;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.StartGame;

public class Main extends Game {

	public SpriteBatch batch;
	public AssetHelper assetHelper;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		assetHelper = new AssetHelper();
		setScreen(new StartGame(this));
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

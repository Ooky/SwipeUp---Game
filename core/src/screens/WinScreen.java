package screens;

import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class WinScreen implements Screen {

	private Main main;
	private PlayScreen playScreen;
	private BitmapFont font;	
	private int level;
	
	public WinScreen(Main main, PlayScreen playScreen, int level) {
		this.main = main;
		this.playScreen = playScreen;
		this.level = level;
		this.level = level;
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = Gdx.graphics.getWidth()/18;
		font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	}

	private void update(float dt) {

	}

	private void handleInput() {
		if (Gdx.input.isTouched()) {
			playScreen.changeLevel(2);
			main.setScreen(playScreen);
		}
	}

	@Override
	public void render(float delta) {
		handleInput();
		update(delta);
		Gdx.gl.glClearColor(0f, 162f/255f, 232f/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		main.batch.begin();
		font.draw(main.batch, "Congratulation", Gdx.graphics.getWidth()/8, Gdx.graphics.getHeight()/1.2f);
		font.draw(main.batch, "Level "+level, Gdx.graphics.getWidth()/8, Gdx.graphics.getHeight()/1.2f - font.getData().capHeight - 50);
		main.batch.end();
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

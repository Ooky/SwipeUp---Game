package screens;

import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class StartGame implements Screen {

	private Main main;

	public StartGame(Main main) {
		this.main = main;
	}

	private void update(float dt) {

	}

	private void handleInput() {
		if (Gdx.input.isTouched()) {
			main.setScreen(new PlayScreen(main));
		}
	}

	@Override
	public void render(float delta) {
		handleInput();
		update(delta);
		Gdx.gl.glClearColor(0 / 255f, 0 / 255f, 255f / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        game.getBatch().begin();
//        game.getBatch().end();
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

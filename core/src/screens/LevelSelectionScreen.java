/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 *
 * @author mike
 */
public class LevelSelectionScreen implements Screen {
	
	private Main main;

	public LevelSelectionScreen(Main main) {
		this.main = main;
	}

	private void update(float dt) {

	}

	private void handleInput() {
		if (Gdx.input.isTouched()) {
			main.setScreen(new PlayScreen(main, 2));
		}
	}

	@Override
	public void render(float delta) {
		handleInput();
		update(delta);
		Gdx.gl.glClearColor(50 / 255f, 100 / 255f, 50f / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

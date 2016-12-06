package screens;

import ch.creatif.swipeup.game.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import sprites.Player;

public class StartGame implements Screen {

	private Main main;
	private Stage stage;
	private Skin skin = new Skin();
	private Player player;
	private int width;
	private int height;

	public StartGame(Main main) {
		this.main = main;
		stage = new Stage();
		player = new Player();
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();

		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.BLACK.GREEN);
		pixmap.fill();

		skin.add("white", new Texture(pixmap));
		// Store the default libgdx font under the name "default".
		BitmapFont bfont = new BitmapFont();
		skin.add("default", bfont);
		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);

		textButtonStyle.font = skin.getFont("default");

		skin.add("default", textButtonStyle);

		// Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
		TextButton textButton1 = new TextButton("PLAY", textButtonStyle);
		textButton1.setPosition(width / 2 - width / 12, height - height / 8 - height / 10);
		textButton1.setWidth(width / 6);
		textButton1.setHeight(height / 10);
		TextButton textButton2 = new TextButton("Level", textButtonStyle);
		textButton2.setPosition(width / 10, height / 2 - height / 20);
		textButton2.setWidth(width / 6);
		textButton2.setHeight(height / 10);
		TextButton textButton3 = new TextButton("Options", textButtonStyle);
		textButton3.setPosition(width - width / 10 - width / 6, height / 2 - height / 20);
		textButton3.setWidth(width / 6);
		textButton3.setHeight(height / 10);
		TextButton textButton4 = new TextButton("Exit", textButtonStyle);
		textButton4.setPosition(width / 2 - width / 12, height / 8);
		textButton4.setWidth(width / 6);
		textButton4.setHeight(height / 10);
		stage.addActor(textButton1);
		stage.addActor(textButton2);
		stage.addActor(textButton3);
		stage.addActor(textButton4);

		Gdx.input.setInputProcessor(stage);
	}

	private void update(float dt) {

	}

	private void handleInput() {
		if (Gdx.input.isTouched()) {
			main.setScreen(new PlayScreen(main, 1));
		}
	}

	@Override
	public void render(float delta) {
		handleInput();
		update(delta);
		Gdx.gl.glClearColor(0 / 255f, 0 / 255f, 255f / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		main.batch.begin();
		main.batch.draw(player.getFrame(delta), width / 2 - width / 32, height / 2 - width / 32, width / 16, width / 16);
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
		stage.dispose();
		skin.dispose();
	}
}

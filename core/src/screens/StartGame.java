package screens;

import Tools.PositionModifier;
import Tools.PositionModifierListener;
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
import com.badlogic.gdx.utils.Timer;
import sprites.Player;

public class StartGame implements Screen, PositionModifierListener {

	private Main main;
	private Stage stage;
	private Skin skin = new Skin();
	private Player player;
	private int width;
	private int height;
	private PositionModifier positionModifier;
	private boolean positionChanged = false;
	private int[] playerOld = new int[2];
	private int[] playerNew = new int[2];
	private boolean topDown = false;
	private int positiv = 1;
	private int screenSizeScaler = 1;
	private int bottomRest = 0;
	private int leftRest = 0;
	private int[][] map = new int[16][26];
	private boolean startGame = false;
	
	public StartGame(Main main) {
		this.main = main;
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
		stage = new Stage();
		player = new Player(main.getAssetHelper());
		playerOld[0] = 8;
		playerOld[1] = 12;
		playerNew[0] = 0;
		playerNew[1] = 0;
		screenSizeScaler = Gdx.graphics.getWidth() / 16;
		bottomRest = (Gdx.graphics.getHeight() - (screenSizeScaler * 26)) / 2;
		leftRest = (Gdx.graphics.getWidth() % 16) / 2;
		

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

		map[8][12] = 3;
		map[8][22] = 1;
		map[8][3] = 1;
		map[2][12] = 1;
		map[14][12] = 1;
		
		positionModifier = new PositionModifier(map);
		positionModifier.setListener(this);
		positionModifier.setListening(true);
		Main.gestureListener.addSwipeListener(positionModifier);
	}

	private void update(float dt) {
		//starts the game when the position change of the player is finished
		if(startGame && !positionChanged){
			//waits 1 second(libgdx stuff) befor switching screen. Should be replaced by a fancy animation
			Timer.schedule(new Timer.Task(){
				@Override
				public void run() {		
					//swipe top
					if(playerNew[0] == playerOld[0] && playerNew[1] > 12){
						main.setScreen(new PlayScreen(main, 1));
					}
					//swipe down
					else if(playerNew[0] == playerOld[0] && playerNew[1] < 12){
						Gdx.app.exit();
					}
					//swipe left
					else if(playerNew[1] == playerOld[1] && playerNew[0] < 8){
						main.setScreen(new LevelSelectionScreen(main));
					}
					//swipe right
					else if(playerNew[1] == playerOld[1] && playerNew[0] > 8){
						main.setScreen(new OptionsScreen(main));
					}
					Main.gestureListener.removeSwipeListener(positionModifier);
					dispose();
				}
			}, 1);
		}
	}


	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0 / 255f, 0 / 255f, 255f / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		main.batch.begin();
		
		//Draw the Player Animation
		if (positionChanged) {
			if (topDown) {
				playerOld[1] += 1 * positiv;
				if ((positiv >= 0 && playerOld[1] > playerNew[1]) || (positiv <= 0 && playerOld[1] < playerNew[1])) {
					positionChanged = false;
					map[playerNew[0]][playerNew[1]] = 3;
				}
			} else {
				playerOld[0] += 1 * positiv;
				if ((positiv >= 0 && playerOld[0] > playerNew[0]) || (positiv <= 0 && playerOld[0] < playerNew[0])) {
					positionChanged = false;
					map[playerNew[0]][playerNew[1]] = 3;
				}
			}
			main.batch.draw(player.getFrame(delta), leftRest + playerOld[0] * screenSizeScaler - width/32, bottomRest + playerOld[1] * screenSizeScaler, screenSizeScaler, screenSizeScaler);
		}else{
			//Draw the player before and after the swipe
			main.batch.draw(player.getFrame(delta), leftRest + playerOld[0] * screenSizeScaler - width/32, bottomRest + playerOld[1] * screenSizeScaler, screenSizeScaler, screenSizeScaler);
		}
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

	@Override
	public void positionModifierChange(int[] oldP, int[] newP, boolean topDown, int positiv, boolean gameWon) {
		startGame = true;
		positionChanged = true;
		playerOld = oldP;
		playerNew = newP;
		this.topDown = topDown;
		this.positiv = positiv;
	}
}

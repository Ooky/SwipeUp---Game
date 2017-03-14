package Tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.REVERSED;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AssetHelper implements PlayScreenListener{

	private final Texture texture = new Texture("textureConcept3.png");
	public final int numberOfColumnTiles = 4;
	public final int numberOfRowTiles = 8;
	
	
	private Animation startNewPlayScreenAnimation;
	private Animation endNewPlayScreenAnimation;
	private Animation backgroundAnimation;
	private float backgroundAnimationTimer = 0;
	private float stateTimerstartNewPlayScreenAnimation = 0;
	private float endTimerstartNewPlayScreenAnimation = 0;
	private Texture background = new Texture("starBackground.png");	//Stars in the background
	private Texture startScreenBackground = new Texture("startBackground.png");	//Menu Selection
	
//	private static AssetHelper instance = null;

	private boolean startAnimationIsFinished = false;
	
	private TextureRegion[][] allTextureRegions = new TextureRegion[numberOfRowTiles][numberOfColumnTiles];

	public AssetHelper() {
		for (int i = 0; i < numberOfRowTiles; i++) {
			for (int j = 0; j < numberOfColumnTiles; j++) {
				allTextureRegions[i][j] = new TextureRegion(texture, j * 64, i * 64, 64, 64);
			}
		}
		
		Texture startAnimation = new Texture("LevelStartAnimation.png");
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int i = 0; i < 12; i++) {
			frames.add(new TextureRegion(startAnimation,  i * 320, 0, 320,480 ));
		}
		startNewPlayScreenAnimation = new Animation(.02f, frames, LOOP);
		endNewPlayScreenAnimation = new Animation(1f, frames, REVERSED);
		frames.clear();
		
		Texture backgroundTexture = new Texture("backgroundAnimation.png");
		for (int i = 0; i < 4; i++) {
			frames.add(new TextureRegion(backgroundTexture,  i * 320, 0, 320,480 ));
		}
		backgroundAnimation = new Animation(5f, frames, LOOP);
		frames.clear();
	}
//
//	public static AssetHelper getAssetHelper() {
//			instance = new AssetHelper();
//		return instance;
//	}

	public TextureRegion[][] getAllTextureRegions() {
		return allTextureRegions;
	}
	
	public Texture getBackground(){
		return background;
	}
	public Texture getStartMenue(){
		return startScreenBackground;
	}
	public TextureRegion getBackgroundAnimation(float dt){
		backgroundAnimationTimer += dt;
		return backgroundAnimation.getKeyFrame(backgroundAnimationTimer, true);
	}
			
	public TextureRegion getStartNewPlayScreenAnimationFrame(float dt) {		
			stateTimerstartNewPlayScreenAnimation += dt;
			if(startNewPlayScreenAnimation.getKeyFrameIndex(stateTimerstartNewPlayScreenAnimation) >= 11){
				startAnimationIsFinished = true;
			}
			return startNewPlayScreenAnimation.getKeyFrame(stateTimerstartNewPlayScreenAnimation, true);
	}
	
	public TextureRegion getEndNewPlayScreenAnimationFrame(float dt) {
//		if(!endNewPlayScreenAnimation.isAnimationFinished(endTimerstartNewPlayScreenAnimation)){
			endTimerstartNewPlayScreenAnimation += dt;
			return endNewPlayScreenAnimation.getKeyFrame(endTimerstartNewPlayScreenAnimation, false);
//		}else{
//			return endNewPlayScreenAnimation.getKeyFrame(stateTimerstartNewPlayScreenAnimation, true);
//		}
	}
	
	public boolean getStartAnimationIsFinished(){
		return startAnimationIsFinished;
	}
	
	@Override
	public void levelChangeDetected(){
		endTimerstartNewPlayScreenAnimation = 0;
		startAnimationIsFinished = false;
		stateTimerstartNewPlayScreenAnimation = 0;
	}
}

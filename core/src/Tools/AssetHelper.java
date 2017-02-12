package Tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.REVERSED;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AssetHelper implements PlayScreenListener{

	private final Texture texture = new Texture("TextureConcept2.png");
	public final int numberOfColumnTiles = 4;
	public final int numberOfRowTiles = 8;
	
	
	private Animation startNewPlayScreenAnimation;
	private Animation endNewPlayScreenAnimation;
	private float stateTimerstartNewPlayScreenAnimation = 0;
	private float endTimerstartNewPlayScreenAnimation = 0;
//	private static AssetHelper instance = null;

	private boolean startAnimationIsFinished = false;
	
	private TextureRegion[][] allTextureRegions = new TextureRegion[numberOfRowTiles][numberOfColumnTiles];

	public AssetHelper() {
		for (int i = 0; i < numberOfRowTiles; i++) {
			for (int j = 0; j < numberOfColumnTiles; j++) {
				allTextureRegions[i][j] = new TextureRegion(texture, j * 64, i * 64, 64, 64);
			}
		}
		
		Array<TextureRegion> frames = new Array<TextureRegion>();
		for (int i = 0; i < 6; i++) {
			frames.add(new TextureRegion(new Texture("LevelStartAnimation.png"),  i * 640, 0, 640,960 ));
		}
		startNewPlayScreenAnimation = new Animation(.5f, frames, LOOP);
		endNewPlayScreenAnimation = new Animation(1f, frames, REVERSED);
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

	public TextureRegion getStartNewPlayScreenAnimationFrame(float dt) {		
			stateTimerstartNewPlayScreenAnimation += dt;
			if(startNewPlayScreenAnimation.getKeyFrameIndex(stateTimerstartNewPlayScreenAnimation) >= 5){
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

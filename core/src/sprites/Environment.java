package sprites;

import Tools.AssetHelper;
import com.badlogic.gdx.graphics.g2d.Animation;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Environment extends Sprite {

	private Animation actualAnimation;;
	private TextureRegion[] animationRegions;
	private Array<TextureRegion> frames;
	private float stateTimer = 0;

	public Environment(AssetHelper assetHelper) {
		//Animation
		animationRegions = new TextureRegion[4];
		for (int i = 0; i <= 3; i++) {
			animationRegions[i] = new TextureRegion(assetHelper.getAllTextureRegions()[3][i]);
		}
		frames = new Array<TextureRegion>();
		for (int i = 0; i < animationRegions.length; i++) {
			frames.add(animationRegions[i]);
		}
		actualAnimation = new Animation(0.5f*30, frames, LOOP);
		frames.clear();
	}

	public TextureRegion getFrame(float dt) {
		stateTimer += dt;
		return actualAnimation.getKeyFrame(stateTimer, true);

	}

	public void update(float dt) {
	}
}

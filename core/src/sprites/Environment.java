package sprites;

import Tools.AssetHelper;
import com.badlogic.gdx.graphics.g2d.Animation;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Environment extends Sprite {

	private Animation actualAnimation;
	private TextureRegion[] animationRegions;
	private Array<TextureRegion> frames;
	private float stateTimer = 0;

	public Environment(AssetHelper assetHelper, int startPos, int endPos, int row, int animationSlowDown) {
		int animationLength = endPos - startPos;
		//Animation
		animationRegions = new TextureRegion[4];
		for (int i = startPos; i < animationLength; i++) {
			animationRegions[i] = new TextureRegion(assetHelper.getAllTextureRegions()[row][i]);
		}
		frames = new Array<TextureRegion>();
		for (int i = 0; i < animationRegions.length; i++) {
			frames.add(animationRegions[i]);
		}
		actualAnimation = new Animation(0.1f*animationSlowDown, frames, LOOP);
		frames.clear();
	}

	public TextureRegion getFrame(float dt) {
		stateTimer += dt;
		return actualAnimation.getKeyFrame(stateTimer, true);

	}

	public void update(float dt) {
	}
}

package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Player extends Sprite{
	private Animation playerAnimation;
	private Texture animationtexture = new Texture("animation.png");
	private TextureRegion[] animationRegions;
	private Array<TextureRegion> frames;
	private float stateTimer = 0;
	
	public Player(){
		//Animation
		animationRegions = new TextureRegion[4];
		int  j = 0;
		for (int i = 0; i <= 64*3; i += 64) {
			animationRegions[j] = new TextureRegion(animationtexture, i,0, 64, 64);
			j++;
		}
		frames = new Array<TextureRegion>();
		for (int i = 0; i < animationRegions.length; i++) {
			frames.add(animationRegions[i]);
		}
		playerAnimation = new Animation(0.5f, frames, LOOP);
		frames.clear();
	}
	
	public TextureRegion getFrame(float dt){
		stateTimer += dt;
		return	playerAnimation.getKeyFrame(stateTimer, true);
		
	}
	
	public void update(float dt){
		//setPosition(1, 1);
		//setRegion(getFrame(dt));
	}
}

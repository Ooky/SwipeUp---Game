package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Player extends Sprite{
	private Animation actualAnimation;
	private Animation playerAnimation;
	private Animation movementAnimation;
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
		movementAnimation = new Animation(1f, frames, LOOP);
		actualAnimation = playerAnimation;
		frames.clear();
	}
	
	public TextureRegion getFrame(float dt){
		stateTimer += dt;
		return	actualAnimation.getKeyFrame(stateTimer, true);
		
	}
	
	public void update(float dt){
		//setPosition(1, 1);
		//setRegion(getFrame(dt));
	}
	
	public void setAnimation(int ani){
		switch(ani){
			case 0:
				actualAnimation = playerAnimation;
				break;
			case 1:
				actualAnimation = movementAnimation;
				break;
			case 2:
				actualAnimation = playerAnimation;
				break;
			default:
				actualAnimation = playerAnimation;
				break;
		}
	}
}

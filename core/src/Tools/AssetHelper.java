package Tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetHelper {

	private final Texture texture = new Texture("all.png");
	public final int numberOfColumnTiles = 4;
	public final int numberOfRowTiles = 2;
	private static AssetHelper instance = null;

	private TextureRegion[][] allTextureRegions = new TextureRegion[2][4];

	private AssetHelper() {
		for (int i = 0; i < numberOfRowTiles; i++) {
			for (int j = 0; j < numberOfColumnTiles; j++) {
				allTextureRegions[i][j] = new TextureRegion(texture, j * 64, i * 64, 64, 64);
			}
		}
	}

	public static AssetHelper getAssetHelper() {
		if (instance == null) {
			instance = new AssetHelper();
		}
		return instance;
	}

	public TextureRegion[][] getAllTextureRegions() {
		return allTextureRegions;
	}

}

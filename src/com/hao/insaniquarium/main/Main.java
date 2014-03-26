package com.hao.insaniquarium.main;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.graphics.Point;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

/**
 * (c) 2010 Nicolas Gramlich (c) 2011 Zynga
 * 
 * @author Nicolas Gramlich
 * @since 12:14:22 - 30.06.2010
 */
public class Main extends SimpleBaseGameActivity {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 320;

	// ===========================================================
	// Fields
	// ===========================================================

	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion mFaceTextureRegion;

	private boolean mToggleBox = true;
	private AnimatedSprite animatedSprite;
	private TiledTextureRegion mFaceTextureRegion1;
	private AnimatedSprite animatedSprite1;
	private Scene scene;
	private AnimatedSprite animatedSprite2;
	private TiledTextureRegion mFaceTextureRegion2;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public EngineOptions onCreateEngineOptions() {
		Toast.makeText(this, "Touch the screen to update (redraw) an existing BitmapTextureAtlas with every touch!", Toast.LENGTH_LONG)
				.show();
		final Display display = getWindowManager().getDefaultDisplay();
		Point screenSize = new Point();
		display.getSize(screenSize);
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(screenSize.x, screenSize.y), camera);
	}

	@Override
	public void onCreateResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

		this.mBitmapTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		this.mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this,
				"face_box_tiled.png", 0, 0, 2, 1);
		this.mFaceTextureRegion1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this,
				"banana_tiled.png", 0, 100, 4, 2);
		this.mFaceTextureRegion2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this,
				"snapdragon_tiled.png", 0, 200, 4, 3);
		this.mBitmapTextureAtlas.load();
	}

	@Override
	public Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		scene = new Scene();
		scene.getBackground().setColor(0.09804f, 0.6274f, 0.8784f);

		final float centerX = CAMERA_WIDTH / 2;
		final float centerY = CAMERA_HEIGHT / 2;

		/* Create the animated sprite and add it to the scene. */
		animatedSprite = new AnimatedSprite(centerX, centerY, this.mFaceTextureRegion, this.getVertexBufferObjectManager());
		animatedSprite1 = new AnimatedSprite(centerX, centerY, this.mFaceTextureRegion1, this.getVertexBufferObjectManager());
		animatedSprite2 = new AnimatedSprite(centerX, centerY, this.mFaceTextureRegion2, this.getVertexBufferObjectManager());

		animatedSprite2.animate(100);

		animatedSprite2.setPosition(100, 50);
		animatedSprite.animate(new long[] { 100, 100 }, 0, 1, true);
		animatedSprite1.animate(100);
		scene.attachChild(animatedSprite);
		scene.attachChild(animatedSprite2);
		scene.setOnSceneTouchListener(new IOnSceneTouchListener() {
			@Override
			public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent pSceneTouchEvent) {
				if (pSceneTouchEvent.isActionDown()) {
					animatedSprite2.setPosition(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
					Main.this.toggle();
				}
				return true;
			}
		});

		return scene;
	}

	private void toggle() {
		boolean col = false;
		this.mToggleBox = !this.mToggleBox;
		if (mToggleBox) {
			animatedSprite2.setTiledTextureRegion(mFaceTextureRegion2);
			animatedSprite2.animate(100);
			col = animatedSprite.collidesWith(animatedSprite2);
		} else {
			animatedSprite2.setTiledTextureRegion(mFaceTextureRegion1);
			animatedSprite2.animate(100);
			col = animatedSprite1.collidesWith(animatedSprite2);
		}
		if (col) {
			Log.e("hao", "cham roi ne " + SystemClock.elapsedRealtime());
		}
	}

}

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

import com.hao.insaniquarium.factory.ResourceFishFactory;
import com.makersf.andengine.extension.collisions.entity.sprite.PixelPerfectAnimatedSprite;
import com.makersf.andengine.extension.collisions.opengl.texture.region.PixelPerfectTextureRegionFactory;
import com.makersf.andengine.extension.collisions.opengl.texture.region.PixelPerfectTiledTextureRegion;

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

	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 320;


	private Scene scene;
	private ResourceFishFactory rsFac;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		final Display display = getWindowManager().getDefaultDisplay();
		Point screenSize = new Point();
		display.getSize(screenSize);
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(screenSize.x, screenSize.y), camera);
	}

	@Override
	public void onCreateResources() {
		rsFac = new ResourceFishFactory(this);
		rsFac.guppy();
	}

	@Override
	public Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());


		scene = new Scene();
		scene.getBackground().setColor(0.09804f, 0.6274f, 0.8784f);
		
		AnimatedSprite ani1 = new AnimatedSprite(50, 100,rsFac.getTiledTextureRegion(ResourceFishFactory.FISH_GUPPY_SMALL_DIE) , this.getVertexBufferObjectManager());
		ani1.animate(100);
		
		AnimatedSprite ani2 = new AnimatedSprite(100, 100,rsFac.getTiledTextureRegion(ResourceFishFactory.FISH_GUPPY_SMALL_EAT) , this.getVertexBufferObjectManager());
		ani2.animate(100);
		
		scene.attachChild(ani1);
		scene.attachChild(ani2);
		return scene;
	}

}

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
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.graphics.Point;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;

import com.hao.insaniquarium.factory.FishID;
import com.hao.insaniquarium.factory.ResourceFactory;

/**
 * (c) 2010 Nicolas Gramlich (c) 2011 Zynga
 * 
 * @author Nicolas Gramlich
 * @since 12:14:22 - 30.06.2010
 */
public class Main extends SimpleBaseGameActivity implements IOnSceneTouchListener{

	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 320;


	private Scene scene;
	private ResourceFactory rsFac;
	private AnimatedSprite smallGuppyDie;
	private AnimatedSprite smallGuppyEat;
	private AnimatedSprite smallGuppyHungryEat;
	private AnimatedSprite smallGuppyHungryTurn;
	private AnimatedSprite smallGuppySwim;
	private AnimatedSprite smallGuppyTurn;
	private AnimatedSprite mediumGuppyDie;
	private AnimatedSprite mediumGuppyEat;
	private AnimatedSprite mediumGuppyHungryEat;
	private AnimatedSprite mediumGuppyHungryTurn;
	private AnimatedSprite mediumGuppySwim;
	private AnimatedSprite mediumGuppyTurn;
	private AnimatedSprite bigGuppyDie;
	private AnimatedSprite bigGuppyEat;
	private AnimatedSprite bigGuppyHungryEat;
	private AnimatedSprite bigGuppyHungryTurn;
	private AnimatedSprite bigGuppySwim;
	private AnimatedSprite bigGuppyTurn;
	private AnimatedSprite kingGuppyDie;
	private AnimatedSprite kingGuppyEat;
	private AnimatedSprite kingGuppyHungryEat;
	private AnimatedSprite kingGuppyHungryTurn;
	private AnimatedSprite kingGuppySwim;
	private AnimatedSprite kingGuppyTurn;
	
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
		rsFac = new ResourceFactory(this);
		rsFac.loadGuppy();
	}

	@Override
	public Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());


		scene = new Scene();
		scene.getBackground().setColor(0.09804f, 0.6274f, 0.8784f);
		
		// draw small guppy 
		smallGuppy();
		
		// draw medium guppy
		mediumGuppy();
		
		// draw big guppy
		bigGuppy();
		
		// draw king guppy
		kingGuppy();
		
		scene.setOnSceneTouchListener(this);
		return scene;
	}

	private void kingGuppy() {
		kingGuppyDie = new AnimatedSprite(40, 250,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_KING_DIE) , this.getVertexBufferObjectManager());
		kingGuppyDie.animate(80);
		
		kingGuppyEat = new AnimatedSprite(120, 250,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_KING_EAT) , this.getVertexBufferObjectManager());
		kingGuppyEat.animate(80);
		
		kingGuppyHungryEat = new AnimatedSprite(200, 250,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_KING_HUNGRY_EAT) , this.getVertexBufferObjectManager());
		kingGuppyHungryEat.animate(80);
		
		kingGuppyHungryTurn = new AnimatedSprite(280, 250,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_KING_HUNGRY_TURN) , this.getVertexBufferObjectManager());
		kingGuppyHungryTurn.animate(80);
		
		kingGuppySwim = new AnimatedSprite(360, 250,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_KING_SWIM) , this.getVertexBufferObjectManager());
		kingGuppySwim.animate(80);
		
		kingGuppyTurn = new AnimatedSprite(440, 250,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_KING_TURN) , this.getVertexBufferObjectManager());
		kingGuppyTurn.animate(80);
		
		scene.attachChild(kingGuppyDie);
		scene.attachChild(kingGuppyEat);
		scene.attachChild(kingGuppyHungryEat);
		scene.attachChild(kingGuppyHungryTurn);
		scene.attachChild(kingGuppySwim);
		scene.attachChild(kingGuppyTurn);
	}

	private void bigGuppy() {
		bigGuppyDie = new AnimatedSprite(40, 175,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_BIG_DIE) , this.getVertexBufferObjectManager());
		bigGuppyDie.animate(80);
		
		bigGuppyEat = new AnimatedSprite(120, 175,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_BIG_EAT) , this.getVertexBufferObjectManager());
		bigGuppyEat.animate(80);
		
		bigGuppyHungryEat = new AnimatedSprite(200, 175,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_BIG_HUNGRY_EAT) , this.getVertexBufferObjectManager());
		bigGuppyHungryEat.animate(80);
		
		bigGuppyHungryTurn = new AnimatedSprite(280, 175,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_BIG_HUNGRY_TURN) , this.getVertexBufferObjectManager());
		bigGuppyHungryTurn.animate(80);
		
		bigGuppySwim = new AnimatedSprite(360, 175,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_BIG_SWIM) , this.getVertexBufferObjectManager());
		bigGuppySwim.animate(80);
		
		bigGuppyTurn = new AnimatedSprite(430, 175,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_BIG_TURN) , this.getVertexBufferObjectManager());
		bigGuppyTurn.animate(80);
		
		scene.attachChild(bigGuppyDie);
		scene.attachChild(bigGuppyEat);
		scene.attachChild(bigGuppyHungryEat);
		scene.attachChild(bigGuppyHungryTurn);
		scene.attachChild(bigGuppySwim);
		scene.attachChild(bigGuppyTurn);
	}
	
	private void mediumGuppy() {
		mediumGuppyDie = new AnimatedSprite(50, 100,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_MEDIUM_DIE) , this.getVertexBufferObjectManager());
		mediumGuppyDie.animate(80);
		
		mediumGuppyEat= new AnimatedSprite(120, 100,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_MEDIUM_EAT) , this.getVertexBufferObjectManager());
		mediumGuppyEat.animate(80);
		
		mediumGuppyHungryEat= new AnimatedSprite(190, 100,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_MEDIUM_HUNGRY_EAT) , this.getVertexBufferObjectManager());
		mediumGuppyHungryEat.animate(80);
		
		mediumGuppyHungryTurn= new AnimatedSprite(260, 100,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_MEDIUM_HUNGRY_TURN) , this.getVertexBufferObjectManager());
		mediumGuppyHungryTurn.animate(80);
		
		mediumGuppySwim= new AnimatedSprite(330, 100,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_MEDIUM_SWIM) , this.getVertexBufferObjectManager());
		mediumGuppySwim.animate(80);
		
		mediumGuppyTurn= new AnimatedSprite(400, 100,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_MEDIUM_TURN) , this.getVertexBufferObjectManager());
		mediumGuppyTurn.animate(80);
		
		scene.attachChild(mediumGuppyDie);
		scene.attachChild(mediumGuppyEat);
		scene.attachChild(mediumGuppyHungryEat);
		scene.attachChild(mediumGuppyHungryTurn);
		scene.attachChild(mediumGuppySwim);
		scene.attachChild(mediumGuppyTurn);
	}
	
	private void smallGuppy() {
		smallGuppyDie = new AnimatedSprite(50, 50,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_SMALL_DIE) , this.getVertexBufferObjectManager());
		smallGuppyDie.animate(80);
		
		smallGuppyEat = new AnimatedSprite(100, 50,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_SMALL_EAT) , this.getVertexBufferObjectManager());
		smallGuppyEat.animate(80);
	
		smallGuppyHungryEat = new AnimatedSprite(150, 50,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_SMALL_HUNGRY_EAT) , this.getVertexBufferObjectManager());
		smallGuppyHungryEat.animate(80);

		smallGuppyHungryTurn = new AnimatedSprite(200, 50,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_SMALL_HUNGRY_TURN) , this.getVertexBufferObjectManager());
		smallGuppyHungryTurn.animate(80);

		smallGuppySwim = new AnimatedSprite(250, 50,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_SMALL_SWIM) , this.getVertexBufferObjectManager());
		smallGuppySwim.animate(80);

		smallGuppyTurn = new AnimatedSprite(300, 50,rsFac.getTiledTextureRegion(FishID.FISH_GUPPY_SMALL_TURN) , this.getVertexBufferObjectManager());
		smallGuppyTurn.animate(80);
		
		scene.attachChild(smallGuppyDie);
		scene.attachChild(smallGuppyEat);
		scene.attachChild(smallGuppyHungryEat);
		scene.attachChild(smallGuppyHungryTurn);
		scene.attachChild(smallGuppySwim);
		scene.attachChild(smallGuppyTurn);
	}
	
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		smallGuppyDie.setPosition(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
		if (smallGuppyDie.collidesWith(smallGuppyEat)) {
			Log.e("hao","da cham roi ne "+ SystemClock.elapsedRealtime());
		}
		return true;
	}
}

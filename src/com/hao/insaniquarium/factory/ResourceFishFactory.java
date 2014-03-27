package com.hao.insaniquarium.factory;

import java.util.HashMap;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import com.hao.insaniquarium.main.Main;

public class ResourceFishFactory {
	
	private  Main main;
	private  HashMap<Integer, ITiledTextureRegion> resourceMap;
	//===============================================
	// Constant
	//===============================================
	
	// GUPPY SMALL
	public static int FISH_GUPPY_SMALL_DIE = 1;
	public static int FISH_GUPPY_SMALL_EAT = 2;
	public static int FISH_GUPPY_SMALL_HUNGRY_EAT = 3;
	public static int FISH_GUPPY_SMALL_HUNGRY_TURN = 4;
	public static int FISH_GUPPY_SMALL_SWIM = 5;
	public static int FISH_GUPPY_SMALL_TURN = 6;

	
	public ResourceFishFactory(Main main) {
		this.main = main;
		this.resourceMap = new HashMap<Integer, ITiledTextureRegion>();
	}

	public void guppy(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/guppy/");
		
		BitmapTextureAtlas guppyTextureAtlas = new BitmapTextureAtlas(main.getTextureManager(), 390, 68, TextureOptions.BILINEAR);
		TiledTextureRegion guppySmallDie = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(guppyTextureAtlas, main,
				"goldfish_small_die.png", 0, 0, 10, 1);
		TiledTextureRegion guppySmallEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(guppyTextureAtlas, main,
				"goldfish_small_eat.png", 0, 34, 10, 1);
		guppyTextureAtlas.load();
		
		// put resource to hash map
		this.resourceMap.put(FISH_GUPPY_SMALL_DIE, guppySmallDie);
		this.resourceMap.put(FISH_GUPPY_SMALL_EAT, guppySmallEat);
	}
	
	public ITiledTextureRegion getTiledTextureRegion(int id){
		return this.resourceMap.get(id);
	}
	
}

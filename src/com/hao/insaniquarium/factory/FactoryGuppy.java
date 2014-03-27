package com.hao.insaniquarium.factory;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;


public class FactoryGuppy {
	
	

	public static void smallGuppy(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/guppy/small/");
		
		BitmapTextureAtlas smallGuppyTextureAtlas = new BitmapTextureAtlas(ResourceFactory.main.getTextureManager(), 390, 201, TextureOptions.BILINEAR);
		TiledTextureRegion guppySmallDie = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(smallGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_SMALL_DIE, 0, 0, 10, 1);
		TiledTextureRegion guppySmallEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(smallGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_SMALL_EAT, 0, 34, 10, 1);
		TiledTextureRegion guppySmallHungryEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(smallGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_SMALL_HUNGRY_EAT, 0, 68, 10, 1);
		TiledTextureRegion guppySmallHungryTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(smallGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_SMALL_HUNGRY_TURN, 0, 102, 10, 1);
		TiledTextureRegion guppySmallSwim = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(smallGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_SMALL_SWIM, 0, 135, 10, 1);
		TiledTextureRegion guppySmallTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(smallGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_SMALL_TURN, 0, 168, 10, 1);
		smallGuppyTextureAtlas.load();
		
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_SMALL_DIE, guppySmallDie);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_SMALL_EAT, guppySmallEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_SMALL_HUNGRY_EAT, guppySmallHungryEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_SMALL_HUNGRY_TURN, guppySmallHungryTurn);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_SMALL_SWIM, guppySmallSwim);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_SMALL_TURN, guppySmallTurn);
	}
	
	public static void mediumGuppy(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/guppy/medium/");
		
		BitmapTextureAtlas mediumGuppyTextureAtlas = new BitmapTextureAtlas(ResourceFactory.main.getTextureManager(), 570,292, TextureOptions.BILINEAR);
		TiledTextureRegion guppyMediumDie = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mediumGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_MEDIUM_DIE, 0, 0, 10, 1);
		TiledTextureRegion guppyMediumEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mediumGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_MEDIUM_EAT, 0, 50, 10, 1);
		TiledTextureRegion guppyMediumHungryEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mediumGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_MEDIUM_HUNGRY_EAT, 0, 99, 10, 1);
		TiledTextureRegion guppyMediumHungryTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mediumGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_MEDIUM_HUNGRY_TURN, 0, 148, 10, 1);
		TiledTextureRegion guppyMediumSwim = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mediumGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_MEDIUM_SWIM, 0, 196, 10, 1);
		TiledTextureRegion guppyMediumTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mediumGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_MEDIUM_TURN, 0, 244, 10, 1);
		mediumGuppyTextureAtlas.load();
		
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_MEDIUM_DIE, guppyMediumDie);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_MEDIUM_EAT, guppyMediumEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_MEDIUM_HUNGRY_EAT, guppyMediumHungryEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_MEDIUM_HUNGRY_TURN, guppyMediumHungryTurn);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_MEDIUM_SWIM, guppyMediumSwim);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_MEDIUM_TURN, guppyMediumTurn);
	}
	
	public static void bigGuppy(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/guppy/big/");
		
		BitmapTextureAtlas bigGuppyTextureAtlas = new BitmapTextureAtlas(ResourceFactory.main.getTextureManager(), 750,384, TextureOptions.BILINEAR);
		TiledTextureRegion guppyBigDie = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bigGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_BIG_DIE, 0, 0, 10, 1);
		TiledTextureRegion guppyBigEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bigGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_BIG_EAT, 0, 66, 10, 1);
		TiledTextureRegion guppyBigHungryEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bigGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_BIG_HUNGRY_EAT, 0, 130, 10, 1);
		TiledTextureRegion guppyBigHungryTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bigGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_BIG_HUNGRY_TURN, 0, 194, 10, 1);
		TiledTextureRegion guppyBigSwim = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bigGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_BIG_SWIM, 0, 257, 10, 1);
		TiledTextureRegion guppyBigTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bigGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_BIG_TURN, 0, 320, 10, 1);
		bigGuppyTextureAtlas.load();
		
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_BIG_DIE, guppyBigDie);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_BIG_EAT, guppyBigEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_BIG_HUNGRY_EAT, guppyBigHungryEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_BIG_HUNGRY_TURN, guppyBigHungryTurn);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_BIG_SWIM, guppyBigSwim);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_BIG_TURN, guppyBigTurn);
	}
	
	public static void kingGuppy(){
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/guppy/king/");
		
		BitmapTextureAtlas kingGuppyTextureAtlas = new BitmapTextureAtlas(ResourceFactory.main.getTextureManager(), 800,388, TextureOptions.BILINEAR);
		TiledTextureRegion guppyKingDie = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(kingGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_KING_DIE, 0, 0, 10, 1);
		TiledTextureRegion guppyKingEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(kingGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_KING_EAT, 0, 66, 10, 1);
		TiledTextureRegion guppyKingHungryEat = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(kingGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_KING_HUNGRY_EAT, 0, 131, 10, 1);
		TiledTextureRegion guppyKingHungryTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(kingGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_KING_HUNGRY_TURN, 0, 198, 10, 1);
		TiledTextureRegion guppyKingSwim = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(kingGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_KING_SWIM, 0, 261, 10, 1);
		TiledTextureRegion guppyKingTurn = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(kingGuppyTextureAtlas, ResourceFactory.main,
				FishID.FISH_GUPPY_KING_TURN, 0, 324, 10, 1);
		kingGuppyTextureAtlas.load();
		
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_KING_DIE, guppyKingDie);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_KING_EAT, guppyKingEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_KING_HUNGRY_EAT, guppyKingHungryEat);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_KING_HUNGRY_TURN, guppyKingHungryTurn);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_KING_SWIM, guppyKingSwim);
		ResourceFactory.getResourceMap().put(FishID.FISH_GUPPY_KING_TURN, guppyKingTurn);
	}

	public static void loadGuppy() {
		smallGuppy();
		mediumGuppy();
		bigGuppy();
		kingGuppy();
	}
}

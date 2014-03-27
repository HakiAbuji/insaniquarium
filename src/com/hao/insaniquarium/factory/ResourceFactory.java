package com.hao.insaniquarium.factory;

import java.util.HashMap;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import com.hao.insaniquarium.main.Main;

public class ResourceFactory {
	
	static  Main main;
	private static  HashMap<String, ITiledTextureRegion> resourceMap;

	

	public ResourceFactory(Main main) {
		ResourceFactory.main = main;
		ResourceFactory.resourceMap = new HashMap<String, ITiledTextureRegion>();
	}

	public ITiledTextureRegion getTiledTextureRegion(String id){
		return ResourceFactory.resourceMap.get(id);
	}
	
	public void loadGuppy(){
		FactoryGuppy.loadGuppy();
	}
	
	static HashMap<String, ITiledTextureRegion> getResourceMap() {
		return resourceMap;
	}

	public void setResourceMap(HashMap<String, ITiledTextureRegion> resourceMap) {
		ResourceFactory.resourceMap = resourceMap;
	}
}

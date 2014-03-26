package org.andengine.entity.sprite;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.vbo.HighPerformanceTiledSpriteVertexBufferObject;
import org.andengine.entity.sprite.vbo.ITiledSpriteVertexBufferObject;
import org.andengine.opengl.shader.PositionColorTextureCoordinatesShaderProgram;
import org.andengine.opengl.shader.ShaderProgram;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.DrawType;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.opengl.GLES20;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 19:30:13 - 09.03.2010
 */
public class ChangeableTiledSprite extends Sprite {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private int mCurrentTileIndex;
	private ITiledSpriteVertexBufferObject mTiledSpriteVertexBufferObject;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ChangeableTiledSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		this(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager, DrawType.STATIC);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final ShaderProgram pShaderProgram) {
		this(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager, DrawType.STATIC, pShaderProgram);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType) {
		this(pX, pY, pTiledTextureRegion.getWidth(), pTiledTextureRegion.getHeight(), pTiledTextureRegion, pVertexBufferObjectManager, pDrawType);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType, final ShaderProgram pShaderProgram) {
		this(pX, pY, pTiledTextureRegion.getWidth(), pTiledTextureRegion.getHeight(), pTiledTextureRegion, pVertexBufferObjectManager, pDrawType, pShaderProgram);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final ITiledSpriteVertexBufferObject pTiledSpriteVertexBufferObject) {
		this(pX, pY, pTiledTextureRegion.getWidth(), pTiledTextureRegion.getHeight(), pTiledTextureRegion, pTiledSpriteVertexBufferObject);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final ITiledSpriteVertexBufferObject pTiledSpriteVertexBufferObject, final ShaderProgram pShaderProgram) {
		this(pX, pY, pTiledTextureRegion.getWidth(), pTiledTextureRegion.getHeight(), pTiledTextureRegion, pTiledSpriteVertexBufferObject, pShaderProgram);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final float pWidth, final float pHeight, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		this(pX, pY, pWidth, pHeight, pTiledTextureRegion, pVertexBufferObjectManager, DrawType.STATIC);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final float pWidth, final float pHeight, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final ShaderProgram pShaderProgram) {
		this(pX, pY, pWidth, pHeight, pTiledTextureRegion, pVertexBufferObjectManager, DrawType.STATIC, pShaderProgram);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final float pWidth, final float pHeight, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType) {
		this(pX, pY, pWidth, pHeight, pTiledTextureRegion, new HighPerformanceTiledSpriteVertexBufferObject(pVertexBufferObjectManager, TiledSprite.TILEDSPRITE_SIZE * pTiledTextureRegion.getTileCount(), pDrawType, true, Sprite.VERTEXBUFFEROBJECTATTRIBUTES_DEFAULT));
	}

	public ChangeableTiledSprite(final float pX, final float pY, final float pWidth, final float pHeight, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType, final ShaderProgram pShaderProgram) {
		this(pX, pY, pWidth, pHeight, pTiledTextureRegion, new HighPerformanceTiledSpriteVertexBufferObject(pVertexBufferObjectManager, TiledSprite.TILEDSPRITE_SIZE * pTiledTextureRegion.getTileCount(), pDrawType, true, Sprite.VERTEXBUFFEROBJECTATTRIBUTES_DEFAULT), pShaderProgram);
	}

	public ChangeableTiledSprite(final float pX, final float pY, final float pWidth, final float pHeight, final ITiledTextureRegion pTiledTextureRegion, final ITiledSpriteVertexBufferObject pTiledSpriteVertexBufferObject) {
		this(pX, pY, pWidth, pHeight, pTiledTextureRegion, pTiledSpriteVertexBufferObject, PositionColorTextureCoordinatesShaderProgram.getInstance());
	}

	public ChangeableTiledSprite(final float pX, final float pY, final float pWidth, final float pHeight, final ITiledTextureRegion pTiledTextureRegion, final ITiledSpriteVertexBufferObject pTiledSpriteVertexBufferObject, final ShaderProgram pShaderProgram) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion, pTiledSpriteVertexBufferObject, pShaderProgram);

		this.mTiledSpriteVertexBufferObject = pTiledSpriteVertexBufferObject;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public ITextureRegion getTextureRegion() {
		return this.getTiledTextureRegion().getTextureRegion(this.mCurrentTileIndex);
	}

	public ITiledTextureRegion getTiledTextureRegion() {
		return (ITiledTextureRegion) this.mTextureRegion;
	}
	
	public void setTiledTextureRegion(ITiledTextureRegion tiledTexture) {
		this.mCurrentTileIndex = 0;
		this.mTextureRegion = tiledTexture;
		this.setBlendingEnabled(true);
		this.initBlendFunction(tiledTexture);
		this.setSize(this.mTextureRegion.getWidth(), this.mTextureRegion.getHeight());
		this.onUpdateColor();
		this.onUpdateTextureCoordinates();
	}

	@Override
	public ITiledSpriteVertexBufferObject getVertexBufferObject() {
		return (ITiledSpriteVertexBufferObject) super.getVertexBufferObject();
	}

	@Override
	protected void draw(final GLState pGLState, final Camera pCamera) {
		this.mTiledSpriteVertexBufferObject.draw(GLES20.GL_TRIANGLES, this.mCurrentTileIndex * TiledSprite.VERTICES_PER_TILEDSPRITE, TiledSprite.VERTICES_PER_TILEDSPRITE);
	}

	@Override
	protected void onUpdateColor() {
		this.getVertexBufferObject().onUpdateColor(this);
	}

	@Override
	protected void onUpdateVertices() {
		this.getVertexBufferObject().onUpdateVertices(this);
	}

	@Override
	protected void onUpdateTextureCoordinates() {
		this.getVertexBufferObject().onUpdateTextureCoordinates(this);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public int getCurrentTileIndex() {
		return this.mCurrentTileIndex;
	}

	public void setCurrentTileIndex(final int pCurrentTileIndex) {
		this.mCurrentTileIndex = pCurrentTileIndex;
	}

	public int getTileCount() {
		return this.getTiledTextureRegion().getTileCount();
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}

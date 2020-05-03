package com.vincepresso.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChessApplication extends ApplicationAdapter {
	
	public static final int WIDTH = 960;
	public static final int HEIGHT = 640;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Board board;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, WIDTH, HEIGHT);
		this.board = new Board();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		for(Tile tile : board.getTileList()) {
			batch.draw(tile.getTexture(), tile.x, tile.y);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		board.dispose();
	}
}

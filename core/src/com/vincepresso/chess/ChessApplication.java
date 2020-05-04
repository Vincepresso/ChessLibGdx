package com.vincepresso.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;

public class ChessApplication extends ApplicationAdapter {
	
	public static final int WIDTH = 960;
	public static final int HEIGHT = 640;
	private SpriteBatch batch;
	private ChessMapRenderer mapRenderer;
	private Map map;
	private OrthographicCamera camera;
	private Board board;
	
	@Override
	public void create () {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, WIDTH, HEIGHT);
		this.board = new Board();
		this.batch = new SpriteBatch();
		this.map = new Map();
		this.map.getLayers().add(this.board);
		this.mapRenderer = new ChessMapRenderer(this.map, this.batch);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(this.camera.combined);
		this.mapRenderer.setView(this.camera);
		
		this.batch.begin();
		this.mapRenderer.render();
		this.batch.end();
	}
	
	@Override
	public void dispose () {
		this.batch.dispose();
		this.map.dispose();
		this.board.dispose();
	}
}

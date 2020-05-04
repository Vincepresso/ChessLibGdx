package com.vincepresso.chess;

import java.util.Iterator;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.math.Matrix4;

public class ChessMapRenderer implements MapRenderer {
	
	private Map map;
	private SpriteBatch batch;

	public ChessMapRenderer(Map map, SpriteBatch batch) {
		super();
		this.map = map;
		this.batch = batch;
	}

	@Override
	public void setView(OrthographicCamera camera) {
		this.batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void setView(Matrix4 projectionMatrix, float viewboundsX, float viewboundsY, float viewboundsWidth,
			float viewboundsHeight) {
	}

	@Override
	public void render() {
		Iterator<MapLayer> layerIterator = this.map.getLayers().iterator();
		while(layerIterator.hasNext()) {
			MapLayer layer = (MapLayer) layerIterator.next();
			if("board".equalsIgnoreCase((String) layer.getProperties().get("type"))) {
				Iterator<MapObject> tileIterator = layer.getObjects().iterator();
				while(tileIterator.hasNext()) {
					Tile tile = (Tile) tileIterator.next();
					this.batch.draw(tile.getTexture(), (int) tile.getProperties().get("x"), (int) tile.getProperties().get("y"));
				}
			}
		}
		
	}

	@Override
	public void render(int[] layers) {
	}

}

package com.vincepresso.chess;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;

public class Board extends MapLayer {

	private static final int TILE_COUNT = 8;
	private static final int TILE_WIDTH = 80;
	private static final int TILE_HEIGHT = 80;

	public Board() {
		super();
		this.getProperties().put("type", "board");
		for(int i = 0; i < TILE_WIDTH * TILE_COUNT; i += TILE_WIDTH) {
			int row = i / TILE_WIDTH + 1;
			for(int j = 0; j < TILE_HEIGHT * TILE_COUNT; j += TILE_HEIGHT) {
				int col = j / TILE_HEIGHT + 1;
				Tile tile = null;
				if((row + col) % 2 == 1) {
					tile = new Tile(new Texture(Gdx.files.internal("white_tile.png")));
					tile.getProperties().put("color", "white");
				} else {
					tile = new Tile(new Texture(Gdx.files.internal("black_tile.png")));
					tile.getProperties().put("color", "black");
				}
				tile.getProperties().put("x", i);
				tile.getProperties().put("y", j);
				tile.getProperties().put("width", TILE_WIDTH);
				tile.getProperties().put("height", TILE_HEIGHT);
				tile.getProperties().put("row", row);
				tile.getProperties().put("col", col);
				tile.init();
				this.getObjects().add(tile);
			}
		}
	}
	
	public void dispose() {
		Iterator<MapObject> tileIterator = this.getObjects().iterator();
		while(tileIterator.hasNext()) {
			Tile tile = (Tile) tileIterator.next();
			tile.dispose();
		}
	}

}

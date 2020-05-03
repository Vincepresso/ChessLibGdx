package com.vincepresso.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Board {

	private static final int TILE_COUNT = 8;
	private static final int TILE_WIDTH = 80;
	private static final int TILE_HEIGHT = 80;
	private Array<Tile> tileList;

	public Board() {
		this.tileList = new Array<Tile>();
		boolean lastWhite = false;
		for(int i = 0; i < TILE_WIDTH * TILE_COUNT; i += TILE_WIDTH) {
			for(int j = 0; j < TILE_HEIGHT * TILE_COUNT; j += TILE_HEIGHT) {
				Tile tile = null;
				if(i == 0 && j == 0) {
					tile = new Tile(i, j, TILE_WIDTH,TILE_HEIGHT, new Texture(Gdx.files.internal("white_tile.png")), true);
					lastWhite = true;
				} else {
					if(i == 0) {
						if(lastWhite) {
							tile = new Tile(i, j, TILE_WIDTH,TILE_HEIGHT, new Texture(Gdx.files.internal("black_tile.png")), false);
							lastWhite = false;
						} else {
							tile = new Tile(i, j, TILE_WIDTH,TILE_HEIGHT, new Texture(Gdx.files.internal("white_tile.png")), true);
							lastWhite = true;
						}
					}
					tile = new Tile(i, j, TILE_WIDTH,TILE_HEIGHT, new Texture(Gdx.files.internal("black_tile.png")), false);
				}
				this.tileList.add(tile);
			}
		}
	}

	public Array<Tile> getTileList() {
		return tileList;
	}
	
	public void dispose() {
		for(Tile tile : this.tileList) {
			tile.dispose();
		}
	}
	
}

package com.vincepresso.chess;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Tile {
	
	public boolean white;
	public float x;
	public float y;
	public int width;
	public int height;
	private Texture texture;
	private Rectangle bound;
	
	public Tile(int x, int y, int width, int height, Texture texture, boolean white) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.bound = new Rectangle(x, y, width, height);
	}
	
	public boolean isWhite() {
		return white;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}



	public void dispose() {
		this.texture.dispose();
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Rectangle getBound() {
		return bound;
	}

	public void setBound(Rectangle bound) {
		this.bound = bound;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}

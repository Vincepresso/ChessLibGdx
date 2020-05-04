package com.vincepresso.chess;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;

public class Tile extends MapObject{
	
	private Texture texture;
	private Rectangle bound;
	
	public Tile(Texture texture) {
		super();
		this.texture = texture;
		this.bound = new Rectangle();
	}
	
	public void init() {
		this.bound.setX((int) this.getProperties().get("x"));
		this.bound.setY((int) this.getProperties().get("y"));
		this.bound.setWidth((int) this.getProperties().get("width"));
		this.bound.setHeight((int) this.getProperties().get("height"));
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
	
}

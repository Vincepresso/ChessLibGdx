package com.vincepresso.chess.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vincepresso.chess.ChessApplication;

public class DesktopLauncher {
	
	public static final int WIDTH = 960;
	public static final int HEIGHT = 640;
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	      config.title = "Chess";
	      config.width = WIDTH;
	      config.height = HEIGHT;
	      config.resizable = false;
	      config.fullscreen = false;
	      config.x = -1;
	      config.y = 0;
		new LwjglApplication(new ChessApplication(), config);
	}
}

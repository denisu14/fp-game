package com.denisu.fpgame.Screen;

import com.badlogic.gdx.Screen;

public class ScreenUtil {
	
    private static MScreen currentScreen;
	
	public static void setScreen(MScreen screen) {
		if (currentScreen != null)
			currentScreen.dispose();
		currentScreen = screen;
		currentScreen.create();
	}
	
	public static MScreen getCurrentScreen() {
		return currentScreen;
	}

}

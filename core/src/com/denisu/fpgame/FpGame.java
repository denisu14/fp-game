package com.denisu.fpgame;
import java.util.Timer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.denisu.fpgame.Screen.MScreen;
import com.denisu.fpgame.Screen.ScreenUtil;
import com.denisu.fpgame.fileIO.FileIO;
import com.denisu.fpgame.player.GamePlayer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class FpGame extends ApplicationAdapter {
    ShapeRenderer shape;
	GamePlayer player;
    BitmapFont mainFont;
    private SpriteBatch sprites;
    private TextureAtlas atlas;
    public static int WIDTH = 240, HEIGHT = 160;
    private SpriteBatch batch;
    private Timer t;
    long startTime;

    @Override
	public void create() {		
		batch = new SpriteBatch();
		ScreenUtil.setScreen(new MScreen());
        t = new Timer();
        startTime = System.currentTimeMillis();
	}

	@Override
	public void dispose() {
		if (ScreenUtil.getCurrentScreen() != null)
            ScreenUtil.getCurrentScreen().dispose();
		batch.dispose();
        t.cancel();
        FileIO.WriteHighscore((System.currentTimeMillis()-startTime)/1000+ " seconds.");
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		if (ScreenUtil.getCurrentScreen() != null)
        ScreenUtil.getCurrentScreen().update();
		
		if (ScreenUtil.getCurrentScreen() != null)
        ScreenUtil.getCurrentScreen().render(batch);
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenUtil.getCurrentScreen() != null)
        ScreenUtil.getCurrentScreen().resize(width, height);
	}

	@Override
	public void pause() {
		if (ScreenUtil.getCurrentScreen() != null)
        ScreenUtil.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		if (ScreenUtil.getCurrentScreen() != null)
        ScreenUtil.getCurrentScreen().resume();
	}
}

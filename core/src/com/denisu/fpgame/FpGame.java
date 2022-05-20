package com.denisu.fpgame;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.denisu.fpgame.player.GamePlayer;
import com.badlogic.gdx.graphics.GL30;

public class FpGame extends ApplicationAdapter {
    ShapeRenderer shape;
	GamePlayer player;

    @Override
    public void create () {
        shape = new ShapeRenderer();
		player = new GamePlayer();
    }

    @Override
    public void render () {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		player.x += 2;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(player.x, 50, 50);
        shape.end();
    }
}
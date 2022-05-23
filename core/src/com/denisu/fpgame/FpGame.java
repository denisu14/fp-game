package com.denisu.fpgame;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.denisu.fpgame.player.GamePlayer;
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
    public static int WIDTH = 800, HEIGHT = 600;

    @Override
    public void create () {
        shape = new ShapeRenderer();
		player = new GamePlayer();
        mainFont = new BitmapFont();
        sprites = new SpriteBatch();
        atlas = new TextureAtlas("SpaceInvaders/large.txt");
    }

    @Override
    public void render () {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		player.x += 2;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle(player.x, 50, 50);
        shape.end();
    }

    @Override
    public void dispose()
    {

    }
}
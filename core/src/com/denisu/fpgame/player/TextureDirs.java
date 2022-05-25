package com.denisu.fpgame.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureDirs {
    public static Texture PLAYER = new Texture(Gdx.files.internal("SpaceInvaders/seperated/tile000.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("SpaceInvaders/seperated/tile006.png"));
	public static Texture ENEMY = new Texture(Gdx.files.internal("SpaceInvaders/seperated/tile007.png"));
	public static Texture GAME_OVER = new Texture(Gdx.files.internal("SpaceInvaders/seperated/tile004.png"));
	public static Texture GAME_WON = new Texture(Gdx.files.internal("SpaceInvaders/seperated/tile009.png"));
}

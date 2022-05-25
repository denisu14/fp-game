package com.denisu.fpgame.player;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.denisu.fpgame.FpGame;


public class Enemy extends EntityBase {

	public Enemy(Vector2 pos, Vector2 direction) {
		super(TextureDirs.ENEMY, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if (pos.y <= -TextureDirs.ENEMY.getHeight()) {
			float x = MathUtils.random(0, FpGame.WIDTH - TextureDirs.ENEMY.getWidth());
			pos.set(x, FpGame.HEIGHT);
		}
	}
	
}

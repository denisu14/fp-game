package com.denisu.fpgame.player;

import com.badlogic.gdx.math.Vector2;
import com.denisu.fpgame.FpGame;

public class BulletEntity extends EntityBase {
    public BulletEntity(Vector2 pos) {
		super(TextureDirs.MISSILE, pos, new Vector2(0, 5));
	}

	@Override
	public void update() {
		pos.add(direction);
	}
	
	public boolean checkEnd() {
		return pos.y >= FpGame.HEIGHT;
	}
}

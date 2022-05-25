package com.denisu.fpgame.player;

import com.denisu.fpgame.FpGame;
import com.denisu.fpgame.camera.OrthographicCustomCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends EntityBase {

    private final EntityManager entityManager;
	private final OrthographicCustomCamera camera;
	private long lastFire;
	
	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager, OrthographicCustomCamera camera) {
		super(TextureDirs.PLAYER, pos, direction);
		this.entityManager = entityManager;
		this.camera = camera;
	}

	@Override
	public void update() {
		pos.add(direction);
		
		int dir = 0;
		if (Gdx.input.isTouched()) {
			Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
			if (touch.x > FpGame.WIDTH / 2)
				dir = 2;
			else
				dir = 1;
		}
		
		if (Gdx.input.isKeyPressed(Keys.A) || dir == 1) //left
			setDirection(-300, 0);
		else if (Gdx.input.isKeyPressed(Keys.D) || dir == 2) //right
			setDirection(300, 0);
		else 
			setDirection(0, 0);
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (System.currentTimeMillis() - lastFire >= 350) {
				entityManager.addEntity(new BulletEntity(pos.cpy().add((TextureDirs.PLAYER.getWidth()/2)-4 ,TextureDirs.PLAYER.getHeight())));
				lastFire = System.currentTimeMillis();
			}
		}
	}
    
}

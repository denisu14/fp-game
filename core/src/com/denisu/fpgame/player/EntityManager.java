package com.denisu.fpgame.player;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.denisu.fpgame.FpGame;
import com.denisu.fpgame.Screen.ScreenUtil;
import com.denisu.fpgame.camera.OrthographicCustomCamera;

public class EntityManager {
    private final Array<EntityBase> entities = new Array<EntityBase>();
	private final Player player;
	
	public EntityManager(int amount, OrthographicCustomCamera camera) {
		player = new Player(new Vector2(230, 15), new Vector2(0, 0), this, camera);
		for (int i = 0; i < amount; i++) {
			float x = MathUtils.random(0, FpGame.WIDTH - TextureDirs.ENEMY.getWidth());
			float y = MathUtils.random(FpGame.HEIGHT, FpGame.HEIGHT * 3);
			float speed = MathUtils.random(2, 5);
			addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed)));
		}
	}
	
	public void update() {
		for (EntityBase e : entities)
			e.update();
		for (BulletEntity m : getBulletEntitys())
			if (m.checkEnd())
				entities.removeValue(m, false);
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb) {
		for (EntityBase e : entities)
			e.render(sb);
		player.render(sb);
	}
	
	private void checkCollisions() {
		for (Enemy e : getEnemies()) {
			for (BulletEntity m : getBulletEntitys()) {
				if (e.getBounds().overlaps(m.getBounds())) {
					entities.removeValue(e, false);
					entities.removeValue(m, false);
					if (gameOver()){
						//ScreenUtil.setScreen(new GameOverScreen(true));
                    }
				}
			}
			if (e.getBounds().overlaps(player.getBounds())) {
				//ScreenUtil.setScreen(new GameOverScreen(false));
			}
		}
	}
	
	public void addEntity(EntityBase entity) {
		entities.add(entity);
	}
	
	private Array<Enemy> getEnemies() {
		Array<Enemy> ret = new Array<Enemy>();
		for (EntityBase e : entities)
			if (e instanceof Enemy)
				ret.add((Enemy)e);
		return ret;
	}
	
	private Array<BulletEntity> getBulletEntitys() {
		Array<BulletEntity> ret = new Array<BulletEntity>();
		for (EntityBase e : entities)
			if (e instanceof BulletEntity)
				ret.add((BulletEntity)e);
		return ret;
	}
	
	public boolean gameOver() {
		return getEnemies().size <= 0;
	}
}

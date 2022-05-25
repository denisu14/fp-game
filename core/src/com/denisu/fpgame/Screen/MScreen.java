package com.denisu.fpgame.Screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.denisu.fpgame.camera.OrthographicCustomCamera;
import com.denisu.fpgame.player.EntityManager;


public class MScreen extends ScreenBase {

    private OrthographicCustomCamera camera;
	private com.denisu.fpgame.player.EntityManager entityManager;
	
	@Override
	public void create() {
		camera = new OrthographicCustomCamera();
		entityManager = new EntityManager(10, camera);
	}

	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
}

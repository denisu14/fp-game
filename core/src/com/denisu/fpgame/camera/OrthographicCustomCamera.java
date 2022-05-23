package com.denisu.fpgame.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
//import com.youtube.invaders.MainGame;
import com.denisu.fpgame.FpGame;

public class OrthographicCustomCamera extends OrthographicCamera {

	Vector3 tmp = new Vector3();
	Vector2 origin = new Vector2();
	VirtVP virtualViewport;
	Vector2 pos = new Vector2();

	public OrthographicCustomCamera() {
		this(new VirtVP(FpGame.WIDTH, FpGame.HEIGHT));
	}
	
	public OrthographicCustomCamera(VirtVP virtualViewport) {
		this(virtualViewport, 0f, 0f);
	}

	public OrthographicCustomCamera(VirtVP virtualViewport, float cx, float cy) {
		this.virtualViewport = virtualViewport;
		this.origin.set(cx, cy);
	}

	public void setVirtualViewport(VirtVP virtualViewport) {
		this.virtualViewport = virtualViewport;
	}
	
	public void setPosition(float x, float y) {
		position.set(x - viewportWidth * origin.x, y - viewportHeight * origin.y, 0f);
		pos.set(x, y);
	}
	
	public Vector2 getPos() {
		return pos;
	}

	@Override
	public void update() {
		float left = zoom * -viewportWidth / 2 + virtualViewport.getVirtualWidth() * origin.x;
		float right = zoom * viewportWidth / 2 + virtualViewport.getVirtualWidth() * origin.x;
		float top = zoom * viewportHeight / 2 + virtualViewport.getVirtualHeight() * origin.y;
		float bottom = zoom * -viewportHeight / 2 + virtualViewport.getVirtualHeight() * origin.y;

		projection.setToOrtho(left, right, bottom, top, Math.abs(near), Math.abs(far));
		view.setToLookAt(position, tmp.set(position).add(direction), up);
		combined.set(projection);
		Matrix4.mul(combined.val, view.val);
		invProjectionView.set(combined);
		Matrix4.inv(invProjectionView.val);
		frustum.update(invProjectionView);
	}

	
	public void updateViewport() {
		setToOrtho(false, virtualViewport.getWidth(), virtualViewport.getHeight());
	}
	
	public Vector2 unprojectCoordinates(float x, float y) {
        Vector3 rawtouch = new Vector3(x, y,0);
        unproject(rawtouch); 
        return new Vector2(rawtouch.x, rawtouch.y);
    }
	
	public void resize() {
		VirtVP virtualViewport = new VirtVP(FpGame.WIDTH, FpGame.HEIGHT);  
		setVirtualViewport(virtualViewport);  
		updateViewport();
	}
}
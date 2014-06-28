package info.adamjsmith.framework.gl;

import javax.microedition.khronos.opengles.GL10;

import info.adamjsmith.framework.impl.GLGraphics;
import info.adamjsmith.framework.math.Vector2;

public class Camera2D {
	public final Vector2 position;
	public float zoom;
	public final float frustumWidth;
	public final float frustumHeight;
	final GLGraphics glGraphics;
	
	public Camera2D(GLGraphics glGraphics, float frustumWidth, float frustumHeight) {
		this.glGraphics = glGraphics;
		this.frustumWidth = frustumWidth;
		this.frustumHeight = frustumHeight;
		this.position = new Vector2(frustumWidth / 2, frustumHeight /2);
		this.zoom = 1.0f;
	}
	
	public void setViewportAndMatrices() {
		GL10 gl = glGraphics.getGL();
		gl.glViewport(0, 0, glGraphics.getWidth(), glGraphics.getHeight());
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(position.x - frustumWidth * zoom / 2,
					position.x + frustumWidth * zoom / 2,
					position.y - frustumHeight * zoom / 2,
					position.y + frustumHeight * zoom / 2, 1, -2);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
}

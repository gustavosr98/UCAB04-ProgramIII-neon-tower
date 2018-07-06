package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Bloque {
	public abstract void update();
	public abstract void draw(SpriteBatch batch);
	public abstract void dispose(World world);
	public abstract void enlazar(Bloque b);
	public abstract Body getBody();
	public abstract boolean hayBloqueEntre(float y1, float y2);

	public abstract float getGraphicY();
	public abstract float getGraphicX();
	public abstract float getPhisicY();
	public abstract float getPhisicX();
	public abstract float getGraphicWidth();
	public abstract boolean gameOver(float y);
}
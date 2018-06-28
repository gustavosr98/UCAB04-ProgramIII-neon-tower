package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

public class Board {
	ArrayList<Paquete> paquetes;
	ArrayList<Color> colores;
	int colorIndex;

	public Board(){
		paquetes = new ArrayList<Paquete>();
		colores = new ArrayList<Color>();
		colorIndex = 0;

		colores.add(new Color(1f,0,0));
		colores.add(new Color(0,1f,0));
		colores.add(new Color(0,0,1f));
		colores.add(new Color( 0.4f, 1,1) );
		colores.add(new Color( 1, 0.2f,0.6f) );
		colores.add(new Color( 0.2f, 1 ,0.6f) );
	}

	public void nuevoPaquete(World world, float unidad, float x, float y) {
		paquetes.add( new Paquete(world, unidad, x , y, colores.get( colorIndex ) ) );
		siguienteColor();
	}

	public void siguienteColor(){
		colorIndex++;
		if (colorIndex >= colores.size() )
			colorIndex = 0;
	}

	public void update(){
		for (Paquete p: paquetes)
			p.update();
	}

	public void draw(SpriteBatch batch){
		for (Paquete p: paquetes)
			p.draw(batch);
	}

	public void dispose(World world){
		for (Paquete p: paquetes)
			p.dispose(world);
		paquetes.clear();
	}



}
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGdxGame extends Game {
	private float h;
	private float w;
	private float unidad;

	public PantallaJuego pantallaJuego;
	public PantallaMenu pantallaMenu;


	@Override
	public void create () {

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight() ;
		unidad = w / 16 ;

		pantallaJuego = new PantallaJuego(this);
		pantallaMenu = new PantallaMenu(this);

		setScreen(pantallaMenu);
	}



	public float getWidth(){
		return w;
	}

	public float getHeight(){
		return h;
	}

	public float getUnidad(){
		return unidad;
	}

}

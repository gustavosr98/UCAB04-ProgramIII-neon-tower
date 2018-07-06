package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGdxGame extends Game {
	private float h;
	private float w;
	private float unidad;

	public PantallaMenu pantallaMenu;
	public PantallaJuego pantallaJuego;
	public PantallaPausa pantallaPausa;
	public PantallaGameOver pantallaGameOver;


	@Override
	public void create () {

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight() ;
		unidad = w / 16 ;

		pantallaMenu = new PantallaMenu(this);
		pantallaJuego = new PantallaJuego(this);
		pantallaPausa = new PantallaPausa(this);
		pantallaGameOver = new PantallaGameOver(this);

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


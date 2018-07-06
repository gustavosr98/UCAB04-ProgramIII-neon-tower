package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Contador {
    private float x, y, desfaceY;
    private int numero;
    private BitmapFont bitmapFont;

    public Contador(){
        bitmapFont = new BitmapFont(Gdx.files.internal("fuente.fnt"), Gdx.files.internal("fuente.png"), false);
        bitmapFont.setColor(1,1,1,1);
    }

    public void aleatorio(){
        numero = (int) ( Math.random() * 10 ) + 1;
    }

    public void desfaceY(float dy){
        desfaceY = dy;
    }

    public int getNumero(){
        return numero;
    }

    public void setY(MyGdxGame game){
        y = game.getUnidad()*9;
    }

    public void setX(MyGdxGame game){
        x = game.getWidth()/2 - game.getUnidad()* (5) ;
    }

    public void draw(SpriteBatch batch){
        String cant = String.valueOf(numero);
        bitmapFont.draw(batch, cant, x , y - desfaceY);
    }

    public void dispose(){
        bitmapFont.dispose();
    }
}

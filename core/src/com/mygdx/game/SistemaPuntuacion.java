package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SistemaPuntuacion {
    private float x,y, desfaceY;
    private int score;
    private int multiplicador = 1;
    private BitmapFont bitmapFont;

    public void setMultiplicador(int x){
        if( x != 0){
            multiplicador = x;
        }
    }
    public SistemaPuntuacion(){
        bitmapFont = new BitmapFont(Gdx.files.internal("fuente.fnt"), Gdx.files.internal("fuente.png"), false);
        bitmapFont.setColor(1,1,1,1);
    }

    public void setY(MyGdxGame game){
        y = game.getHeight() - game.getUnidad();
    }

    public void setX(MyGdxGame game){
        x = game.getUnidad()/2;
    }

    public void desfaceY(float dy){
        desfaceY = dy;
    }

    public void reiniciar(){
        score = 0;
    }

    public void sumar(int score){
        this.score += score * 10 * multiplicador ;
    }

    public void draw(SpriteBatch batch){
        String puntuacion = String.valueOf(score) + " x" + String.valueOf(multiplicador);
        bitmapFont.draw(batch, puntuacion, x, y - desfaceY );
    }

    public void dispose(){
        bitmapFont.dispose();
    }

}

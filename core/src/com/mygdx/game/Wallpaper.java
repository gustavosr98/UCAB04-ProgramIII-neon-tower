package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gustavo on 25-Jun-18.
 */

public class Wallpaper {
    Sprite sprite;
    Texture imagen;

    public Wallpaper(float width, float height){
        //fondo por defecto
        imagen = new Texture("Fondo3.jpg");
        sprite = new Sprite(imagen);
        sprite.setSize(width , height);
        sprite.setPosition(0,0);
    }

    public void setWallpaper(Texture imagen, float width, float height){
        this.imagen = imagen;
        this.sprite = new Sprite(imagen);
        sprite.setSize(width, height);
        sprite.setPosition(0,0);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public void dispose(){
        imagen.dispose();
    }

}

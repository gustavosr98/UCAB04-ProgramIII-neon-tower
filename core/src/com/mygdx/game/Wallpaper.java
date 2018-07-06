package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Wallpaper {
    Sprite sprite;

    public Wallpaper(float width, float height){
        //fondo por defecto
        Texture imagen = new Texture("Wallpaper.jpg");
        sprite = new Sprite(imagen);
        sprite.setSize(width , height);
        sprite.setPosition(0,0);
    }

    public void setWallpaper(Texture imagen, float width, float height){
        this.sprite = new Sprite(imagen);
        sprite.setSize(width, height);
        sprite.setPosition(0,0);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

}

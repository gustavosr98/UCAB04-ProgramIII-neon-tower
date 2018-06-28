package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gustavo on 23-Jun-18.
 */

public class Grid {
    Texture imagen;
    Sprite sprite;

    public void Grid(float unidad, float width, float height){
        imagen = new Texture("Grid.png");
        sprite = new Sprite(imagen);
        sprite.setSize(unidad*6 + 5*2*unidad/54, unidad*14 + 13*2*unidad/54);
        sprite.setPosition( (width - unidad*6)/2  , height - unidad*15 + 13*2*unidad/54);
        sprite.setColor(1,1,1,0.2f);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }
}

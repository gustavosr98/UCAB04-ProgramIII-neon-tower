package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BotonPoder extends Boton {

    public BotonPoder(final MyGdxGame game){
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("botonPausa.png")));
        button = new ImageButton(drawable);

        button.setSize(game.getUnidad()*2 , game.getUnidad()*2);
        button.setPosition(game.getWidth()/2 + game.getUnidad()* (5), game.getUnidad()*9 );

    }

    public Button getButton(){
        return button;
    }

}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Javier on 26/06/2018.
 */

public class BotonPlay extends Boton {

    public BotonPlay(final MyGdxGame game){
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("botonPlay.png")));
        imageButton = new ImageButton(drawable);

        imageButton.setSize(game.getUnidad()*5, game.getUnidad()*5);
        imageButton.setPosition(game.getWidth()/2 - imageButton.getWidth() - 100, game.getHeight()/2 - imageButton.getHeight()/2);
        imageButton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.pantallaJuego);
            }
        });
    }

    public ImageButton getImageButton(){
        return imageButton;
    }

}

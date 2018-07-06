package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BotonSalir extends Boton {

    public BotonSalir(final MyGdxGame game){
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("botonSalir.png")));
        button = new ImageButton(drawable);


        button.setSize(game.getUnidad()*5, game.getUnidad()*5);
        button.setPosition(game.getWidth()/2 + button.getWidth()/4 , game.getHeight()/2 - button.getHeight()/2);
        button.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
    }

    public Button getButton(){
        return button;
    }


}

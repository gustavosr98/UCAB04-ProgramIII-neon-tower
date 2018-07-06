package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BotonPoder extends Boton {

    private boolean on;

    public BotonPoder(final MyGdxGame game){
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("botonPoder.png")));
        button = new ImageButton(drawable);

        button.setSize(game.getUnidad()*2 , game.getUnidad()*2);
        button.setPosition(game.getWidth()/2 + game.getUnidad()* (5), game.getUnidad()*9 );

        button.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            }
        });
    }

    public Button getButton(){
        return button;
    }

    public void update(Board board){
        if( button.isPressed() ){
            Gdx.gl.glClearColor(0, 0, 0, 1.0F);
            board.congelar();
        }
    }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class BotonMenu extends Boton {
    private float x, y;

    public BotonMenu(final MyGdxGame game){
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("botonMenu.png")));
        button = new ImageButton(drawable);

        button.setSize(game.getUnidad()*5, game.getUnidad()*5);

        button.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.pantallaJuego.reiniciar();
                game.setScreen(game.pantallaMenu);
            }
        });
    }

    public void setX(float x){
        this.x = x;
        button.setPosition(this.x,this.y);
    }

    public void setY(float y){
        this.y = y;
        button.setPosition(this.x,this.y);
    }

    public Button getButton(){
        return button;
    }

}

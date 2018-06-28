package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BotonPausa extends Boton {

	public BotonPausa(final MyGdxGame game){
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("botonPausa.png")));
        imageButton = new ImageButton(drawable);

        imageButton.setSize(game.getUnidad()*2 , game.getUnidad()*2);
        imageButton.setPosition(game.getWidth() - imageButton.getWidth(), game.getHeight() - imageButton.getHeight() );

        imageButton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.pantallaMenu);
            }
        });
	}

	public ImageButton getImageButton(){
		return imageButton;
	}
}
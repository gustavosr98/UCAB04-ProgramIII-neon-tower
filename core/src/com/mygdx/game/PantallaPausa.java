package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class PantallaPausa extends Pantalla {

    private Stage stage;
    private BotonPlay botonPlay;
    private BotonReset botonReset;

    public PantallaPausa(final MyGdxGame game) {
        super(game);

        botonPlay = new BotonPlay(game);
        botonReset = new BotonReset(game);

        stage = new Stage();
        stage.addActor(botonPlay.getButton());
        stage.addActor(botonReset.getButton());

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        cls();
        stage.act();
        stage.draw();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public static void cls() {
        Gdx.gl.glClearColor(0, 0, 0, 1.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Javier on 05/07/2018.
 */

public class PantallaGameOver extends Pantalla{

    private Stage stage;
    private BotonReset botonReset;
    private BotonMenu botonMenu;

    public PantallaGameOver(MyGdxGame game) {
        super(game);

        botonReset = new BotonReset(game);
        botonMenu = new BotonMenu(game);
        botonMenu.setX( game.getWidth()/2 - game.getUnidad()*5 - 100);
        botonMenu.setY( game.getHeight()/2 - game.getUnidad()*5/2);

        stage = new Stage();
        stage.addActor(botonReset.getButton());
        stage.addActor(botonMenu.getButton());

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

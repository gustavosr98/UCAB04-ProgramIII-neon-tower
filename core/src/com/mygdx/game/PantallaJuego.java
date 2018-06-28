package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import static com.mygdx.game.Constantes.PPM;


/**
 * Created by Javier on 26/06/2018.
 */

public class PantallaJuego extends Pantalla{
    private final float SCALE = 2.0f;

    private World world;
    private SpriteBatch batch;
    private OrthographicCamera camara;
    private Box2DDebugRenderer b2dr;

    private Board board;
    private Piso piso;

    private BotonPausa botonPausa;
    private Stage stage;


    public PantallaJuego(final MyGdxGame game){
        super (game);

        camara = new OrthographicCamera(game.getWidth(), game.getHeight());
        camara.setToOrtho(false, game.getWidth()/ SCALE, game.getHeight()/SCALE);

        world = new World(new Vector2(0, 10f) , false);
        b2dr = new Box2DDebugRenderer();

        batch = new SpriteBatch();

        board = new Board();
        piso = new Piso(world, game.getUnidad(), game.getWidth(), game.getHeight());

        botonPausa = new BotonPausa(game);

        stage = new Stage();
        stage.addActor(botonPausa.getImageButton());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        cls();

		if(Gdx.input.justTouched()){
			board.nuevoPaquete( world, game.getUnidad(), Gdx.input.getX()  , game.getHeight() - Gdx.input.getY() );
		}

        update(Gdx.graphics.getDeltaTime());

        batch.begin();
        board.draw(batch);
        piso.draw(batch);
        batch.end();


        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height){
        camara.setToOrtho(false, width, height);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    public void reiniciar(){
        camara.position.set(game.getWidth()/2 , game.getWidth()/2,0);
        board.dispose(world);
    }

    public void update(float delta){
        world.step(1/60f, 6, 2);
        board.update();
        cameraUpdate(delta);
        batch.setProjectionMatrix(camara.combined);
        piso.update();
    }

    public void cameraUpdate(float delta){
        camara.update();
    }

    @Override
    public void dispose() {
        b2dr.dispose();

        batch.dispose();
        board.dispose(world);
        piso.dispose(world);
        world.dispose();
    }

    public static void cls() {
        Gdx.gl.glClearColor(0, 0, 0, 1.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}

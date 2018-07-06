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


public class PantallaJuego extends Pantalla{
    private final float SCALE = 2.0f;

    private World world;
    private SpriteBatch batch;
    private MyCamera camara;

    private Board board;
    private Piso piso;

    private Control control;
    private BotonPausa botonPausa;
    private BotonPoder botonPoder;
    private boolean renovarJuego;
    private SistemaPuntuacion score;
    private GameOverListener gameOverListener;

    private Stage stage;


    public PantallaJuego(final MyGdxGame game){
        super (game);

        camara = new MyCamera( game.getWidth(), game.getHeight() , game.getUnidad() );
        camara.setToOrtho(false, game.getWidth()/ SCALE, game.getHeight()/SCALE);

        world = new World(new Vector2(0, 10f) , false);

        batch = new SpriteBatch();

        board = new Board();
        piso = new Piso(world, game.getUnidad(), game.getWidth(), game.getHeight());

        botonPausa = new BotonPausa(game);
        botonPoder = new BotonPoder(game);
        score = new SistemaPuntuacion();
        score.setY(game);
        score.setX(game);
        score.reiniciar();

        gameOverListener = new GameOverListener();
        gameOverListener.setY( piso.getPhisicY() );

        stage = new Stage();
        stage.addActor(botonPausa.getButton());
        stage.addActor(botonPoder.getButton());
        control = new Control(game, stage);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        cls();
        gameOverListener.gameOver(game, board);
        update(Gdx.graphics.getDeltaTime());
        draw();
    }

    @Override
    public void resize(int width, int height){
        camara.setToOrtho(false, width, height);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    public void draw(){
        batch.begin();
        score.draw(batch);
        control.drawContador(batch);
        board.draw(batch);
        piso.draw(batch);
        batch.end();
        stage.draw();
    }

    public void reiniciar(){
        camara.position.set(game.getWidth()/2 , game.getWidth()/2,0);
        board.dispose(world);
        camara.setDesfaceY(0);
        control.reiniciarContador();
        score.reiniciar();
        score.setMultiplicador(1);
    }

    public void update(float delta){
        stage.act();
        world.step(1/60f, 6, 2);
        board.update();
        camara.update();
        piso.update();
        score.desfaceY( camara.getDesfaceY() );
        control.update( board, world, game.getUnidad(), camara, Gdx.input.isTouched(), score);
        score.setMultiplicador( Math.round( camara.getDesfaceY()/game.getUnidad()/3 ) );
        batch.setProjectionMatrix(camara.combined);
        botonPoder.update(board);
        camara.revisarSensor ( board.hayBloqueEntre(8*game.getHeight()/16 - camara.getDesfaceY(), 9*game.getHeight()/16 - camara.getDesfaceY() ) );
        if ( getRenovarJuego() ) {
            camara.position.add(0, -camara.getDesfaceY(), 0);
            setRenovarJuego(false);
        }


    }


    @Override
    public void dispose() {
        batch.dispose();
        score.dispose();
        board.dispose(world);
        piso.dispose(world);
        world.dispose();
    }

    public static void cls() {
        Gdx.gl.glClearColor(0, 0, 0, 1.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void setRenovarJuego(boolean x){
        renovarJuego = x;
    }

    public boolean getRenovarJuego(){
        return renovarJuego;
    }

}

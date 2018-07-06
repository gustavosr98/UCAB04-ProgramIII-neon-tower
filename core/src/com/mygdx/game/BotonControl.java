package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;


public class BotonControl extends Boton {
    private Button.ButtonStyle styleOff;
    private Button.ButtonStyle styleOn;
    private boolean on;
    private int id;
    private ArrayList<BotonControl> vecinos;

    public void setId (int x){
        id = x;
    }

    public int getId (){
        return id;
    }

    public BotonControl(MyGdxGame game, float x, float y){
        setBotonDefault(game, x, y);
        vecinos = new ArrayList<BotonControl>();
    }

    public void enlazar(BotonControl botonVecino){
        vecinos.add(botonVecino);
    }

    public boolean isOn(){
        return on;
    }

    public boolean vecinoOn(){
        boolean x = false;
        for (BotonControl b : vecinos){
            if ( b.isOn() )
                x = true;
        }
        return x;
    }


    public void setBotonDefault(MyGdxGame game, float x, float y){
        TextureRegionDrawable drawableOff = new TextureRegionDrawable(new TextureRegion(new Texture("Bloque2.png")));
        TextureRegionDrawable drawableOn = new TextureRegionDrawable(new TextureRegion(new Texture("Bloque1.png")));
        styleOff = new Button.ButtonStyle(drawableOff ,drawableOff , drawableOff );
        styleOn = new Button.ButtonStyle(drawableOn ,drawableOn , drawableOn );
        button = new Button(styleOff);

        button.setSize(game.getUnidad()*2, game.getUnidad()*2);
        button.setPosition(button.getWidth()*x + button.getWidth()/2, button.getHeight()*y);


        button.addListener(new ClickListener() {

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if ( vecinoOn() )
                    botonPresionado();
            }
        });
    }


    public void botonPresionado(){
        on = true;
        button.setStyle(styleOn);
    }

    public void botonSuelto(){
        on = false;
        button.setStyle(styleOff);
    }

    public Button getButton(){
        return button;
    }
}
